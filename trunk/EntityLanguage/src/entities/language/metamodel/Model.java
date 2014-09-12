package entities.language.metamodel;

import java.util.Arrays;

/**
 * The model of the CRUD application.
 */
public class Model {
    /**
     * It consists of a set of entities.
     */
    private final Entity[] entities;

    public Model(Entity[] entities) {
        this.entities = entities;
    }

    public Entity[] getEntities() {
        return entities;
    }

    /**
     * Utility method for finding an entity according to a given name.
     * @param name
     * @return 
     */
    public Entity findEntity(String name) {
        for (Entity entity : entities) {
            if (name.equals(entity.getName())) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "model " + Arrays.toString(entities);
    }
}
