import java.util.ArrayList;

public class controller {

    static MovieCollection instanceMovieCollection = new MovieCollection();


    public controller() {

    }

    public static void addMovie(String name, String director, int year, int lenghtInMinutes, String genre, boolean isInColour) {
        instanceMovieCollection.addMovie(name, director, year, lenghtInMinutes, genre, isInColour);

    }

    public ArrayList<String> listOfMovieTitles() {
        return instanceMovieCollection.listOfMovieTitles();

    }

    public static MovieCollection getInstanceMovieCollection() {
        return instanceMovieCollection;
    }

    public void getList() {
        instanceMovieCollection.getList();
    }

    public static String showMovieCollection() {
        return instanceMovieCollection.showMovieCollection();
    }

    public static ArrayList<Movie> searchMovie(String search) {
        return instanceMovieCollection.searchMovieTitle(search);
    }
    public void editMovie(String name, String newName, String newDirector, String newYear, boolean newIsInColor, String newLengthInMinutes, String newGenre) {
        ArrayList<Movie> moviesToEdit = instanceMovieCollection.searchMovieTitle(name);
        if (!moviesToEdit.isEmpty()) {
            Movie movieToEdit = moviesToEdit.getFirst();

            movieToEdit.setName(newName);
            movieToEdit.setDirector(newDirector);
            movieToEdit.setInColor(newIsInColor);
            movieToEdit.setLenghtInMinutes(Integer.parseInt(newLengthInMinutes));
            movieToEdit.setYear(Integer.parseInt(newYear));
            movieToEdit.setGenre(newGenre);
        } else {
            System.out.println("Der blev ikke fundet en film med navnet " + name);
        }
    }
}
