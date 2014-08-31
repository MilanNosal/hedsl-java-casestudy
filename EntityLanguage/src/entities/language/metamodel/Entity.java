package entities.language.metamodel;

import java.util.Arrays;

/**
 * Represents an entity.
 * @author Milan
 */
public class Entity implements Named {
    /**
     * An entity is named.
     */
    private final String name;

    /**
     * And it consists of a set of properties.
     */
    private final Property[] properties;

    public Entity(String name,
            Property[] properties) {
        this.name = name;
        this.properties = properties;
    }

    @Override
    public String getName() {
        return name;
    }

    public Property[] getProperties() {
        return properties;
    }

    /**
     * Finds a property with given name.
     * @param name
     * @return 
     */
    public Property findProperty(String name) {
        for (Property property : properties) {
            if (name.equals(property.getName())) {
                return property;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "entity " + name + " " + Arrays.toString(properties);
    }
}
