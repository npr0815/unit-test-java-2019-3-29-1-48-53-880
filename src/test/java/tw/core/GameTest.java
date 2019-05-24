package tw.core;

import org.junit.Test;
import tw.core.generator.AnswerGenerator;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    @Test
    public void should_execute_guess_method() throws Exception {
        Answer inputAnswer = new Answer();
        inputAnswer.setNumList(Arrays.asList("1", "2", "3", "4"));
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Answer actualAnswer = new Answer();
        actualAnswer.setNumList(Arrays.asList("1", "2", "3", "4"));
        when(answerGenerator.generate()).thenReturn(actualAnswer);

        Game game = new Game(answerGenerator);

        verify(answerGenerator).generate();
        assertEquals(game.guess(inputAnswer).getResult(),"4A0B");
        assertEquals(game.guess(inputAnswer).getInputAnswer().toString(),"1 2 3 4");
    }

    @Test
    public void should_execute_guessHistory_method() {
        Game game = mock(Game.class);
        assertTrue(game.guessHistory() instanceof List);
    }

    @Test
    public void should_execute_checkCoutinue_method() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Game game = new Game(answerGenerator);
        assertTrue(game.checkCoutinue());
    }

    @Test
    public void should_execute_checkStatus_method() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        Game game = new Game(answerGenerator);
        assertEquals(game.checkStatus(), "continue");
    }
}
