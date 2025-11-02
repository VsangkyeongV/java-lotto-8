package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import lotto.valid.BonusNumberValid;

public class BonusNumberValidTest {

    @Test
    void 보너스_번호_입력_안하면_예외_발생() {
        assertThatThrownBy(() -> new BonusNumberValid(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호를 입력해 주세요");
    }

    @Test
    void 보너스_번호_숫자_아니면_예외_발생() {
        assertThatThrownBy(() -> new BonusNumberValid("**"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 숫자여야 합니다");
    }

    @Test
    void 보너스_번호_범위_벗어나면_예외_발생() {
        assertThatThrownBy(() -> new BonusNumberValid("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다");
    }
}
