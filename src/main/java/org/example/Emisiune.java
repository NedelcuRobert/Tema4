package org.example;

import java.util.Scanner;


public class Emisiune {

    private static final Emisiune INSTANCE = new Emisiune("LaMaruta","Comedie","18+",17,2,"Interactiva");

    public static Emisiune getInstance(){
        return INSTANCE;
    }

    private String nume;
    private String genEmisiune;
    private String Publicul;
    private int oraDifuzarii;
    private int durata;
    private String tipEmisiune;

    Emisiune(){}

    public Emisiune(String nume, String genEmisiune, String publicul, int oraDifuzarii, int durata,
                    String tipEmisiune) {
        this.nume = nume;
        this.genEmisiune = genEmisiune;
        Publicul = publicul;
        this.oraDifuzarii = oraDifuzarii;
        this.durata = durata;
        this.tipEmisiune = tipEmisiune;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getGenEmisiune() {
        return genEmisiune;
    }

    public void setGenEmisiune(String genEmisiune) {
        this.genEmisiune = genEmisiune;
    }

    public String getPublicul() {
        return Publicul;
    }

    public void setPublicul(String publicul) {
        this.Publicul = publicul;
    }

    public int getOraDifuzarii() {
        return oraDifuzarii;
    }

    public void setOraDifuzarii(int oraDifuzarii) {
        this.oraDifuzarii = oraDifuzarii;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getTipEmisiune() {
        return tipEmisiune;
    }

    public void setTipEmisiune(String tipEmisiune) {
        this.tipEmisiune = tipEmisiune;
    }


    public void citire(Scanner sc) {
        System.out.println("Gen Emisiune:");
        String GenEm=sc.next();
        this.setGenEmisiune(GenEm);
        System.out.println("Public Tinta:");
        String Publ=sc.next();
        this.setPublicul(Publ);
        System.out.println("Ora Difuzare:");
        int o=sc.nextInt();
        this.setOraDifuzarii(o);
        System.out.println("Durata:");
        int d=sc.nextInt();
        this.setDurata(d);
        System.out.println("Tip Emisiune:");
        String tip=sc.next();
        this.setTipEmisiune(tip);
    }

}