# Testcases

문제 번호별로 `testcases/<problemId>/case<n>.in` / `.out`을 짝으로 보관합니다. `scripts/check_cases.sh` 스크립트가 자동으로 입력을 주입하고 기대 출력과 비교합니다.

예시 구조:

```
testcases/
  1000/
    case1.in
    case1.out
```

새 케이스를 추가할 때는 번호를 증가시키면 됩니다. 출력 검증은 `diff -u`로 수행합니다.
