package services;

public class SportlkeitService {

    public static int sportlichkeitErgebnis(String[] fighter){
        int ergebnis = 0;

        switch (fighter[3]) {
            case "Kämpfer":
                ergebnis = 30;
                break;
            case "Sportl.":
                ergebnis = 20;
                break;
            case "Unsportl":
                ergebnis = 0;
                break;
        }
//        System.out.println("Sportlichkeit: " + ergebnis);
        return ergebnis;
    }
}
