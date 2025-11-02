package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    static final int LOTTO_PRICE = 1000;
    private int printTimes;
    List<Lotto> Lottos = new ArrayList<>();

    public LottoMachine(String pay) {
        this.printTimes = Integer.parseInt(pay) / LOTTO_PRICE;
    }

    List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        return lottoNumbers;
    }

    public void makeLottos() {
        for (int i = 0; i < printTimes; i++) {
            Lottos.add(new Lotto(makeLottoNumbers()));
        }
    }

    public void run() {
        makeLottos();
    }

    public String printLottos() {
        return String.join("\n", Lottos.stream().map(Lotto::toString).toList());
    }
}
