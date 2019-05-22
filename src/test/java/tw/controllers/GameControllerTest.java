package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.GuessInputCommand;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_show_begin_information() throws Exception{
        GameView gameView = new GameView();
        gameView.showBegin();
        assertThat(systemOut()).isEqualTo("------Guess Number Game, You have 6 chances to guess!  ------\r\n");
    }

    @Test
    public void shoule_execute_play_method()throws Exception{
        GameController gameController = mock(GameController.class);
        GuessInputCommand guessInputCommand = mock(GuessInputCommand.class);
        gameController.play(guessInputCommand);
            verify(gameController,times(1)).play(guessInputCommand);
    }
}