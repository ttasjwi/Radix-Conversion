import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LogicGateTest {

    @Test
    @DisplayName("AND 테스트")
    void and_Test() {
        //when
        boolean result1 = LogicGate.and(true, true);
        boolean result2 = LogicGate.and(true, false);
        boolean result3 = LogicGate.and(false, true);
        boolean result4 = LogicGate.and(false, false);

        //then
        assertThat(result1).isEqualTo(true).as("두 인자가 true일때만 true가 반환되어야한다.");
        assertThat(result2).isEqualTo(false).as("두 인자가 true일때만 true가 반환되어야한다.");
        assertThat(result3).isEqualTo(false).as("두 인자가 true일때만 true가 반환되어야한다.");
        assertThat(result4).isEqualTo(false).as("두 인자가 true일때만 true가 반환되어야한다.");
    }
}