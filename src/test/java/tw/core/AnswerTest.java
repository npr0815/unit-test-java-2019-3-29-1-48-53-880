package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    private Answer answer = new Answer();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void should_execute_createAnswer_method()throws Exception{
        Object[] result = answer.createAnswer("1 2 3 4").getNumList().toArray();
        String [] array = {"1","2","3","4"};
        assertArrayEquals(result,array);
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_execute_validate_method()throws Exception{
        Answer answer = mock(Answer.class);
        answer.setNumList(Arrays.asList("1","2","3","10"));
        doThrow(new OutOfRangeAnswerException("Answer format is incorrect")).when(answer).validate();
        answer.validate();
    }

    @Test
    public void should_execute_check_method() {
        Answer inputAnswer = mock(Answer.class);
        Answer answer = mock(Answer.class);
        inputAnswer.setNumList(Arrays.asList("1","2","3","4"));
        answer.check(inputAnswer);
        verify(answer,times(1)).check(inputAnswer);
    }

    @Test
    public void should_execute_getIndexOfNum_method() {
        String num = "1";
        answer.setNumList(Arrays.asList("1","2","3","4"));
        assertEquals(answer.getIndexOfNum("1"),0);
    }
}