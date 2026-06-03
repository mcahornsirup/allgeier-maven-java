package ch.allgeier.maven.java.tests;

import ch.allgeier.maven.java.tasks.PasswordPolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordPolicyTest {

    @Test
    void acceptsValidPassword() {
        assertTrue(PasswordPolicy.isValid("Sprint2026!"));
    }

    @Test
    void rejectsPasswordWithoutUppercaseLetter() {
        assertFalse(PasswordPolicy.isValid("sprint2026!"));
    }

    @Test
    void rejectsPasswordWithoutLowercaseLetter() {
        assertFalse(PasswordPolicy.isValid("SPRINT2026!"));
    }

    @Test
    void rejectsPasswordWithoutDigit() {
        assertFalse(PasswordPolicy.isValid("SprintTest!"));
    }

    @Test
    void rejectsPasswordWithoutSpecialCharacter() {
        assertFalse(PasswordPolicy.isValid("Sprint2026"));
    }

    @Test
    void rejectsPasswordShorterThanTenCharacters() {
        assertFalse(PasswordPolicy.isValid("Test2026!"));
    }

    @Test
    void rejectsNullPassword() {
        assertFalse(PasswordPolicy.isValid(null));
    }
}
