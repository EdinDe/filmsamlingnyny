import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class FileHandler {
    private final File file = new File("filmliste.csv");

    public ArrayList<Movie> loadMovieList() {
        ArrayList<Movie> movielist = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            sc.nextLine();  // Skip første linje

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Movie movie = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();    // Split linje og læg tokens i attributter
            String[] attributes = line.split(",");
            movie = new Movie(
                    (attributes[0]), // filmnavn
                    (attributes[1]), // film direktør
                    (Integer.parseInt(attributes[2])), // film dato
                    (Integer.parseInt(attributes[3])), // film længde
                    (attributes[4]),
                    Boolean.parseBoolean(attributes[5])
            );

            movielist.add(movie);

        }
        sc.close();
        return movielist;


    }

    public void saveMovieList(ArrayList<Movie> movieCollection) {
    }
}