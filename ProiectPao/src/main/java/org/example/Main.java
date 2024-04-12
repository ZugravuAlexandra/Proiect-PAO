package org.example;

import java.util.Scanner;
import servicii.ServiceBiblioteca;
import servicii.ServiceCarte;

public class Main {
    public static void main(String[] args) {

        ServiceBiblioteca biblSer = new ServiceBiblioteca();
        ServiceCarte carteSer = new ServiceCarte();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("Meniu Principal");
            System.out.println("1. Gestionare Biblioteci");
            System.out.println("2. Gestionare Cărți");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți opțiunea: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    biblSer.meniuBiblioteca();
                    break;
                case 2:
                    carteSer.meniuCarte();
                    break;
                case 0:
                    System.out.println("La revedere!");
                    return;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        }
    }
}
