package entities.language.metamodel.constraints;

import entities.language.metamodel.Type;

/**
 * Constraints that can be set upon the properties.
 * @author Milan
 */
public abstract class Constraint {
    /**
     * Tests whether this constraint can be set upon the given data type.
     * E.g., a length can not be set upon a number, it has meaning with string.
     * @param type
     * @return 
     */
    public abstract boolean supportsType(Type type);
}
