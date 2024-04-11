import java.util.ArrayList;

public class MovieCollection {

    private FileHandler filehandler = new FileHandler();

    private ArrayList<Movie> movieCollection;


    public MovieCollection() {
        this.movieCollection = new ArrayList<>();
    }

    public void addMovie(String name, String director, int year, int lenghtInMinutes, String genre, boolean isInColour) {
        movieCollection.add(new Movie(name, director, year, lenghtInMinutes, genre, isInColour));
        filehandler.saveMovieList(movieCollection);
    }

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
        return result;

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






    }

