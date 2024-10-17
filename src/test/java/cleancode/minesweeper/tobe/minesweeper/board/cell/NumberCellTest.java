package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCellTest {
    private NumberCell numberCell;
    private static final int NEAR_BY_MINE_COUNT = 3;

    @DisplayName("NumberCell을 open 할 수 있다.")
    @Test
    void openNumberCell() {
        // given
        numberCell = new NumberCell(NEAR_BY_MINE_COUNT);

        // when
        numberCell.open();

        // then
        assertThat(numberCell.isOpened()).isTrue();
        assertThat(numberCell.isChecked()).isTrue();
    }

    @DisplayName("NumberCell에 깃발을 꽂을 수 있다.")
    @Test
    void flagNumberCell() {
        // given
        numberCell = new NumberCell(NEAR_BY_MINE_COUNT);

        // when
        numberCell.flag();

        // then
        assertThat(numberCell.isOpened()).isFalse();
        assertThat(numberCell.isChecked()).isFalse();
    }

    @DisplayName("NumberCell이 초기 상태일 때, '확인 전' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenUnchecked() {
        // given
        numberCell = new NumberCell(NEAR_BY_MINE_COUNT);

        // when

        // then
        CellSnapshot snapshot = numberCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofUnchecked());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.UNCHECKED);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }

    @DisplayName("NumberCell이 열려있을 때, '숫자' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenOpened() {
        // given
        numberCell = new NumberCell(NEAR_BY_MINE_COUNT);

        // when
        numberCell.open();

        // then
        CellSnapshot snapshot = numberCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofNumber(NEAR_BY_MINE_COUNT));
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.NUMBER);
        assertThat(snapshot.getNearByLandMineCount()).isEqualTo(NEAR_BY_MINE_COUNT);
    }

    @DisplayName("NumberCell에 깃발이 꽂혀있을 때, '깃발 상태' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenFlagged() {
        // given
        numberCell = new NumberCell(NEAR_BY_MINE_COUNT);

        // when
        numberCell.flag();

        // then
        CellSnapshot snapshot = numberCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofFlag());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.FLAG);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }
}
