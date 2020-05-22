package model;

import java.awt.*;

public class Gruppe {

    private List personen = new List();

    public void anmelden(Person person){
        personen.add(person.toString());
    }

    public void abmelden(String person){
            personen.remove(person);
    }

    public List getPersonen() {
        return personen;
    }

    @Override
    public String toString() {
        return "Personen: " + personen;
    }
}
