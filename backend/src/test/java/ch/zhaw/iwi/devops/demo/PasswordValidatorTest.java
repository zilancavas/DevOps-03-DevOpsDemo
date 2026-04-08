package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    public void testPasswordTooShort() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.validate("abc"));
    }
@Test
public void testPasswordNoUpperCase() {
    PasswordValidator validator = new PasswordValidator();
    assertFalse(validator.validate("abcdefgh"));
}
}
