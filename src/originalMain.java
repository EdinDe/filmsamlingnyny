/*import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        controller.java film = new controller.java();
        Scanner scanner = new Scanner(System.in);
        int sentinel = 2;
        int tal = 0;

        film.addMovie("Batman", "John", 2010, 90, "action", true);
        film.addMovie("spiderman", "Jens", 2011, 80, "action", true);
        film.addMovie("superman", "peter", 1999, 120, "action", true);


        System.out.println("\nVelkommen til min filmsamling");

        while (tal != sentinel) {
            System.out.println("\n1. Opret en film");
            System.out.println("2. Afslut");
            System.out.println("3. Vis min filmsamling");
            System.out.println("4. Søg efter en film\n");

            tal = scanner.nextInt();
            scanner.nextLine();

            if (tal == 1) {
                System.out.println("Enter movie name:");
                String name = scanner.nextLine();

                System.out.println("Enter directors name");
                String director = scanner.nextLine();

                System.out.println("Enter the year the movie was made");
                int year = scanner.nextInt();

                System.out.println("is it in colour");
                boolean isInColour = false;
                String ColororNot = scanner.next().toLowerCase();
                if (ColororNot.equals("ja")) {
                    isInColour = true;
                }

                System.out.println("Enter how long the movie is in minutes");
                int lenghtInMinutes = scanner.nextInt();

                System.out.println("Enter the genre");
                String genre = scanner.next();


                film.addMovie(name, director, year, lenghtInMinutes, genre, isInColour);
                System.out.println("\nFilmen blev tilføjet");

            } else if (tal == 2) {
                System.out.println("\nVi ses\n");
            } else if (tal == 3) {
                System.out.println("\nListe af film:\n");
                System.out.println(film.showMovieCollection());
            } else if (tal == 4) {
                System.out.println("\nSøg efter film");
                String name = scanner.next();


                boolean fundet = false;
                ArrayList<Movie> foundFilms = film.searchMovie(name);

                for (Movie movie : foundFilms) {
                    System.out.println(movie);
                    fundet = true;
                }

                if (!fundet) {
                    System.out.println("ingen film med det navn fundet");

                }

            }
        }
    }
}*/


