# java-lotto-precourse
## 간단한 로또 발매기🎰

### 주요기능
- 구입 금액에 맞게 자동으로 로또 발매(ex:8000원 -> 8개 구매)
- 임의로 입력받은 당첨 번호와 보너스 번호에 맞게 당첨 확인
- 수익률 계산

### 구현목록
1. input (InputView.java)
2. 유효성 검사 (...Valid.java)
    - 로또 구입 금액 입력
        - 입력 x
        - 숫자 x
        - 양수 x
        - 천 원 단위 x
    - 당첨 번호 문자열 입력
        - 입력 x
        - 숫자 x
        - 구분자 쉼표 x
        - 1 ~ 45 범위 x
        - 당첨 번호 6개 x
        - 당첨 번호 중복 x
    - 보너스 번호 입력
        - 입력 x
        - 숫자 x
        - 1 ~ 45 범위 x
3. 로또 (Lotto.java)
4. 로또 발매기 (LottoMachine.java)
5. 당첨 enum (Win.java)
6. 당첨 결과 (WinResult.java)



