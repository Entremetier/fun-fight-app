package services;

public class AlterService {

    public int alterErgebnis(String[] fighter) {
        int alter = Integer.parseInt(fighter[0]);
        int ergbnis = 0;
        if (alter <= 30) {
            ergbnis += 25;
        } else if (alter <= 40) {
            ergbnis += 15;
        } else if (alter <= 50) {
            ergbnis += 10;
        } else {
            ergbnis += 5;
        }
//        System.out.println("Alter: " + alter + " Ergebnis: " + ergbnis);
        return ergbnis;
    }
}
