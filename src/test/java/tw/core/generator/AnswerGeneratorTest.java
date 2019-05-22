package tw.core.generator;

import org.junit.Test;
import tw.core.Answer;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    @Test
    public void should_execute_generate_method() throws Exception{
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9,4)).thenReturn("4 3 2 5");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        assertTrue(answerGenerator.generate() instanceof Answer);
    }
}

