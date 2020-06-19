package services;

public class BMIService {

    public static double bmiErgebnis (String[] fighter){
        double groesse = Integer.parseInt(fighter[1]);
        double gewicht = Integer.parseInt(fighter[2]);
        double ergebnis;

        double groesseErgebnis = groesse / 100;
//        System.out.println("Größe Ergebnis: " + groesseErgebnis);

        double ergebnisGroessenRechnung = groesseErgebnis * groesseErgebnis;
        double bmi = gewicht / ergebnisGroessenRechnung;

        if (bmi <= 18){
            ergebnis = 5;
        } else if (bmi > 18 && bmi < 25){
            ergebnis = 25;
        } else if (bmi >= 25 && bmi < 30){
            ergebnis = 10;
        } else if (bmi >= 30 && bmi < 35){
            ergebnis = 0;
        } else if (bmi >= 35 && bmi < 40){
            ergebnis = 15;
        } else {
            ergebnis = -20;
        }
//        System.out.println("BMI: " + bmi + " Ergebnis: " + ergebnis);
        return ergebnis;
    }
}
