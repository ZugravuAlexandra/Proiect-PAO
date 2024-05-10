package org.example;

import java.util.Scanner;

import servicii.*;

public class Main {
    public static void main(String[] args) {
        ServiceBiblioteca biblSer = new ServiceBiblioteca();
        ServiceCarte carteSer = new ServiceCarte();
        ServiceAngajati angajatSer = new ServiceAngajati();
        ServiceAdresa adresaSer = new ServiceAdresa();
        ServiceCititor cititorSer = new ServiceCititor(carteSer);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("---------------------------------------------------");
            System.out.println("Bine ați venit!");
            System.out.println("1. Manager");
            System.out.println("2. Cititor");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți opțiunea: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch(option) {
                case 1: {
                    meniuManager(scanner, angajatSer, biblSer, carteSer, adresaSer);
                    break;
                }
                case 2: {
                    cititorSer.meniuCititor();
                    break;
                }
                case 0: {
                    System.out.println("La revedere!");
                    return;
                }
                default: {
                    System.out.println("Opțiune invalidă!");
                }
            }
        }
    }

    private static void meniuManager(Scanner scanner, ServiceAngajati angajatSer, ServiceBiblioteca biblSer, ServiceCarte carteSer, ServiceAdresa adresaSer) {
        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("Bine ați venit în meniul Manager!");
            System.out.println("1. Meniu Angajați");
            System.out.println("2. Meniu Biblioteci");
            System.out.println("3. Meniu Cărți");
            System.out.println("4. Meniu Adrese");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți opțiunea: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1: {
                    System.out.println(" Bine ați venit în meniul Angajați!");
                    angajatSer.meniuAngajati();
                    break;
                }
                case 2: {
                    System.out.println(" Bine ați venit în meniul Biblioteci!");
                    biblSer.meniuBiblioteca();
                    break;
                }
                case 3: {
                    System.out.println(" Bine ați venit în meniul Cărți!");
                    carteSer.meniuCarte();
                    break;
                }
                case 4: {
                    System.out.println(" Bine ați venit în meniul Adrese!");
                    adresaSer.meniuAdresa();
                    break;
                }
                case 0: {
                    System.out.println("La revedere!");
                    return;
                }
                default: {
                    System.out.println("Opțiune invalidă!");
                }
            }
        }
    }
}
