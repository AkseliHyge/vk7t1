package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int i = -1;

        while (i != 0) {
            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");
            
            i = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            
            switch (i) {
                case 1:
                    addBook(scanner, library);
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    private static void addBook(Scanner scanner, Library library) {
        System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
        int bookType = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        
        System.out.println("Anna kirjan nimi:");
        String title = scanner.nextLine();
        
        System.out.println("Anna kirjailijan nimi:");
        String author = scanner.nextLine();
        
        System.out.println("Anna sivumäärä:");
        int pages = scanner.nextInt();
        
        System.out.println("Anna kirjojen määrä:");
        int copies = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        
        switch (bookType) {
            case 1:
                library.addBook(new FictionBook(title, author, pages, copies));
                System.out.println("Kirja lisätty kirjastoon!");
                break;
            case 2:
                library.addBook(new NonFictionBook(title, author, pages, copies));
                System.out.println("Kirja lisätty kirjastoon!");
                break;
            default:
                System.out.println("Virheellinen kirjatyyppi.");
                break;
        }
    }
}