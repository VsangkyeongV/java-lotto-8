package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinResult {

    private String winningNumbers;
    private List<Integer> parsedWinningNumbers;
    private int bonusNumber;
    private static Map<Win, Integer> wins = new TreeMap<>(Comparator.comparingInt(Enum::ordinal));

    boolean hasBonus;
    long matchCount;

    public WinResult(String winningNumbers, String bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
        parseWinningNumbers();
    }

    public void parseWinningNumbers() {
        parsedWinningNumbers = Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

    }

    public void countMatches(List<Lotto> lottos) {

        lottos.stream().forEach(lotto -> {
            matchCount = lotto.getNumbers().stream()
                    .filter(parsedWinningNumbers::contains)
                    .count();
            hasBonus = false;

            if (matchCount == 5) {
                hasBonus = lotto.getNumbers().contains(bonusNumber);
            }

            makeWins((int) matchCount, hasBonus);
        });

    }

    public void makeWins(int matchCount, boolean hasBonus) {
        for (Win win : Win.values()) {
            if (win.getMatchCount() == matchCount && win.isHasBonus() == hasBonus) {
                wins.merge(win, 1, Integer::sum);
            }
        }

    }

    public String printWins() {
        StringBuilder result = new StringBuilder();

        for (Win win : Win.values()) {
            int count = wins.getOrDefault(win, 0);
            result.append(String.format(appendFormat(win),
                    win.getMatchCount(),
                    win.getPrize(),
                    count));
        }

        return result.toString();
    }

    public static String appendFormat(Win win) {
        if (win == Win.SECOND) {
            return ("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n");
        }
        return ("%d개 일치 (%,d원) - %d개\n");
    }

    public String printProfitRate(int pay) {
        int totalPrize = wins.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        double profitRate = (double) totalPrize / pay * 100;

        return String.format("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
