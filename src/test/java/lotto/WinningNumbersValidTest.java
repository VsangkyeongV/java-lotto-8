package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import lotto.valid.WinningNumbersValid;

class WinningNumbersValidTest {

    @Test
    void 당첨_번호_입력_안하면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbersValid(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호를 입력해 주세요");
    }

    @Test
    void 당첨_번호_쉼표_구분자_아니면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbersValid(
                "1.2;3/4'5[6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 쉼표(,)로 구분해 주세요");
    }

    @Test
    void 당첨_번호_숫자_아니면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbersValid("1,2,3,*,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 숫자여야 합니다");
    }

    @Test
    void 당첨_번호_범위_벗어나면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbersValid("-1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1부터 45 사이의 숫자여야 합니다");
    }

    @Test
    void 당첨_번호_6개_아니면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbersValid("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야 합니다");
    }

}
