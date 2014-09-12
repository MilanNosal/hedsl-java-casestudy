package entities.language.metamodel.constraints;

import entities.language.metamodel.Type;

/**
 * Regular expression constraint.
 */
public class Regex extends Constraint {
    /**
     * Regular expression that has to be matched by a string.
     */
    private final String regex;

    public Regex(String regex) {
        this.regex = regex.substring(1, regex.length() - 1);
    }

    public String getRegex() {
        return regex;
    }

    @Override
    public String toString() {
        return "regex regex=" + regex;
    }

    @Override
    public boolean supportsType(Type type) {
        return type.equals(Type.STRING);
    }
}
