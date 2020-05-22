package model;

public enum Sportlich {

    KAMPFSPORTLER("Kämpfer"), SPORTLICH("Sportl."), UNSPORTLICH("Unsportl.");

    private String kuerzel;

    Sportlich(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public String getKuerzel() {
        return kuerzel;
    }
}
