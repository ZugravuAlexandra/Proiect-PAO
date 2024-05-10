package servicii;

import entitati.Carte;
import entitati.Sectiuni;
import entitati.Recenzii;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class ServiceCarte {
    private List<Carte> carti = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public void meniuCarte() {
        while(true) {
            System.out.println("----------------------------------------");
            System.out.println("Bine ati venit in meniul carte");
            System.out.println("Cu ce va pot ajuta?");
            System.out.println("1. Adauga o carte noua");
            System.out.println("2. Afiseaza toate cartile disponibile");
            System.out.println("3. Actualizeaza o carte");
            System.out.println("4. Cauta o carte dupa id-ul sau");
            System.out.println("5. Sterge o carte");
            System.out.println("0. Iesire!");

            int p = citireOP(5);
            switch(p) {
                case 1: {
                    adaugaCarte();
                    break;
                }
                case 2 : {
                    afisareCarte();
                    break;
                }
                case 3 : {
                    actualizareCarte();
                    break;
                }
                case 4 : {
                    cautareCarte();
                    break;
                }
                case 5 : {
                    stergeCarte();
                    break;
                }
                case 0 : {
                    return;
                }
            }


        }

    }

    private Carte citireCarte() {
        System.out.println("Id: ");
        int id = citireOP(Integer.MAX_VALUE);

        //verificare daca id-ul este unic
        for(Carte carte : carti) {
            if(carte.getId() == id) {
                System.out.println("Id-ul trebuie sa fie unic!");
                return citireCarte();
            }
        }
        System.out.println("Titlu: ");
        String titlu = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("Editura: ");
        String editura = scanner.nextLine();
        System.out.println("Sectiune: ");
        String sectiune = scanner.nextLine();
        System.out.println("Descriere: ");
        String descriere = scanner.nextLine();

        List<Recenzii> recenzii = new ArrayList<>();
        System.out.println("Recenzii (introduceți 'stop' pentru a opri introducerea): ");
        while (true) {
            System.out.println("Utilizator: ");
            String individ = scanner.nextLine();
            if (individ.equalsIgnoreCase("stop")) {
                break;
            }
            System.out.println("Recenzie: ");
            String recenzie = scanner.nextLine();
            recenzii.add(new Recenzii(individ, recenzie));
        }
        return new Carte(id, titlu, autor, editura, new Sectiuni(sectiune), descriere, recenzii);
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

    public List<Carte> getCarti() {
        return carti;
    }
    private void adaugaCarte() {
        System.out.println("Adaugati o carte: ");
        Carte carte = citireCarte();
        carti.add(carte);
        System.out.println("Cartea a fost adaugata cu succes!");
    }

    private void afisareCarte() {
        System.out.println("Detalii despre carte");
        if(carti.isEmpty())
            System.out.println("Nu exista carti care au fost inregistrate");
        else
            carti.forEach(System.out::println);
    }

    private void actualizareCarte() {
        System.out.println("Actualizeaza detaliile despre carte cu id-ul: ");
        int id = citireOP(Integer.MAX_VALUE);
        boolean carteGasita = false;
        for(Carte carte : carti) {
            if (carte.getId() == id){
                System.out.println("Introdu noile date depsre carte: ");
                Carte updateCarte = citireCarte();
                carte.setId(updateCarte.getId());
                carte.setTitlu(updateCarte.getTitlu());
                carte.setAutor(updateCarte.getAutor());
                carte.setEditura(updateCarte.getEditura());
                carte.setSectiune(updateCarte.getSectiune());
                carte.setDescriere(updateCarte.getDescriere());
                carte.setRecenzii(updateCarte.getRecenzii());

                System.out.println("Cartea a fost actualizata cu succes! ");
                carteGasita = true;
                break;

            }
        }

        if(!carteGasita) {
            System.out.println("Ne pare rau! Nu exista nicio carte cu acest id!");


        }
    }

    private void cautareCarte() {
        System.out.println("Cauta cartea cu id-ul: ");
        int id = citireOP(Integer.MAX_VALUE);
        boolean carteGasita = false;
        for(Carte carte : carti) {
            if(carte.getId() == id)
            {
                System.out.println(carte);
                carteGasita = true;
                break;
            }
        }
        if(!carteGasita) {
            System.out.println("Ne pare rau! Nu exista nicio carte cu acest id!");


        }

    }

    private void stergeCarte() {
        System.out.println("Sterge cartea cu ID-ul: ");
        int id = citireOP(Integer.MAX_VALUE);
        boolean carteGasita = false;
        for(Carte carte : carti) {
            if (carte.getId() == id)
            {
                carti.remove(carte);
                System.out.println("Cartea a fost stearsa cu succes!");
                carteGasita = true;
                break;
            }
        }
        if(!carteGasita) {
            System.out.println("Ne pare rau! Nu exista nicio carte cu acest id!");

        }

    }



}



