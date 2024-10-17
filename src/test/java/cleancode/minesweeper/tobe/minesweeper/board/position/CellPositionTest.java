package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CellPositionTest {

    @DisplayName("생성자가 넘겨받은 rowIndex 또는 colIndex의 유효성을 검사한다.")
    @Test
    void validateRowAndColFromConstructor() {
        // given
        int rowIndex1 = 0;
        int colIndex1 = 0;

        int rowIndex2 = 0;
        int colIndex2 = -1;

        int rowIndex3 = -1;
        int colIndex3 = 0;

        // when, then
        assertThat(CellPosition.of(rowIndex1, colIndex1)).isNotNull();

        assertThatThrownBy(() -> CellPosition.of(rowIndex2, colIndex2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바르지 않은 좌표입니다.");

        assertThatThrownBy(() -> CellPosition.of(rowIndex3, colIndex3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바르지 않은 좌표입니다.");
    }

    @DisplayName("움직일 수 있는 주변 좌표의 CellPosition을 가져올 수 있다.")
    @Test
    void getCellPositionThatCanMove() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition validRelativePosition = RelativePosition.of(1, 1);

        // when
        CellPosition calculatedPosition = cellPosition.calculatePositionBy(validRelativePosition);

        // then
        assertThat(calculatedPosition.getRowIndex()).isEqualTo(1);
        assertThat(calculatedPosition.getColIndex()).isEqualTo(1);
    }

    @DisplayName("움직일 수 없는 주변 좌표 여부를 계산할 수 있다.")
    @Test
    void calculateCannotMovePosition() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition invalidRelativePosition = RelativePosition.of(-1, -1);

        // when, then
        assertThatThrownBy(() -> cellPosition.calculatePositionBy(invalidRelativePosition))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("움직일 수 있는 좌표가 아닙니다.");
    }
}