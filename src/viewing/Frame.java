package viewing;

import model.Gruppe;
import model.Person;
import model.Sportlich;
import services.AlterService;
import services.BMIService;
import services.GroesseService;
import services.SportlkeitService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Frame extends JFrame {

    private Gruppe gruppe = new Gruppe();
    private String sportlichkeit = null;

    public Frame() {

        List personen = gruppe.getPersonen();
        personen.setMultipleMode(true);

        JLabel nameLabel = new JLabel("Name:", SwingConstants.CENTER);
        JTextField nameTxt = new JTextField();

        JLabel alterLabel = new JLabel("Alter:", SwingConstants.CENTER);
        JTextField alterTxt = new JTextField();

        JLabel groesseLabel = new JLabel("Größe in cm:", SwingConstants.CENTER);
        JTextField groesseTxt = new JTextField();

        JLabel gewichtLabel = new JLabel("Gewicht in kg:", SwingConstants.CENTER);
        JTextField gewichtTxt = new JTextField();

        JLabel sportlichLabel = new JLabel("Sportlich:", SwingConstants.CENTER);
        JLabel emptyLabel1 = new JLabel();

        JCheckBox kampfsportler = new JCheckBox();
        JCheckBox sportlich = new JCheckBox();
        JCheckBox unsportlich = new JCheckBox();

        JLabel emptyLabel2 = new JLabel();

        kampfsportler.setText("Kampfsportler");
        kampfsportler.setHorizontalAlignment(SwingConstants.CENTER);
        kampfsportler.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (kampfsportler.isSelected()) {
                    kampfsportler.setSelected(true);
                    sportlich.setSelected(false);
                    unsportlich.setSelected(false);
                    sportlichkeit = Sportlich.KAMPFSPORTLER.getKuerzel();
                }
            }
        });

        sportlich.setText("Sportlich");
        sportlich.setHorizontalAlignment(SwingConstants.CENTER);
        sportlich.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (sportlich.isSelected()) {
                    sportlich.setSelected(true);
                    kampfsportler.setSelected(false);
                    unsportlich.setSelected(false);
                    sportlichkeit = Sportlich.SPORTLICH.getKuerzel();
                }
            }
        });

        unsportlich.setText("Unsportlich");
        unsportlich.setHorizontalAlignment(SwingConstants.CENTER);
        unsportlich.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (unsportlich.isSelected()) {
                    unsportlich.setSelected(true);
                    kampfsportler.setSelected(false);
                    sportlich.setSelected(false);
                    sportlichkeit = Sportlich.UNSPORTLICH.getKuerzel();
                }
            }
        });

        JLabel redCornerLabel = new JLabel("Red Corner");
        redCornerLabel.setBackground(Color.red);
        redCornerLabel.setOpaque(true);
        redCornerLabel.setFont(new Font("Courier", Font.BOLD, 14));
        redCornerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel blueCornerLabel = new JLabel("Blue Corner");
        blueCornerLabel.setBackground(Color.blue);
        blueCornerLabel.setOpaque(true);
        blueCornerLabel.setFont(new Font("Courier", Font.BOLD, 14));
        blueCornerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel winnerLabel = new JLabel("The winner is:");
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winnerLabel.setBackground(Color.WHITE);
        winnerLabel.setOpaque(true);

        JLabel siegerLabel = new JLabel();
        siegerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        siegerLabel.setBackground(Color.WHITE);
        siegerLabel.setOpaque(true);
        siegerLabel.setFont(new Font("Italien", Font.ITALIC, 18));

        JButton saveButton = new JButton("Speichern");
        saveButton.setBackground(Color.GREEN);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name;
                int alter;
                int groesse;
                int gewicht;


                if (nameTxt.getText().isEmpty() || nameTxt.getText().equals("Zwischen 3 und 10 Zeichen")) {
                    name = "";
                } else {
                    if (nameTxt.getText().equals("Eingabe machen, 3 bis 10 Zeichen")) {
                        name = "";
                    } else {
                        name = nameTxt.getText().trim();
                        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                    }
                }

                if (alterTxt.getText().isEmpty() || alterTxt.getText().equals("Zwischen 18 und 60")) {
                    alter = 0;
                } else {
                    if (alterTxt.getText().equals("Eingabe machen, 18 bis 60 Jahre")) {
                        alter = 0;
                    } else {
                        alter = Integer.parseInt(alterTxt.getText());
                    }
                }

                if (groesseTxt.getText().isEmpty() || groesseTxt.getText().equals("Zwischen 140 cm und 190 cm")) {
                    groesse = 0;
                } else {
                    if (groesseTxt.getText().equals("Eingabe machen, 140 cm - 190 cm")) {
                        groesse = 0;
                    } else {
                        groesse = Integer.parseInt(groesseTxt.getText());
                    }
                }

                if (gewichtTxt.getText().isEmpty() || gewichtTxt.getText().equals("Zwischen 50 kg und 160 kg")) {
                    gewicht = 0;
                } else {
                    if (gewichtTxt.getText().equals("Eingabe machen, 50 - 160 kg")) {
                        gewicht = 0;
                    } else {
                        gewicht = Integer.parseInt(gewichtTxt.getText());
                    }
                }

                if (name.length() < 3 || name.length() > 10 || alter < 18 || alter > 60 || groesse < 140 ||
                        groesse > 190 || gewicht < 50 || gewicht > 160 || sportlichkeit == null) {
                    if (nameTxt.getText().isEmpty()) {
                        nameTxt.setText("Zwischen 3 und 10 Zeichen");
                    } else {
                        if (nameTxt.getText().equals("Eingabe machen, 3 bis 10 Zeichen")) {
                            nameTxt.setText("");
                        } else {
                            if (name.length() < 3 || name.length() > 10) {
                                nameTxt.setText("Eingabe machen, 3 bis 10 Zeichen");
                            } else {
                                nameTxt.setText(name);
                            }
                        }
                    }
                    if (alterTxt.getText().isEmpty()) {
                        alterTxt.setText("Zwischen 18 und 60");
                    } else {
                        if (alterTxt.getText().equals("Eingabe machen, 18 bis 60 Jahre")) {
                            alterTxt.setText("");
                        } else {
                            if (alter < 18 || alter > 60) {
                                alterTxt.setText("Eingabe machen, 18 bis 60 Jahre");
                            } else {
                                alterTxt.setText(Integer.toString(alter));
                            }
                        }
                    }
                    if (groesseTxt.getText().isEmpty()) {
                        groesseTxt.setText("Zwischen 140 cm und 190 cm");
                    } else {
                        if (groesseTxt.getText().equals("Eingabe machen, 140 cm - 190 cm")) {
                            groesseTxt.setText("");
                        } else {
                            if (groesse < 140 || groesse > 190) {
                                groesseTxt.setText("Eingabe machen, 140 cm - 190 cm");
                            } else {
                                groesseTxt.setText(Integer.toString(groesse));
                            }
                        }
                    }
                    if (gewichtTxt.getText().isEmpty()) {
                        gewichtTxt.setText("Zwischen 50 kg und 160 kg");
                    } else {
                        if (gewichtTxt.getText().equals("Eingabe machen, 50 - 160 kg")) {
                            gewichtTxt.setText("");
                        } else {
                            if (gewicht < 50 || gewicht > 160) {
                                gewichtTxt.setText("Eingabe machen, 50 - 160 kg");
                            } else {
                                gewichtTxt.setText(Integer.toString(gewicht));
                            }
                        }
                    }
                    if (sportlichkeit == null) {
                        emptyLabel2.setText("Wie sportlich bist du?");
                    }
                } else {
                    Person person = new Person(name, alter, groesse, gewicht, sportlichkeit);
                    gruppe.anmelden(person);
                    nameTxt.setText("");
                    alterTxt.setText("");
                    groesseTxt.setText("");
                    gewichtTxt.setText("");
                    emptyLabel2.setText("");
                    siegerLabel.setText("");
                    redCornerLabel.setText("Red Corner");
                    blueCornerLabel.setText("Blue Corner");
                    siegerLabel.setBackground(Color.WHITE);
                    kampfsportler.setSelected(false);
                    sportlich.setSelected(false);
                    unsportlich.setSelected(false);
                }
            }
        });

        JButton deleteButton = new JButton("Löschen");
        deleteButton.setBackground(Color.RED);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String person;

                if (personen.getSelectedIndex() == -1) {
                    emptyLabel2.setText("Person zum löschen auswählen");
                } else {
                    person = personen.getItem(personen.getSelectedIndex());
                    gruppe.abmelden(person);
                    emptyLabel2.setText("");
                }
            }
        });

        Panel top = new Panel();
        top.setLayout(new GridLayout(8, 2));
        top.add(nameLabel);
        top.add(nameTxt);
        top.add(alterLabel);
        top.add(alterTxt);
        top.add(groesseLabel);
        top.add(groesseTxt);
        top.add(gewichtLabel);
        top.add(gewichtTxt);
        top.add(sportlichLabel);
        top.add(emptyLabel1);
        top.add(kampfsportler);
        top.add(sportlich);
        top.add(unsportlich);
        top.add(emptyLabel2);
        top.add(saveButton);
        top.add(deleteButton);

        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(1, 1));
        middle.add(personen);

        JButton fightButton = new JButton("Fight");
        fightButton.setBackground(Color.BLACK);
        fightButton.setForeground(Color.WHITE);
        fightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] person;
                String personenData = "";
                String name1;
                String name2;

                if (personen.getSelectedItems().length != 2) {
                    emptyLabel2.setText("Zwei Kämpfer auswählen");
                } else {
                    emptyLabel2.setText("");
                    person = personen.getSelectedItems();

                    for (String data : person) {
                        String[] dataArray = data.split(" ");
                        personenData += dataArray[1] + " ";
                    }
                    String[] namen = personenData.split(" ");
                    name1 = namen[0];
                    name2 = namen[1];

                    redCornerLabel.setText("Red Corner: " + name1);
                    blueCornerLabel.setText("Blue Corner: " + name2);
                    nameTxt.setText("");
                    alterTxt.setText("");
                    groesseTxt.setText("");
                    gewichtTxt.setText("");
                    kampfsportler.setSelected(false);
                    sportlich.setSelected(false);
                    unsportlich.setSelected(false);

                    String[] dataArray;
                    String personData = "";

                    if (personen.getSelectedItems().length == 1) {
                        emptyLabel2.setText("Kämpfer auswählen");
                    } else {
                        person = personen.getSelectedItems();
                        for (String daten : person) {
                            dataArray = daten.split(" ");
                            personData += dataArray[3] + " " + dataArray[5] + " " + dataArray[7] + " " + dataArray[9] + " ";
                        }
                    }

                    String[] kaempfer = personData.split(" ");

                    String[] fighter1 = {kaempfer[0], kaempfer[1], kaempfer[2], kaempfer[3]};
                    String[] fighter2 = {kaempfer[4], kaempfer[5], kaempfer[6], kaempfer[7]};

                    AlterService alterService = new AlterService();
                    GroesseService groesseService = new GroesseService();
                    BMIService bmiService = new BMIService();
                    SportlkeitService sportlkeitService = new SportlkeitService();

                    int kaempfer1 = alterService.alterErgebnis(fighter1);
                    kaempfer1 += groesseService.groesseErgebnis(fighter1);
                    kaempfer1 += bmiService.bmiErgebnis(fighter1);
                    kaempfer1 += sportlkeitService.sportlichkeitErgebnis(fighter1);

                    int kaempfer2 = alterService.alterErgebnis(fighter2);
                    kaempfer2 += groesseService.groesseErgebnis(fighter2);
                    kaempfer2 += bmiService.bmiErgebnis(fighter2);
                    kaempfer2 += sportlkeitService.sportlichkeitErgebnis(fighter2);

                    if (kaempfer1 > kaempfer2) {
                        siegerLabel.setText(name1);
                        siegerLabel.setBackground(Color.YELLOW);

                        String[] teilnehmer = personen.getSelectedItems();
                        String verlierer = teilnehmer[1];
                        gruppe.abmelden(verlierer);

                    } else if (kaempfer1 < kaempfer2) {
                        siegerLabel.setText(name2);
                        siegerLabel.setBackground(Color.YELLOW);

                        String[] teilnehmer = personen.getSelectedItems();
                        String verlierer = teilnehmer[0];
                        gruppe.abmelden(verlierer);
                    } else {
                        siegerLabel.setText("Kein Sieger");
                    }

//                    System.out.println("Kämpfer1: " + kaempfer1);
//                    System.out.println("Kämpfer2: " + kaempfer2);
                }
            }
        });

        JButton exitButton = new JButton("Schliessen");
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3, 2));
        bottom.add(fightButton);
        bottom.add(exitButton);
        bottom.add(redCornerLabel);
        bottom.add(blueCornerLabel);
        bottom.add(winnerLabel);
        bottom.add(siegerLabel);

        this.add(top);
        this.add(middle);
        this.add(bottom);
        this.setSize(500, 800);
        this.setLocation(900, 10);
        this.setTitle("Fight Night");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
    }
}
