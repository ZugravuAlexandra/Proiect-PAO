package servicii;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import entitati.Adresa;

public class ServiceAdresa {
    private List<Adresa> adrese = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void meniuAdresa() {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Bine ati venit in meniul adresa");
            System.out.println("Cu ce va pot ajuta?");
            System.out.println("1. Adauga o adresa noua");
            System.out.println("2. Afiseaza toate adresele disponibile");
            System.out.println("3. Actualizeaza o adresa");
            System.out.println("4. Cauta o adresa dupa id-ul sau");
            System.out.println("5. Sterge o adresa");
            System.out.println("0. Iesire!");

            int p = citireOP(5);
            switch(p) {
                case 1: {
                    adaugaAdresa();
                    break;
                }
                case 2 : {
                    afisareAdresa();
                    break;
                }
                case 3 : {
                    actualizareAdresa();
                    break;
                }
                case 4 : {
                    cautareAdresa();
                    break;
                }
                case 5 : {
                    stergeAdresa();
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
            } catch (NumberFormatException e) {
                System.out.println("Trebuie sa selectati o optiune valida!");
            }
        }
        return p;
    }

    private Adresa citireAdresa() {
        System.out.println("Id: ");
        int id = citireOP(Integer.MAX_VALUE);
        System.out.println("Tara: ");
        String tara = scanner.nextLine();
        System.out.println("Oras: ");
        String oras = scanner.nextLine();
        System.out.println("Strada: ");
        String strada = scanner.nextLine();
        return new Adresa(id, tara, oras ,strada);
    }

    private void adaugaAdresa() {
        System.out.println("Adauga o adresa noua!");
        Adresa adresa = citireAdresa();
        adrese.add(adresa);
    }

    private void afisareAdresa() {
        System.out.println("Adresele disponibile sunt: ");
        for (Adresa adresa : adrese) {
            System.out.println(adresa);
        }
        if (adrese.isEmpty()) {
            System.out.println("Nu exista nicio adresa disponibila!");
        }
    }

    private void actualizareAdresa() {
        System.out.println("Introduceti id-ul adresei pe care doriti sa o actualizati: ");
        int id = citireOP(Integer.MAX_VALUE);
        for (Adresa adresa : adrese) {
            if (adresa.getId() == id) {
                System.out.println("Introduceti noile date pentru adresa cu id-ul " + id);
                Adresa adresaNoua = citireAdresa();
                adrese.set(adrese.indexOf(adresa), adresaNoua);
                return;
            }
        }
        System.out.println("Nu exista nicio adresa cu id-ul " + id);
    }

    private void cautareAdresa() {
        System.out.println("Introduceti id-ul adresei pe care doriti sa o cautati: ");
        int id = citireOP(Integer.MAX_VALUE);
        for (Adresa adresa : adrese) {
            if (adresa.getId() == id) {
                System.out.println("Adresa cu id-ul " + id + " este: ");
                System.out.println(adresa);
                return;
            }
        }
        System.out.println("Nu exista nicio adresa cu id-ul " + id);
    }

    private void stergeAdresa() {
        System.out.println("Introduceti id-ul adresei pe care doriti sa o stergeti: ");
        int id = citireOP(Integer.MAX_VALUE);
        for (Adresa adresa : adrese) {
            if (adresa.getId() == id) {
                adrese.remove(adresa);
                System.out.println("Adresa cu id-ul " + id + " a fost stearsa cu succes!");
                return;
            }
        }
        System.out.println("Nu exista nicio adresa cu id-ul " + id);
    }





}
