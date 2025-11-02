package lotto.valid;

public class BonusNumberValid {

    private String bonusNumber;
    private int number;

    final String ERROR_BONUS_EMPTY_MESSAGE = "[ERROR] 보너스 번호를 입력해 주세요.";
    final String ERROR_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    final String ERROR_BONUS_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public BonusNumberValid(String bonusNumber) {
        isEmpty();
        isNum();
        isRange();
    }

    void isEmpty() {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BONUS_EMPTY_MESSAGE);
        }
    }

    void isNum() {
        try {
            number = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_MESSAGE);
        }
    }

    void isRange() {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_BONUS_RANGE_MESSAGE);
        }
    }
}
