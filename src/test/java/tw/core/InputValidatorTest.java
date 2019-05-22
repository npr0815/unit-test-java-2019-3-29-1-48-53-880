package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static junit.framework.TestCase.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    @Test
    public void should_execute_validate_method_when_return_String() {
        InputValidator inputValidator = new InputValidator();
        String numStr = "1 2 3 4";
        assertTrue(inputValidator.validate(numStr));
    }
}
