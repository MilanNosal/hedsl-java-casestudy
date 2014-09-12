package entities.models;

// a static import to remove the need of the StaticEntityBuilder prefix to function calls
import entities.language.builder.StaticEntityBuilder;
//import static entities.language.builder.StaticEntityBuilder.*; // uncomment this line to get code completion support
import entities.language.metamodel.Model;

/**
 * Hospital defined using static nested functions without the static import.
 */
public class HospitalStatic {
    
    /**
     * The compose method uses StaticEntityBuilder static methods to create a 
     * model.
     */
    public void compose() {
        StaticEntityBuilder.entity("Patient",
                StaticEntityBuilder.property("name", StaticEntityBuilder.string, StaticEntityBuilder.required(), StaticEntityBuilder.length(5, 30)),
                StaticEntityBuilder.property("age", StaticEntityBuilder.integer, StaticEntityBuilder.range(0, 120))
        );
    }
    
    public Model getModel() {
        return StaticEntityBuilder.getModel();
    }
}
