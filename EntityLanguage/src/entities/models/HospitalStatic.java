package entities.models;

import entities.language.builder.EL;
import entities.language.metamodel.Model;

/**
 * Hospital defined using the static nested functions.
 * @author Milan
 */
public class HospitalStatic {
    
    private Model model;

    public void compose() {
        EL.entity("Patient",
                EL.property("name", EL.string, EL.required(), EL.length(5, 30)),
                EL.property("age", EL.integer, EL.range(0, 120))
        );
        
        model = EL.getModel();
    }
    
    public Model getModel() {
        return this.model;
    }
}
