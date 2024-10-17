package cleancode.minesweeper.tobe.minesweeper.board;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Beginner;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.GameLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {
    GameLevel gameLevel = new Beginner();
    GameBoard gameBoard;

    @BeforeEach
    void setUp() {
        gameBoard = new GameBoard(gameLevel);
        gameBoard.initializeGame();
    }

    @DisplayName("게임 초기화를 할 수 있다.")
    @Test
    void initializeGame() {
        // given

        // when

        // then
        assertThat(gameBoard.isInProgress()).isTrue();
        assertThat(gameBoard.isWinStatus()).isFalse();
        assertThat(gameBoard.isLoseStatus()).isFalse();
    }

    @DisplayName("원하는 위치에 깃발을 꽂을 수 있다.")
    @Test
    void flagAt() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);

        // when
        gameBoard.flagAt(cellPosition);

        // then
        CellSnapshot snapshot = gameBoard.getSnapshot(cellPosition);
        assertThat(snapshot).isEqualTo(CellSnapshot.ofFlag());
    }

    @DisplayName("CellPosition 의 유효성을 검증할 수 있다.")
    @Test
    void validateCellPosition() {
        // given
        CellPosition cellPosition = CellPosition.of(8, 10);

        // when
        boolean invalidCellPosition = gameBoard.isInvalidCellPosition(cellPosition);

        // then
        assertThat(invalidCellPosition).isTrue();
    }

    /**
     * TODO: [리팩토링 필요]
     * 현재 구조는 GameBoard 의 LandMineCell 위치가 랜덤으로 생성되도록 되어 있는데,
     * 이 랜덤 값을 생성해주는 `CellPositions` 객체를 GameBoard 내부에서 직접 초기화 해서 사용하고 있다.
     * 따라서, 특정 포지션을 open 하는 테스트는 작성하기 어려운 상태임.
     *
     * 테스트를 하기 위해서는, CellPositions.extractRandomPositions 시그니처를 `RandomPositionCreatable` 인터페이스로
     * 추상화 하고, 이 인터페이스를 GameBoard 가 외부로부터 주입받도록(DI) 구조를 변경해야 할 것으로 생각한다.
     *
     * 기타 다른 GameBoard 의 메서드들도 마찬가지로, 랜덤 요소를 DI 구조로 리팩토링 하기 전까지는 테스트를 작성하기
     * 어려울 것으로 보임.
     */
//    @DisplayName("원하는 위치의 Cell을 Open 할 수 있다.")
//    @Test
//    void openAt() {
//        // given
//        CellPosition cellPosition = CellPosition.of(0, 0);
//
//        // when
//        gameBoard.openAt(cellPosition);
//
//        // then
//        CellSnapshot snapshot = gameBoard.getSnapshot(cellPosition);
//        assertThat(snapshot).isEqualTo(CellSnapshot.ofEmpty());
//    }
}