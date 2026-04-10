package ch.zhaw.iwi.devops.demo;
public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    public boolean validate(String password) {
        boolean isLongEnough = password.length() >= MIN_LENGTH;
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        return isLongEnough && hasUpperCase;
    }
    public boolean hasNumber(String password) {
        return password.matches(".*\\d.*");
    }
}