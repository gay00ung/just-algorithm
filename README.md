# just-algorithm

Kotlin 기반 백준 문제 풀이용 템플릿입니다. CLASS/유형별 체크리스트와 빠른 입·출력 유틸을 제공하여 문제 풀이에 바로 집중할 수 있습니다.

## 구성 요약
- `baekjoon/common` · `FastScanner`와 `FastWriter`로 표준 입·출력을 빠르게 처리합니다.
- `baekjoon/runner/Runner.kt` · `./gradlew :baekjoon:run --args="2557"`처럼 문제 번호만으로 실행합니다.
- `docs/checklists` · CLASS 단계별로 풀어야 할 우선순위 문제 목록을 체크리스트로 정리했습니다.
- `testcases/<문제번호>` · 샘플 입·출력 파일을 보관하여 회귀 테스트를 쉽게 합니다.
- `scripts` · 실행/검증 자동화를 돕는 보조 스크립트가 들어 있습니다.

## 사용 방법
1. 새로운 문제 파일은 `baekjoon/p<문제번호>/Main.kt` 형태로 생성합니다.
2. 실행: `./gradlew :baekjoon:run --args="1000"`
   - 혹은 `./gradlew runProblem -PproblemId=1000` (별도 Gradle 태스크) 사용.
3. 테스트 케이스가 있다면 `scripts/check_cases.sh 1000`으로 모든 샘플을 검증합니다.
4. 풀이 노트는 `docs/checklists`에 있는 체크박스를 업데이트하며 진행 상황을 관리합니다.

## TODO
- CLASS 6 이후 Gold~Platinum 단계 문제도 동일한 형식으로 확장하세요.
- 테스트 케이스 자동 수집 및 정리 자동화를 위한 추가 스크립트를 작성해도 좋습니다.
