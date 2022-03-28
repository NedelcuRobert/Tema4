package org.example;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Program extends Emisiune {

    private static final Program INSTANCE = new Program(getArrayEmisiuni(), "Teleshopping",3,2,5,"16+",17);

     public static Program getInstance(){
        return INSTANCE;
    }

    public Program(){}

    public Program(Emisiune[] emisiuni, String tipProgram, int durataMedie, int emisiuniLive, int emisiuniInregistrate, String publicTinta, int oraPreponderentaEmisiune) {
        setEmisiuni(emisiuni);
        this.tipProgram = tipProgram;
        this.durataMedie = durataMedie;
        this.emisiuniLive = emisiuniLive;
        this.emisiuniInregistrate = emisiuniInregistrate;
        this.publicTinta = publicTinta;
        this.oraPreponderentaEmisiune = oraPreponderentaEmisiune;
    }

    private static Emisiune[] emisiuni;
    private String tipProgram;
    private int durataMedie;
    private int emisiuniLive;
    private int emisiuniInregistrate;
    private String publicTinta;
    private int oraPreponderentaEmisiune;

    private static Emisiune[] getArrayEmisiuni(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dim Emisiuni:");
        int n = sc.nextInt();
        emisiuni = new Emisiune[n];
        for(int i=0;i<n;i++){
            System.out.println("Date Emisiune:"+(i+1));
            emisiuni[i] = Emisiune.getInstance();
        }
        return emisiuni;
    }

    @Override
    public String toString() {
        return "Program [tipProgram=" + tipProgram + ", durataMedie=" + durataMedie + ", emisiuniLive=" + emisiuniLive
                + ", emisiuniInregistrate=" + emisiuniInregistrate + ", publicTinta=" + publicTinta
                + ", oraPreponderentaEmisiune=" + oraPreponderentaEmisiune + "]";
    }

    public Emisiune[] getEmisiuni() {
        return emisiuni;
    }

    public void setEmisiuni(Emisiune[] emisiuni) {
        this.emisiuni = emisiuni;
    }

    public String getTipProgram() {
        return tipProgram;
    }


    public void setTipProgram(String tipProgram) {
        this.tipProgram = tipProgram;
    }


    public int getDurataMedie() {
        return durataMedie;
    }


    public void setDurataMedie(int durataMedie) {
        this.durataMedie = durataMedie;
    }


    public int getEmisiuniLive() {
        return emisiuniLive;
    }


    public void setEmisiuniLive(int emisiuniLive) {
        this.emisiuniLive = emisiuniLive;
    }


    public int getEmisiuniInregistrate() {
        return emisiuniInregistrate;
    }


    public void setEmisiuniInregistrate(int emisiuniInregistrate) {
        this.emisiuniInregistrate = emisiuniInregistrate;
    }


    public String getPublicTinta() {
        return publicTinta;
    }


    public void setPublicTinta(String publicTinta) {
        this.publicTinta = publicTinta;
    }


    public int getOraPreponderentaEmisiune() {
        return oraPreponderentaEmisiune;
    }


    public void setOraPreponderentaEmisiune(int oraPreponderentaEmisiune) {
        this.oraPreponderentaEmisiune = oraPreponderentaEmisiune;
    }

    public void citire(Scanner sc) {
        /*
        int dim = sc.nextInt();
        emisiuni = new Emisiune[dim];
        for(int i=0;i<dim;i++) {
            emisiuni[i] = new Emisiune();
            emisiuni[i].citire(sc);
        }
         */
        System.out.println("Tip Program:");
        String tip=sc.next();
        this.setTipProgram(tip);
        System.out.println("Durata Medie:");
        int dur=sc.nextInt();
        this.setDurataMedie(dur);
        System.out.println("Emisiuni Live:");
        int emL=sc.nextInt();
        this.setEmisiuniLive(emL);
        System.out.println("Emisiuni Inregistrare:");
        int emI=sc.nextInt();
        this.setEmisiuniInregistrate(emI);
        System.out.println("Public Tinta:");
        String pbT=sc.next();
        this.setPublicTinta(pbT);
        System.out.println("Ora Emisiune:");
        int ora=sc.nextInt();
        this.setOraPreponderentaEmisiune(ora);
    }

    public void writeGson(Program[] p) {

        try {
            List <Program> programe  = Arrays.asList(p[0],p[1]);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Writer writer = Files.newBufferedWriter(Paths.get(".\\jsonfiles\\program.json"));

            gson.toJson(programe, writer);

            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readGson() {

        try {

            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get(".\\jsonfiles\\program.json"));

            List<Program> programe = Arrays.asList(gson.fromJson(reader, Program[].class));

            programe.forEach(System.out::println);

            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
