package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LandMineCellTest {
    private LandMineCell landMineCell;

    @DisplayName("LandMineCell을 open 할 수 있다.")
    @Test
    void openLandMineCell() {
        // given
        landMineCell = new LandMineCell();

        // when
        landMineCell.open();

        // then
        assertThat(landMineCell.isOpened()).isTrue();
        assertThat(landMineCell.isChecked()).isFalse();
    }

    @DisplayName("LandMineCell에 깃발을 꽂을 수 있다.")
    @Test
    void flagLandMineCell() {
        // given
        landMineCell = new LandMineCell();

        // when
        landMineCell.flag();

        // then
        assertThat(landMineCell.isOpened()).isFalse();
        assertThat(landMineCell.isChecked()).isTrue();
    }

    @DisplayName("LandMineCell이 초기 상태일 때, '확인 전' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenUnchecked() {
        // given
        landMineCell = new LandMineCell();

        // when

        // then
        CellSnapshot snapshot = landMineCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofUnchecked());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.UNCHECKED);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }

    @DisplayName("LandMineCell이 열려있을 때, '지뢰' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenOpened() {
        // given
        landMineCell = new LandMineCell();

        // when
        landMineCell.open();

        // then
        CellSnapshot snapshot = landMineCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofLandMine());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.LAND_MINE);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }

    @DisplayName("LandMineCell에 깃발이 꽂혀있을 때, '깃발 상태' CellSnapshot을 가져올 수 있다.")
    @Test
    void getCellSnapshotWhenFlagged() {
        // given
        landMineCell = new LandMineCell();

        // when
        landMineCell.flag();

        // then
        CellSnapshot snapshot = landMineCell.getSnapshot();
        assertThat(snapshot).isEqualTo(CellSnapshot.ofFlag());
        assertThat(snapshot.getStatus()).isEqualTo(CellSnapshotStatus.FLAG);
        assertThat(snapshot.getNearByLandMineCount()).isZero();
    }
}
