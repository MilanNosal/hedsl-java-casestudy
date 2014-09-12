package entities.language.metamodel.constraints;

import entities.language.metamodel.Type;

/**
 * Sets a constraint upon length of a string.
 */
public class Length extends Constraint {
    public static final int DEFAULT_LENGTH = 32;

    /**
     * Minimal required length for the string.
     */
    private final int minLength;

    /**
     * Maximal required length.
     */
    private final int maxLength;

    public Length(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    @Override
    public String toString() {
        return "length minLength=" + minLength + " maxLength=" + maxLength;
    }

    @Override
    public boolean supportsType(Type type) {
        // length constraint is used only for strings
        if (type.equals(Type.STRING)) {
            return true;
        }
        return false;
    }
}
