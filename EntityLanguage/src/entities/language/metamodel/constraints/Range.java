package entities.language.metamodel.constraints;

import entities.language.metamodel.Type;

/**
 * Range constraint for numbers.
 */
public class Range extends Constraint {
    /**
     * Minimal value of this number.
     */
    private final long minValue;

    /**
     * Maximal value.
     */
    private final long maxValue;

    public Range(long minValue, long maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    @Override
    public String toString() {
        return "range minValue=" + minValue + " maxValue=" + maxValue;
    }

    @Override
    public boolean supportsType(Type type) {
        // supported data type is only an integer number
        return type.equals(Type.INTEGER);
    }
}
