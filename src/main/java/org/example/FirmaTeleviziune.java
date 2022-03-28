package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class FirmaTeleviziune {

    private static final Logger logger = Logger.getLogger("Info Logger");

    public void runWithSingleton(){
        Scanner sc = new Scanner(System.in);
        logger.info("Numar canale:");
        int n = sc.nextInt();
        if(n==0){
            logger.warning("Nu pot fi 0 canale");
        }
        else if(n<0){
            logger.severe("Nu pot fi canale pe minus");
        }
        Canal[] canale = new Canal[n];
        for(int i=0;i<n;i++){
            canale[i] = Canal.getInstance();
        }
        for(int i=0;i<n;i++){
            System.out.println(canale[i]);
        }
    }

    public void functionare() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dim canale:");
        int dimCa = sc.nextInt();
        Canal[] canale = new Canal[dimCa];
        Program[] programe;
        for(int i=0;i<dimCa;i++) {
            String n,fr;
            int zi;
            System.out.println("Nume Canal:");
            n=sc.next();
            System.out.println("Dim Programe:");
            int dimPr = sc.nextInt();
            programe = new Program[dimPr];
            for(int j=0;j<dimPr;j++) {
                System.out.println("Dim emisiuni:");
                int dimEm = sc.nextInt();
                Emisiune[] emisiuni = new Emisiune[dimEm];
                for(int k=0;k<dimEm;k++) {
                    String nu,d,p,t;
                    System.out.println("Nume:");
                    nu=sc.next();
                    System.out.println("Gen:");
                    d=sc.next();
                    System.out.println("Public:");
                    p=sc.next();
                    int du,o;
                    System.out.println("Ora:");
                    du=sc.nextInt();
                    System.out.println("Durata:");
                    o=sc.nextInt();
                    System.out.println("Tip:");
                    t=sc.next();
                    emisiuni[i]= new Emisiune(nu,d,p,du,o,t);
                }
                int d,eL,eI,o;
                String p,tip;
                System.out.println("Tip:");
                tip = sc.next();
                System.out.println("Durata:");
                d=sc.nextInt();
                System.out.println("Emisiuni Live:");
                eL=sc.nextInt();
                System.out.println("Emisiuni Inregistrate:");
                eI=sc.nextInt();
                System.out.println("Public:");
                p=sc.next();
                System.out.println("ora:");
                o=sc.nextInt();
                programe[i] = new Program(emisiuni,tip, d,eL,eI,p,o);
            }
            System.out.println("Frecventa:");
            fr=sc.next();
            System.out.println("Zi:");
            zi=sc.nextInt();
            canale[i]=new Canal(n,programe,fr,zi);

            Program r1= new Program();
            r1.writeGson(programe);

            Canal r2= new Canal();
            r2.writeGson(canale);
        }
    }
}


