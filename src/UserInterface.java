import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    controller film = new controller();

    Scanner scanner = new Scanner(System.in);

    public void start() {
        int sentinel = 2;
        int tal = 0;

        /*controller.addMovie("Batman", "John", 2010, 90, "action", true);
        controller.addMovie("spiderman", "Jens", 2011, 80, "action", true);
        controller.addMovie("superman", "peter", 1999, 120, "action", true);*/

        System.out.println("\nVelkommen til min filmsamling");

        while (tal != sentinel) {
            System.out.println("\n1. Opret en film");
            System.out.println("2. Afslut");
            System.out.println("3. Vis min filmsamling");
            System.out.println("4. Søg efter en film");
            System.out.println("5. Rediger film\n");

            tal = scanner.nextInt();
            scanner.nextLine();

            if (tal == 1) {
                addMovie();
            } else if (tal == 2) {
                System.out.println("\nVi ses\n");
            } else if (tal == 3) {
                System.out.println("\nListe af film:\n");
                System.out.println(controller.instanceMovieCollection.showMovieCollectionSortedByTitle());
            } else if (tal == 4) {
                searchMovie();
            } else if (tal==5) {
                editMovie();
                
            }
        }
    }

    private void addMovie() {
        System.out.println("Angiv navnet på filmen:");
        String name = scanner.nextLine();

        System.out.println("Angiv filminstruktørens navn");
        String director = scanner.nextLine();

        System.out.println("Angiv det år filmen blev udgivet");
        int year = scanner.nextInt();

        System.out.println("Er filmen farvet eller ej");
        boolean isInColour = false;
        String colorOrNot = scanner.next().toLowerCase();
        if (colorOrNot.equals("ja")) {
            isInColour = true;
        }

        System.out.println("Angiv filmens spilletid");
        int lengthInMinutes = scanner.nextInt();

        System.out.println("Angiv filmens genre");
        String genre = scanner.next();

        controller.addMovie(name, director, year, lengthInMinutes, genre, isInColour);
        System.out.println("\nFilmen blev tilføjet");
    }

    private void searchMovie() {
        System.out.println("\nSøg efter film");
        String name = scanner.next();

        boolean fundet = false;
        ArrayList<Movie> foundFilms = controller.searchMovie(name);

        for (Movie movie : foundFilms) {
            System.out.println(movie);
            fundet = true;
        }

        if (!fundet) {
            System.out.println("ingen film med det navn fundet");
        }
        
    }
    
    public void editMovie() {
        System.out.println("Hvilken film vil du redigere i?");
        String name = scanner.nextLine();

        System.out.println("Ny titel på filmen");
        String newName = scanner.nextLine();

        System.out.println("Ny filminstruktør");
        String newDirector = scanner.nextLine();

        System.out.println("Ny udgivelsesdato");
        String newYear = scanner.nextLine();

        System.out.println("Er filmen i farve?");
        boolean newIsInColor = false;
        String colorNot = scanner.next().toLowerCase();
        if (colorNot.equals("ja")) {
            newIsInColor = true;
        }
        scanner.nextLine();

        System.out.println("Ny længde på filmen");
        String newlenghtInMinutes = scanner.nextLine();

        System.out.println("Ny genre");
        String newGenre = scanner.nextLine();

        film.editMovie(name, newName, newDirector, newYear, newIsInColor,
                newlenghtInMinutes, newGenre);

        System.out.println("Filem blev redigeret");

    }


}
