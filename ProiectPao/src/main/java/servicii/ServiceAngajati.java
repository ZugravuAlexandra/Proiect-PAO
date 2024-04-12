package servicii;

import entitati.Angajat;
import entitati.Utilizator;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class ServiceAngajati {
    private List<Angajat> angajati = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void meniuAngajati() {
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Bine ati venit in meniul angajati");
            System.out.println("Cu ce va pot ajuta?");
            System.out.println("1. Adauga un nou angajat");
            System.out.println("2. Afiseaza toti angajatii");
            System.out.println("3. Actualizeaza datele unui angajat");
            System.out.println("4. Cauta un angajat dupa id-ul sau");
            System.out.println("5. Sterge un angajat");
            System.out.println("0. Iesire!");

            int p = citireOP(5);
            switch (p) {
                case 1: {
                    adaugaAngajat();
                    break;
                }
                case 2: {
                    afiseazaAngajati();
                    break;
                }
                case 3: {
                    actualizareAngajat();
                    break;
                }
                case 4: {
                    cautareAngajat();
                    break;
                }
                case 5: {
                    stergeAngajat();
                    break;
                }
                case 0: {
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

    private Angajat citireDate() {
        System.out.println("Adauga un nou angajat:");

        System.out.println("Id: ");
        int id = citireOP(Integer.MAX_VALUE);
        System.out.println("Nume: ");
        String nume = scanner.nextLine();

        System.out.println("Prenume: ");
        String prenume = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Telefon: ");
        String telefon = scanner.nextLine();

        System.out.println("Data angajarii: ");
        String data_angajare = scanner.nextLine();

        System.out.println("Pozitie: ");
        String pozitie = scanner.nextLine();

        return new Angajat(id, nume, prenume, email, telefon, data_angajare, pozitie);



    }

    private void adaugaAngajat() {

        System.out.println("Adauga un angajat: ");
        Angajat angajat = citireDate();
        angajati.add(angajat);
        System.out.println("Angajatul a fost adaugat cu succes");

    }

    private void afiseazaAngajati() {
        System.out.println("Detalii despre anagajat: ");
        if(angajati.isEmpty())
            System.out.println("Nu exista angajati care au fost inregistrati");
        else
            angajati.forEach(System.out::println);
    }

    private void actualizareAngajat() {
        System.out.println("Actualizeaza datele unui angajat:");
        System.out.println("Introdu id-ul angajatului: ");
        int id = citireOP(Integer.MAX_VALUE);
        System.out.println(id);

        boolean angajatGasit = false;


        for (Angajat angajat : angajati) {
            if (angajat.getId() == id) {
                System.out.println("Introd noile date despre nagajat: ");
                Angajat angajatNou = citireDate();
                angajat.setId(angajatNou.getId());
                angajat.setNume(angajatNou.getNume());
                angajat.setPrenume(angajatNou.getPrenume());
                angajat.setEmail(angajatNou.getEmail());
                angajat.setTelefon(angajatNou.getTelefon());
                angajat.setData_angajare(angajatNou.getData_angajare());
                angajat.setPozitie(angajatNou.getPozitie());

                System.out.println("Angajatul a fost adaugat cu succes");
                angajatGasit = true;
                break;
            }
        }

        if(!angajatGasit) {
            System.out.println("Ne pare rau! Nu exista niciun angajat cu acest id!");

        }


    }

    private void cautareAngajat() {
        System.out.println("Cauta angajatul dupa ID:");
        int id = citireOP(Integer.MAX_VALUE);
        boolean angajatGasit = false;
        for(Angajat angajat : angajati) {
            if(angajat.getId() == id)
            {
                System.out.println(angajat);
                angajatGasit = true;
                break;
            }
        }
        if(!angajatGasit) {
            System.out.println("Ne pare rau! Nu exista niciun angajat cu acest id!");


        }

    }

    private void stergeAngajat() {
        System.out.println("Sterge angajatul cu ID-ul: ");
        int id = citireOP(Integer.MAX_VALUE);
        boolean angajatGasit = false;
        for(Angajat angajat : angajati) {
            if (angajat.getId() == id)
            {
                angajati.remove(angajat);
                System.out.println("Angajatul a fost sters cu succes!");
                angajatGasit = true;
                break;
            }
        }
        if(!angajatGasit) {
            System.out.println("Ne pare rau! Nu exista niciun angajat cu acest id!");

        }
    }






}
