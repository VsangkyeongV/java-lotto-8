package lotto.valid;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersValid {

    private String winningNumbers;
    private List<Integer> numbers;

    final String ERROR_WINNING_NUMBERS_EMPTY_MESSAGE = "[ERROR] 당첨 번호를 입력해 주세요.";
    final String ERROR_WINNING_NUMBERS_COMMA_MESSAGE = "[ERROR] 당첨 번호는 쉼표(,)로 구분해 주세요.";
    final String ERROR_WINNING_NUMBERS_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    final String ERROR_WINNING_NUMBERS_RANGE_MESSAGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    final String ERROR_WINNING_NUMBERS_SIZE_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    final String ERROR_WINNING_NUMBERS_DUPLICATE_MESSAGE = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";

    public WinningNumbersValid(String winningNumbers) {
        this.winningNumbers = winningNumbers;
        isEmpty();
        isComma();
        isNum();
        isRange();
        isSix();
        isDuplicate();
    }

    void isEmpty() {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_EMPTY_MESSAGE);
        }
    }

    void isComma() {
        if (!winningNumbers.contains(",")) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COMMA_MESSAGE);
        }
    }

    void isNum() {
        try {
            numbers = Arrays.stream(winningNumbers.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_NUMBER_MESSAGE);
        }
    }

    void isRange() {
        numbers.forEach((number) -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_RANGE_MESSAGE);
            }
        });
    }

    void isSix() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_SIZE_MESSAGE);
        }
    }

    void isDuplicate() {
        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_DUPLICATE_MESSAGE);
        }
    }
}
