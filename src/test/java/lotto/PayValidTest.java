package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

import lotto.valid.PayValid;

class PayValidTest {

    @Test
    void 금액_입력_안하면_예외_발생() {
        assertThatThrownBy(() -> new PayValid(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액을 입력해 주세요");
    }

    @Test
    void 금액_숫자_아니면_예외_발생() {
        assertThatThrownBy(() -> new PayValid("*#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 숫자여야 합니다");
    }

    @Test
    void 금액_양수_아니면_예외_발생() {
        assertThatThrownBy(() -> new PayValid("-400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 양수여야 합니다");
    }

    @Test
    void 금액_천원단위_아니면_예외_발생() {
        assertThatThrownBy(() -> new PayValid("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1000원 단위여야 합니다.");
    }

}
