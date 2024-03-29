package entities.language.builder;

import entities.language.metamodel.constraints.Regex;
import entities.language.metamodel.constraints.Length;
import entities.language.metamodel.constraints.Required;
import entities.language.metamodel.constraints.Range;
import entities.language.metamodel.constraints.Constraint;
import java.util.LinkedList;
import java.util.List;
import entities.language.metamodel.Entity;
import entities.language.metamodel.Model;
import entities.language.metamodel.Property;
import entities.language.metamodel.Type;

/**
 * Entities language expression builder working with static nested functions.
 * This we consider a starting point of our experiment.
 */
public abstract class EL {
    /**
     * Model that is built by this expression builder.
     */
    private static Model model;
    
    /**
     * Entities cache.
     */
    private static List<Entity> entities = new LinkedList<Entity>();
    
    // mediating also the enumeration constants
    public static Type string = Type.STRING;
    public static Type integer = Type.INTEGER;
    public static Type real = Type.REAL;
        
    /**
     * Builds and returns the model from the entities cache.
     * @return 
     */
    public static Model getModel() {
        model = new Model(entities.toArray(new Entity[entities.size()]));
        entities = new LinkedList<Entity>();
        return model;
    }

    /**
     * Creation function for an entity.
     * @param name
     * @param properties 
     */
    public static void entity(String name, Property... properties) {
        entities.add(new Entity(name, properties));
    }

    /**
     * Property creation method.
     * @param name
     * @param type
     * @param constraints
     * @return 
     */
    public static Property property(String name, Type type, Constraint... constraints) {
        return new Property(name, type, constraints);
    }

    public static Required required() {
        return new Required();
    }

    public static Range range(long minValue, long maxValue) {
        return new Range(minValue, maxValue);
    }

    public static Length length(int minLength, int maxLength) {
        return new Length(minLength, maxLength);
    }

    public static Length min_length(int minLength) {
        return new Length(minLength, Integer.MAX_VALUE);
    }

    public static Length max_length(int maxLength) {
        return new Length(0, maxLength);
    }

    public static Regex regex(String regex) {
        return new Regex(regex);
    }
}
