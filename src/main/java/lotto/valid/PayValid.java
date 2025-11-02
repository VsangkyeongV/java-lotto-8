package lotto.valid;

public class PayValid {

    private String pay;
    private int amount;
    final String ERROR_PAY_EMPTY_MESSAGE = "[ERROR] 금액을 입력해 주세요.";
    final String ERROR_PAY_NUMBER_MESSAGE = "[ERROR] 금액은 숫자여야 합니다.";
    final String ERROR_PAY_POSITIVE_MESSAGE = "[ERROR] 금액은 양수여야 합니다.";
    final String ERROR_PAY_THOUSAND_MESSAGE = "[ERROR] 금액은 1000원 단위여야 합니다.";

    public PayValid(String pay) {
        this.pay = pay;
        isEmpty();
        isNum();
        isPositive();
        isThousand();
    }

    void isEmpty() {
        if (pay == null || pay.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PAY_EMPTY_MESSAGE);
        }
    }

    void isNum() {
        try {
            amount = Integer.parseInt(pay);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PAY_NUMBER_MESSAGE);
        }
    }

    void isPositive() {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_PAY_POSITIVE_MESSAGE);
        }
    }

    void isThousand() {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PAY_THOUSAND_MESSAGE);
        }
    }

}
