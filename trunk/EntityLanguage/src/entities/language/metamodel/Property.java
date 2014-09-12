package entities.language.metamodel;

import java.util.Arrays;
import entities.language.metamodel.constraints.Constraint;

/**
 * A class representing a property of an entity.
 */
public class Property implements Named {
    /**
     * Property is named, too.
     */
    private final String name;

    /**
     * Each property has its type.
     */
    private final Type type;

    /**
     * And finally, a set of constraints laid upon the property.
     */
    private Constraint[] constraints;

    public Property(String name,
            Type type,
            Constraint[] constraints) {
        this.name = name;
        this.type = type;
        this.constraints = constraints;
    }

    public Property(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Constraint[] getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraint[] constraints) {
        this.constraints = constraints;
    }

    /**
     * Utility method that finds a constraints of given type, if there is one
     * set upon this property.
     * @param <T>
     * @param clazz
     * @return 
     */
    @SuppressWarnings("unchecked")
    public <T extends Constraint> T getConstraint(Class<T> clazz) {
        if (constraints != null) {
            for (Constraint constraint : constraints) {
                if (constraint.getClass().equals(clazz)) {
                    return (T) constraint;
                }
            }
        }
        return null;
    }

    /**
     * Utility method finds out whether there is a constraint of a given
     * class on this property.
     * @param clazz
     * @return 
     */
    public boolean hasConstraint(Class<? extends Constraint> clazz) {
        return getConstraint(clazz) != null;
    }

    @Override
    public String toString() {
        return name + ":" + type + " constraints " + Arrays.toString(constraints);
    }
}
