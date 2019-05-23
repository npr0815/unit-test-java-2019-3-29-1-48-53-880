package tw.core;


import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    @Test
    public void should_execute_generateNums_when_throw_IllegalArgumentException() {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        randomIntGenerator.generateNums(1,2);
        doThrow(new IllegalArgumentException("Can't ask for more numbers than are available")).when(randomIntGenerator).generateNums(1,2);
    }

    @Test
    public void should_execute_generateNums_normal() {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        assertEquals(randomIntGenerator.generateNums(2,1),"1");
    }
}