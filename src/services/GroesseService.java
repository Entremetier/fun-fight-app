package services;

public class GroesseService {

    public int groesseErgebnis(String[] fighter){
        int groesse = Integer.parseInt(fighter[1]);
        int ergebnis;

        if (groesse <= 170){
            ergebnis = 5;
        }else if (groesse < 180){
            ergebnis = 10;
        } else {
            ergebnis = 20;
        }
//        System.out.println("Groesse: " + groesse + " Ergebnis: " + ergebnis);
        return ergebnis;
    }
}
