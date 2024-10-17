package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmptyCellTest {
    private EmptyCell emptyCell;

    @DisplayName("EmptyCell을 open 할 수 있다.")
    @Test
    void openEmptyCell() {
        // given
        emptyCell = new EmptyCell();

        // when
        emptyCell.open();

        // then
        assertThat(emptyCell.isOpened()).isTrue();
        assertThat(emptyCell.isChecked()).isTrue();
    }

    @DisplayName("EmptyCell에 깃발을 꽂을 수 있다.")
    @Test
    void flagEmptyCell() {
        // given
        emptyCell = new EmptyCell();

        // when
        emptyCell.flag();

        // then
        assertThat(emptyCell.isOpened()).isFalse();
        assertThat(emptyCell.isChecked()).isFalse();
    }

    @DisplayName("EmptyCell이 초기 상태일 때, '확인 전' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenUnchecked() {
        // given
        emptyCell = new EmptyCell();

        // when

        // then
        CellSnapshot snapshot = emptyCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofUnchecked());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.UNCHECKED);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }

    @DisplayName("EmptyCell이 열려있을 때, '비어있는' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenOpened() {
        // given
        emptyCell = new EmptyCell();

        // when
        emptyCell.open();

        // then
        CellSnapshot snapshot = emptyCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofEmpty());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.EMPTY);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }

    @DisplayName("EmptyCell에 깃발이 꽂혀있을 때, '깃발 상태' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenFlagged() {
        // given
        emptyCell = new EmptyCell();

        // when
        emptyCell.flag();

        // then
        CellSnapshot snapshot = emptyCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofFlag());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.FLAG);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }
}
