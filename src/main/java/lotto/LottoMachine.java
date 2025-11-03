package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    static final int LOTTO_PRICE = 1000;
    private final int printTimes;
    List<Lotto> Lottos = new ArrayList<>();

    public LottoMachine(String pay) {
        this.printTimes = Integer.parseInt(pay) / LOTTO_PRICE;
    }

    List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        return lottoNumbers.stream().sorted().toList();
    }

    public List<Lotto> makeLottos() {
        for (int i = 0; i < printTimes; i++) {
            Lottos.add(new Lotto(makeLottoNumbers()));
        }
        return Lottos;
    }

    public String printLottos() {
        return String.join("\n", Lottos.stream().map(Lotto::toString).toList());
    }

    public void printResult() {
        System.out.println("");
        System.out.println(printTimes + "개를 구매했습니다.");
        System.out.println(printLottos());
    }
}
