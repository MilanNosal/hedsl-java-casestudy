package entities;


import entities.language.builder.ParsingException;
import entities.models.Hospital;
import entities.models.HospitalStatic;

public class Main {
    public static void main(String[] args) throws ParsingException {
        System.out.println("A hospital model defined with object scoping technique:");
        Hospital hospital = new Hospital();
        hospital.compose();
        System.out.println(hospital.getModel().toString());
        
        System.out.println("\nThe same hospital model defined with static nested functions:");
        HospitalStatic hospitalStatic = new HospitalStatic();
        hospitalStatic.compose();
        System.out.println(hospitalStatic.getModel().toString());
    }
}
