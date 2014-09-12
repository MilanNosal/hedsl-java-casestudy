package entities.language.metamodel;

/**
 * Interface marking a model class as named. The name is considered an
 * identifier (there cannot be two objects with the same name).
 */
public interface Named {
    String getName();
}
