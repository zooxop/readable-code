package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    static Stream<Arguments> cellProvider() {
        return Stream.of(
            Arguments.of(new EmptyCell(), false, false),
            Arguments.of(new LandMineCell(), true, false),
            Arguments.of(new NumberCell(1), false, true)
        );
    }

    @DisplayName("Cell 구현체별 '지뢰 여부'와 '주변 지뢰 개수 소지 여부'를 검증한다.")
    @ParameterizedTest
    @MethodSource("cellProvider")
    void validateMagicNumbersOfGameLevel(Cell cell, boolean expectedIsLandMine, boolean expectedHasLandMineCount) {
        assertThat(expectedIsLandMine).isEqualTo(cell.isLandMine());
        assertThat(expectedHasLandMineCount).isEqualTo(cell.hasLandMineCount());
    }

    @DisplayName("각 Cell 구현체 별 Open 여부를 확인할 수 있다.")
    @Test
    void openCell() {
        // given
        Cell emptyCell = new EmptyCell();
        Cell landMineCell = new LandMineCell();
        Cell numberCell = new NumberCell(1);

        // when
        emptyCell.open();
        landMineCell.open();
        numberCell.open();

        //then
        assertThat(emptyCell.isOpened()).isTrue();
        assertThat(landMineCell.isOpened()).isTrue();
        assertThat(numberCell.isOpened()).isTrue();
    }

    @DisplayName("각 Cell 구현체 별 checked 여부를 확인할 수 있다.")
    @Test
    void flagCell() {
        // given
        Cell emptyCell = new EmptyCell();
        Cell landMineCell = new LandMineCell();
        Cell numberCell = new NumberCell(1);

        // when
        emptyCell.open();
        landMineCell.flag();
        numberCell.open();

        // then
        assertThat(emptyCell.isChecked()).isTrue();
        assertThat(landMineCell.isChecked()).isTrue();
        assertThat(numberCell.isChecked()).isTrue();
    }
}