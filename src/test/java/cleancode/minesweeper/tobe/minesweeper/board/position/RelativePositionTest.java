package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RelativePositionTest {

    @DisplayName("올바른 SURROUND_POSITIONS를 갖고 있는지 검증한다.")
    @Test
    void validateRelativePosition() {
        // given
        int expectedSize = 8;

        // when, then
        assertThat(RelativePosition.SURROUND_POSITIONS)
            .hasSize(expectedSize)
            .contains(
                RelativePosition.of(-1, -1),
                RelativePosition.of(-1, 0),
                RelativePosition.of(-1, 1),
                RelativePosition.of(0, -1),
                RelativePosition.of(0, 0),
                RelativePosition.of(1, 1),
                RelativePosition.of(1, 0),
                RelativePosition.of(1, 1)
            );
    }
}