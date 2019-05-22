package tw.core;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    @Test
    public void should_execute_guess_method() throws Exception{
        Game game = mock(Game.class);
        Answer answer = mock(Answer.class);
        game.guess(answer);
        verify(game).guess(answer);
    }

    @Test
    public void should_execute_guessHistory_method() {
        Game game = mock(Game.class);
        assertTrue(game.guessHistory() instanceof List);
    }

    @Test
    public void should_execute_checkCoutinue_method() {
        Game game = mock(Game.class);
        when(game.checkStatus()).thenReturn("CONTINUE");
        game.checkCoutinue();
        verify(game).checkCoutinue();
    }

    @Test
    public void should_execute_checkStatus_method() {
        Game game = mock(Game.class);
        game.checkStatus();
        verify(game).checkStatus();
    }
}
