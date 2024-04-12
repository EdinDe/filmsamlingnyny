import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserInterface {
    controller film = new controller();
    FileHandler fh = new FileHandler();
    MovieCollection  mc = new MovieCollection();


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
            System.out.println("5. Load film liste");
            System.out.println("6. Sorter film");
            System.out.println("7. Rediger film");
            System.out.println("8. Gem nuværende film liste");
            System.out.println("9. Afslut program");


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
            } else if (tal==5){
                fh.loadMovieList();
            }else if (tal==6){
                sortByProberty();


            }else if (tal==7) {
                editMovie();
            }else if (tal==8) {
                try {
                    // Call the saveMovieList method to save the movieCollection to a CSV file
                mc.saveMovieList();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if(tal==9){
                break;
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


    private void sortByProberty() {
        System.out.println("Primære attribut til sortering: ");
        System.out.println("1. Titel");
        System.out.println("2. instruktør");
        System.out.println("3. Udgivelsesår");
        System.out.println("4. Længde");
        System.out.println("5. Genre");
        System.out.println("6. Farvefilm");

        int primaryChoice = scanner.nextInt();

        System.out.println("Sekundære attribut til sortering: ");
        System.out.println("1. Titel");
        System.out.println("2. instruktør");
        System.out.println("3. Udgivelsesår");
        System.out.println("4. Længde");
        System.out.println("5. Genre");
        System.out.println("6. Farvefilm");

        int secondaryChoice = scanner.nextInt();

        ArrayList <Movie> sortedMovies = new ArrayList<>(controller.getInstanceMovieCollection().getMovieCollection());

        Comparator<Movie> primaryComparator=null;
        switch (primaryChoice) {
            case 1:
                sortedMovies.sort(Comparator.comparing(Movie::getName));
                break;
            case 2:
                sortedMovies.sort(Comparator.comparing(Movie::getDirector));
                break;
            case 3:
                sortedMovies.sort(Comparator.comparing(Movie::getYear));
                break;
            case 4:
                sortedMovies.sort(Comparator.comparing(Movie::getLenghtInMinutes));
                break;
            case 5:
                sortedMovies.sort(Comparator.comparing(Movie::getGenre));
                break;
            case 6:
                sortedMovies.sort(Comparator.comparing(Movie::isInColour));
                break;

        }
        Comparator<Movie> secondaryComparator = null;
        switch (secondaryChoice) {
            case 1:
                sortedMovies.sort(Comparator.comparing(Movie::getName));
                break;
            case 2:
                sortedMovies.sort(Comparator.comparing(Movie::getDirector));
                break;
            case 3:
                sortedMovies.sort(Comparator.comparing(Movie::getYear));
                break;
            case 4:
                sortedMovies.sort(Comparator.comparing(Movie::getLenghtInMinutes));
                break;
            case 5:
                sortedMovies.sort(Comparator.comparing(Movie::getGenre));
                break;
            case 6:
                sortedMovies.sort(Comparator.comparing(Movie::isInColour));
                break;
        }

        if (primaryComparator != null && secondaryComparator !=null) {
            Comparator<Movie> combinedComparator = primaryComparator.thenComparing(secondaryComparator);
            sortedMovies.sort(combinedComparator);

        } else if (primaryComparator != null) {
            sortedMovies.sort(primaryComparator);

        }


        System.out.println("\nSorterede film:");
        System.out.println();
        for (Movie movie : sortedMovies) {
            System.out.println(movie);
            System.out.println();
        }









/* userstory 13
        System.out.println("Hvordan skal filmen sorteres: ");
        System.out.println("1. Titel");
        System.out.println("2. instruktør");
        System.out.println("3. Udgivelsesår");
        System.out.println("4. Længde");
        System.out.println("5. Genre");
        System.out.println("6. Farvefilm");

        int sortChoice = scanner.nextInt();
        ArrayList <Movie> sortedMovies = new ArrayList<>(controller.getInstanceMovieCollection().getMovieCollection());

        switch (sortChoice) {
            case 1:
                sortedMovies.sort(Comparator.comparing(Movie::getName));
                break;
            case 2:
                sortedMovies.sort(Comparator.comparing(Movie::getDirector));
                break;
            case 3:
                sortedMovies.sort(Comparator.comparing(Movie::getYear));
                break;
            case 4:
                sortedMovies.sort(Comparator.comparing(Movie::getLenghtInMinutes));
                break;
            case 5:
                sortedMovies.sort(Comparator.comparing(Movie::getGenre));
                break;
            case 6:
                sortedMovies.sort(Comparator.comparing(Movie::isInColour));
                break;

        }

        System.out.println("\nSorterede film:");
        System.out.println();
        for (Movie movie : sortedMovies) {
            System.out.println(movie);
            System.out.println();
        }*/

    }
}
