package entities.language.metamodel.constraints;

import entities.language.metamodel.Type;

/**
 * The required constraint. A property with this constraint has to be 
 * inserted.
 * @author Milan
 */
public class Required extends Constraint {
    public Required() {
    }

    @Override
    public String toString() {
        return "required";
    }

    @Override
    public boolean supportsType(Type type) {
        return true;
    }
}
