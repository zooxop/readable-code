package cleancode.minesweeper.tobe.minesweeper.gamelevel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameLevelTest {
    static Stream<Arguments> gameLevelProvider() {
        return Stream.of(
            Arguments.of(new VeryBeginner(), 4, 5, 2),
            Arguments.of(new Beginner(), 8, 10, 10),
            Arguments.of(new Middle(), 14, 18, 40),
            Arguments.of(new Advanced(), 20, 24, 99)
        );
    }

    @DisplayName("GameLevel별 'row/col size'와 '지뢰 개수'를 검증한다.")
    @ParameterizedTest
    @MethodSource("gameLevelProvider")
    void validateMagicNumbersOfGameLevel(GameLevel level, int expectedRows, int expectedCols, int expectedMines) {
        assertThat(expectedRows).isEqualTo(level.getRowSize());
        assertThat(expectedCols).isEqualTo(level.getColSize());
        assertThat(expectedMines).isEqualTo(level.getLandMineCount());
    }
}

/**
 * 고민점)
 * 단순히 매직넘버를 제거하기 위해, GameLevel 을 구현한 각 구현체들이 갖고 있는 매직 넘버들을 상수로 선언하도록 변경하고,
 * 테스트코드에서는 그 상수들을 직접 참조하여 테스트를 수행하는 것이 과연 의미가 있는 행위일까?
 *
 * 테스트 코드 작성 의도)
 * 각 구현체들이 갖고 있는 매직넘버들은 상수를 선언하여 사용하는 것 만큼 의미가 있는 수준의 코드라고 판단,
 * 만약 추후에 해당 매직넘버가 실수로든 의도적이든 변경이 된다면, 이 테스트 코드가 깨지도록 하는 것이
 * 도메인 로직 검증으로서의 의미를 갖는다고 생각하였음.
 * 따라서, 각 구현체들이 갖고 있는 레벨별 row, col, landMineCount 값들에 대한 매직넘버를 동일하게 이 코드에서도
 * 사용하여 테스트를 수행하도록 작성하였음.
 */