package model;

public class Person {

    private String name;
    private  int alter;
    private int groesse;
    private int gewicht;
    private String sportlich;

    public Person() {
    }

    public Person(String name, int alter, int groesse, int gewicht, String sportlich) {
        this.name = name;
        this.alter = alter;
        this.groesse = groesse;
        this.gewicht = gewicht;
        this.sportlich = sportlich;
    }

    @Override
    public String toString() {
        return "Name: " + name + " " +
                "Alter: " + alter + " " +
                "Größe: " + groesse + " " +
                "Gewicht: " + gewicht + " " +
                "Sportlich: " + sportlich ;
    }
}
