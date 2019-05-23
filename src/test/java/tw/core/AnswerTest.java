package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void should_execute_createAnswer_method()throws Exception{
        Answer answer = new Answer();
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
        Answer inputAnswer = new Answer();
        inputAnswer.setNumList(Arrays.asList("1","3","2","4"));
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1","2","3","4"));
        assertEquals(answer.check(inputAnswer).getValue(),"2A2B");
    }

    @Test
    public void should_execute_getIndexOfNum_method() {
        Answer answer = new Answer();
        answer.setNumList(Arrays.asList("1","2","3","4"));
        assertEquals(answer.getIndexOfNum("1"),0);
    }
}