package baseball;

import baseball.BaseBallGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {
    @Test
    void DTO를_입력받아_결과값을_출력() {
        //given
        GameController gc = new GameController();
        BaseballGameResultDto testDto = new BaseballGameResultDto(1, 2, false);

        //when
        String result = gc.printResult(testDto);

        //then
        assertThat(result).isEqualTo("2볼 1스트라이크 ");
    }


    @Test
    void 사용자의_정답을_입력받아_결과값_출력() {
        //given
        //answer is "137"
        int[] testAnswer = {0, 1, 0, 2, 0, 0, 0, 3, 0, 0};

        BaseBallGame firstGame = new BaseBallGame(3);
        GameController gc = new GameController();

        //when
        firstGame.useCustomAnswer(testAnswer);

        //then
        assertThat(gc.printResult(firstGame.submitAnswer("713"))).isEqualTo("3볼 ");
        assertThat(gc.printResult(firstGame.submitAnswer("731"))).isEqualTo("2볼 1스트라이크 ");
        assertThat(gc.printResult(firstGame.submitAnswer("986"))).isEqualTo("낫싱");
        assertThat(gc.printResult(firstGame.submitAnswer("137"))).isEqualTo("3스트라이크 ");
    }
}
