package lotto;

import java.util.List;

import lotto.valid.BonusNumberValid;
import lotto.valid.PayValid;
import lotto.valid.WinningNumbersValid;
import lotto.view.InputView;

public class Application {

    private final InputView inputView = new InputView();

    void run() {
        String pay;
        while (true) {
            try {
                pay = inputView.readPay();
                new PayValid(pay);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoMachine lottoMachine = new LottoMachine(pay);
        List<Lotto> lottos = lottoMachine.makeLottos();
        lottoMachine.printResult();

        String winningNumbers;
        while (true) {
            try {
                winningNumbers = inputView.readWinningNumbers();
                new WinningNumbersValid(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String bonusNumber;
        while (true) {
            try {
                bonusNumber = inputView.readBonusNumber();
                new BonusNumberValid(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        WinResult winResult = new WinResult(winningNumbers, bonusNumber);
        winResult.parseWinningNumbers();
        winResult.countMatches(lottos);

        System.out.println("\n당첨 통계\n---\n");
        System.out.print(winResult.printWins());
        System.out.println(winResult.printProfitRate(Integer.parseInt(pay)));
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
