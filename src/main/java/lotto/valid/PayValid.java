package lotto.valid;

public class PayValid {

    int amount;
    final String ERROR_EMPTY_MESSAGE = "[ERROR] 금액을 입력해 주세요.";
    final String ERROR_NUMBER_MESSAGE = "[ERROR] 금액은 숫자여야 합니다.";
    final String ERROR_POSITIVE_MESSAGE = "[ERROR] 금액은 양수여야 합니다.";
    final String ERROR_THOUSAND_MESSAGE = "[ERROR] 금액은 1000원 단위여야 합니다.";

    public void run(String pay) {
        isEmpty(pay);
        isNum(pay);
        isPositive(amount);
        isThousand(amount);
    }

    void isEmpty(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_MESSAGE);
        }
    }

    void isNum(String str) {
        try {
            amount = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }

    void isPositive(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(ERROR_POSITIVE_MESSAGE);
        }
    }

    void isThousand(int num) {
        if (num < 1000 || num % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_THOUSAND_MESSAGE);
        }
    }

}
