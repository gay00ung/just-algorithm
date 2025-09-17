#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")"/.. && pwd)"
GRADLEW="$ROOT_DIR/gradlew"

if [[ $# -lt 1 ]]; then
  echo "Usage: scripts/run_problem.sh <problemId> [inputFile]" >&2
  echo "Example: scripts/run_problem.sh 1000 testcases/1000/case1.in" >&2
  exit 1
fi

problem_id="${1#p}"
shift

if [[ $# -gt 0 ]]; then
  input_file="$1"
  if [[ ! -f "$input_file" ]]; then
    echo "Input file '$input_file' not found" >&2
    exit 1
  fi
  "$GRADLEW" :baekjoon:run --args="$problem_id" < "$input_file"
else
  "$GRADLEW" :baekjoon:run --args="$problem_id"
fi
