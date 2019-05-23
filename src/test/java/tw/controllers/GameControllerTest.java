package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        Game game = mock(Game.class);
        GameView gameView = mock(GameView.class);
        GameController gameController = new GameController(game, gameView);

        gameController.beginGame();

        verify(gameView).showBegin();
    }

    @Test
    public void shoule_execute_play_method()throws Exception{
        GuessInputCommand command = mock(GuessInputCommand.class);
        Game game = mock(Game.class);
        GameView gameView = mock(GameView.class);
        Answer answer = new Answer();
        GuessResult guessResult = new GuessResult("",answer);

        when(game.checkCoutinue()).thenReturn(true).thenReturn(false);
        when(command.input()).thenReturn(answer);
        when(game.guess(answer)).thenReturn(guessResult);

        GameController gameController = new GameController(game, gameView);
        gameController.play(command);

        verify(game, times(2)).checkCoutinue();
        verify(game).guess(answer);
        verify(command).input();
        verify(gameView).showGuessResult(guessResult);
        verify(gameView).showGuessHistory(game.guessHistory());
        verify(gameView).showGameStatus(game.checkStatus());
    }
}