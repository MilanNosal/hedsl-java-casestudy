// EDSLAddon_start_fold desc="Define entities and their properties here:"
package entities.models;

import entities.language.builder.EntityBuilder;

public class Hospital extends EntityBuilder {

    @Override
    protected void define() {
        // EDSLAddon_end_fold
    entity("Patient",
        property("name", string, required(), length(5, 30)),
        property("age", integer, range(0, 120))
    );
    // uncomment an entity with duplicated name for error reporting test
        entity("Patient", 
                property("name", string),
                property("insurance", string)
        );
// EDSLAddon_start_fold desc="Definition ends here."

    }
}
// EDSLAddon_end_fold