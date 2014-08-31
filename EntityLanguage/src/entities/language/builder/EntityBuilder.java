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
 * Entity builder using object scoping to aid code completion and 
 * ErrorHandlingUtils class for advanced error reporting.
 * @author Milan
 */
public abstract class EntityBuilder {

    /**
     * ErrorHandlingUtils object for advanced error handling.
     */
    private final ErrorHandlingUtils errorHandling = new ErrorHandlingUtils(this.getClass());
    
    private Model model;
    private final List<Entity> entities = new LinkedList<Entity>();

    protected Type string = Type.STRING;
    protected Type integer = Type.INTEGER;
    protected Type real = Type.REAL;

    /**
     * The abstract define method will get overriden in concrete definition
     * classes such as the Hospital class.
     */
    protected abstract void define();

    public Model getModel() {
        return this.model;
    }

    /**
     * This method is called to create the model. It uses the concrete define
     * method of the definition class to create model and then it validates it.
     * @throws ParsingException 
     */
    public void compose() throws ParsingException {
        define();
        model = new Model(entities.toArray(new Entity[entities.size()]));
        validate();
    }

    /**
     * Creation method for an entity. Notice that each created object is 
     * registered to ErrorHandlingUtils object.
     * @param name
     * @param properties 
     */
    protected void entity(String name, Property... properties) {
        Entity entity = new Entity(name, properties);
        entities.add(errorHandling.registerObject(entity));
    }

    protected Property property(String name, Type type, Constraint... constraints) {
        Property property = new Property(name, type, constraints);        
        return errorHandling.registerObject(property);
    }

    protected Required required() {
        Required required = new Required();
        return errorHandling.registerObject(required);
    }

    protected Range range(long minValue, long maxValue) {
        Range range = new Range(minValue, maxValue);
        return errorHandling.registerObject(range);
    }

    protected Length length(int minLength, int maxLength) {
        Length length = new Length(minLength, maxLength);
        return errorHandling.registerObject(length);
    }

    protected Length min_length(int minLength) {
        Length length = new Length(minLength, Integer.MAX_VALUE);
        return errorHandling.registerObject(length);
    }

    protected Length max_length(int maxLength) {
        Length length = new Length(0, maxLength);
        return errorHandling.registerObject(length);
    }

    protected Regex regex(String regex) {
        Regex regexp = new Regex(regex);
        return errorHandling.registerObject(regexp);
    }

    /**
     * Validate method does some validation upon the model. In this particular
     * case it checks for duplication in entities and in their properties.
     * For the error reporting ti uses the ErrorHandlingUtils object.
     * @throws ParsingException 
     */
    private void validate() throws ParsingException {
        List<String> usedEntNames = new LinkedList<String>();
        for(Entity entity : model.getEntities()) {
            if(usedEntNames.contains(entity.getName())) {
                // the user will be navigated to the line where
                // the duplicated entity was defined
                errorHandling.reportError(entity, 
                        new ParsingException("Defined duplicate entity with name " + entity.getName()));
            } else {
                usedEntNames.add(entity.getName());
            }
            List<String> usedPropNames = new LinkedList<String>();
            for(Property prop : entity.getProperties()) {
                if(usedPropNames.contains(prop.getName())) {
                    errorHandling.reportError(prop, 
                            new ParsingException("Duplicate property in entity " + entity.getName()
                            + " with name " + prop.getName()));
                } else {
                    usedPropNames.add(prop.getName());
                }
            }
        }
    }
}
