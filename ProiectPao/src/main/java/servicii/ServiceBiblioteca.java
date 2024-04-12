package servicii;

import entitati.Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceBiblioteca {

    private List<Biblioteca> biblioteci = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void meniuBiblioteca() {
        while(true) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Bine ati venit in meniul bibliotecii");
            System.out.println("Cu ce va pot ajuta?");
            System.out.println("1. Adauga o noua biblioteca");
            System.out.println("2. Actualizeaza datele unei biblioteci");
            System.out.println("3. Arata datele despre biblioteca");
            System.out.println("4. Sterge o biblioteca");
            System.out.println("0. Inapoi");

            int p = citireOP(5);
            switch(p) {
                case 1: {
                    AdaugaBiblioteca();
                    break;
                }
                case 2 : {
                    ActualizeazaBiblioteca();
                    break;
                }
                case 3 : {
                    AfiseazaBiblioteca();
                    break;
                }
                case 4 : {
                    StergeBiblioteca();
                    break;
                }
                case 0 : {
                    return;
                }
            }

        }
    }

    private int citireOP(int maxIn) {
        int p;
        while(true) {
            try {
                p = Integer.parseInt(scanner.nextLine());
                if (p >= 0 && p <=maxIn) {
                    break;
                }
                else {
                    System.out.println("Trebuie sa selectati o optiune valida!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Selectati o optiune valida:");
            }
        }
        return p;
    }

    private Biblioteca CitesteBiblioteca () {
        System.out.println("Id: ");
        int id = citireOP(Integer.MAX_VALUE);
        System.out.println("Nume: ");
        String nume = scanner.nextLine();

        return new Biblioteca(id, nume);
    }

    private void AdaugaBiblioteca() {
        System.out.println("Adauga o biblioteca!");
        Biblioteca biblioteca = CitesteBiblioteca();
        biblioteci.add(biblioteca);
        System.out.println("Biblioteca a fost adaugata cu succes!");

    }

    private void AfiseazaBiblioteca() {
        System.out.println("Afiseaza bibliotecile!");
        if(biblioteci.isEmpty())
            System.out.println("Nu exista biblioteci care au fost inregistrate");
        else
            biblioteci.forEach(System.out::println);
    }

    private void ActualizeazaBiblioteca() {
        System.out.println("Actualizeaza biblioteca cu id-ul: ");
        int id = citireOP(Integer.MAX_VALUE);
        boolean bibliotecaGasita = false;
        for (Biblioteca biblioteca : biblioteci) {
            if (biblioteca.getId() == id) {
                System.out.println("Introdu noile date pentru biblioteca: ");
                Biblioteca updatedBiblioteca = CitesteBiblioteca();
                biblioteca.setId(updatedBiblioteca.getId());
                biblioteca.setNume(updatedBiblioteca.getNume());
                System.out.println("Biblioteca a fost actualizata cu succes!");
                bibliotecaGasita = true;
                break;
            }
        }
        if (!bibliotecaGasita) {
            System.out.println("Ne pare rau! Nu exista o biblioteca cu acest id!");
        }
    }

    private void StergeBiblioteca() {
        System.out.println("Sterge biblioteca cu Id-ul: ");
        int id = citireOP(Integer.MAX_VALUE);
        boolean bibliotecaGasita = false;
        for(Biblioteca biblioteca : biblioteci){
            if (biblioteca.getId() == id) {
                biblioteci.remove(biblioteca);
                System.out.println("Biblioteca a fost stearsa cu succes!");
                bibliotecaGasita = true;
                break;
            }
        }
        if (!bibliotecaGasita) {
            System.out.println("Ne pare rau! Nu exista o biblioteca cu acest id!");
        }
    }





}
