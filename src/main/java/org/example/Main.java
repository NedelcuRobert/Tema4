package org.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FirmaTeleviziune firma = new FirmaTeleviziune();
        //firma.functionare();
        firma.runWithSingleton();
    }
}