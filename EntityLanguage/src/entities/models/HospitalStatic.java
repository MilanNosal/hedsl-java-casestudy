package entities.models;

// a static import to remove the need of the StaticEntityBuilder prefix to function calls
import entities.language.builder.StaticEntityBuilder;
import static entities.language.builder.StaticEntityBuilder.*;
import entities.language.metamodel.Model;

/**
 * Hospital defined using static nested functions.
 * @author Milan
 */
public class HospitalStatic {
    
    /**
     * The compose method uses StaticEntityBuilder static methods to create a 
     * model.
     */
    public void compose() {
        entity("Patient",
                property("name", string, required(), length(5, 30)),
                property("age", integer, range(0, 120))
        );
    }
    
    public Model getModel() {
        return StaticEntityBuilder.getModel();
    }
}
