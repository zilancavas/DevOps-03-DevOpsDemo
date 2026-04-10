package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class PasswordValidatorTest {
    @Test
    void testPasswordTooShort() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.validate("abc"));
    }
    @Test
    void testPasswordNoUpperCase() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.validate("abcdefgh"));
    }
    @Test
    void testPasswordValid() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.validate("Abcdefgh"));
    }
    @Test
    void testPasswordHasNumber() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.hasNumber("abc123"));
    }
}