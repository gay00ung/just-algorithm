#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")"/.. && pwd)"
GRADLEW="$ROOT_DIR/gradlew"

if [[ $# -lt 1 ]]; then
  echo "Usage: scripts/check_cases.sh <problemId>" >&2
  exit 1
fi

problem_id="${1#p}"
case_dir="$ROOT_DIR/testcases/$problem_id"

if [[ ! -d "$case_dir" ]]; then
  echo "No testcase directory at $case_dir" >&2
  exit 1
fi

status=0
for input in "$case_dir"/*.in; do
  [[ -e "$input" ]] || continue
  case_name="$(basename "$input" .in)"
  expected="$case_dir/$case_name.out"
  if [[ ! -f "$expected" ]]; then
    echo "Missing expected output for $case_dir/$case_name.out" >&2
    status=1
    continue
  fi
  actual="$(mktemp)"
  trap 'rm -f "$actual"' EXIT
  if ! "$GRADLEW" :baekjoon:run --args="$problem_id" < "$input" > "$actual"; then
    echo "Execution failed for $case_name" >&2
    status=1
  elif ! diff -u "$expected" "$actual" >/dev/null; then
    echo "❌ $case_name failed"
    diff -u "$expected" "$actual" || true
    status=1
  else
    echo "✅ $case_name passed"
  fi
  rm -f "$actual"
  trap - EXIT
done

exit $status
