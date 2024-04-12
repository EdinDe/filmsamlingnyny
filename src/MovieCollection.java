import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class MovieCollection {

    private FileHandler filehandler = new FileHandler();

    public ArrayList<Movie> movieCollection;



    public MovieCollection() {
        this.movieCollection = new ArrayList<>();
    }
    public void saveMovieList() throws IOException {
        File file = new File("filmliste.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        // Write CSV header
        bw.write("name, director, year, length In Minutes, genre, isInColour");
        bw.newLine();

        // Write each movie to the CSV file
        for (Movie movie : movieCollection) {
            bw.write(String.format("%s, %s, %d, %d, %s, %b",
                    movie.getName(), movie.getDirector(), movie.getYear(), movie.getLenghtInMinutes(), movie.getGenre(), movie.isInColour()));
            bw.newLine();
        }

        // Close BufferedWriter and FileWriter
        bw.close();
        fw.close();

        System.out.println("Movies saved to filmliste.csv");
    }

    public void addMovie(String name, String director, int year, int lenghtInMinutes, String genre, boolean isInColour) {
        movieCollection.add(new Movie(name, director, year, lenghtInMinutes, genre, isInColour));

    }


    /*private void loadListOfNames() {
        String array[] = new String[movieCollection.size()];// ArrayList to String Array conversion
        for(int j =0;j<movieCollection.size();j++){
            array[j] = String.valueOf(movieCollection.get(j));
        }


        System.out.println("""
                Enter names
                -----------
                Enter each name you want to add to the list. End by entering an empty name.
                """);
        Scanner sc = null;
        try {
            sc = new Scanner(new File("filmliste.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String name = "-nothing yet-";
        while(!name.isBlank() && sc.hasNextLine()) {
            name = sc.nextLine();
            if(!name.isBlank()) {
                toString(name);
                System.out.println("List has been loaded!");
            }
        }
        System.out.println("Done");

    }*/

    public ArrayList<String> listOfMovieTitles() {
        ArrayList<String> localListOfMovieTitles = new ArrayList<>();
        for (int i = 0; i < movieCollection.size(); i++) {
            localListOfMovieTitles.add(movieCollection.get(i).getName());
        }
        return localListOfMovieTitles;
    }

    public void getList() {
        for (Movie m : movieCollection) {
            System.out.println(m.toString());
        }
    }

    public String showMovieCollection() {
        String result = "";
        for (Movie movie : movieCollection) {
            result += movie.toString() + "\n\n";

        }
        return result.toString();

    }

    public ArrayList<Movie> searchMovieTitle(String name) {
        ArrayList<Movie> searchResult = new ArrayList<>();
        for (Movie mov : movieCollection) {
            if (mov.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResult.add(mov);
                //break; til at vise film enkeltvis
                }
            }
            return searchResult;
        }

    public void sortMoviesByTitle() {
        Collections.sort(movieCollection, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m1.getName().compareToIgnoreCase(m2.getName());
            }
        });
    }

    public String showMovieCollectionSortedByTitle() {
        sortMoviesByTitle();
        return showMovieCollection();

    }

    public ArrayList<Movie> getMovieCollection(){
        return movieCollection;
    }
}