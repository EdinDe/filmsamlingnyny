public class Movie {

    String name;
    String director;
    private int year;
    private int lenghtInMinutes;
    String genre;
    private boolean isInColour;

    public Movie(String name, String director, int year, int lenghtInMinutes, String genre,
                 boolean isInColour) {
        this.name=name;
        this.director=director;
        this.year=year;
        this.lenghtInMinutes=lenghtInMinutes;
        this.genre=genre;
        this.isInColour=isInColour;

    }
    public String getName(){
        return name;
    }
    public String getDirector(){
        return director;
    }
    public int getYear(){
        return year;
    }
    public int getLenghtInMinutes(){
        return lenghtInMinutes;
    }
    public String getGenre(){
        return genre;
    }

    public boolean isInColour(){
        return isInColour;
    }

    @Override
    public String toString(){
        String result = "";
        result += "Titel: " + name + "\nDirector: " + director + "\nYear: " + year + "\nColored: " + isInColour;


/*
        if (isInColour){
            result+="ja";
        }else {
            result+="nej";
        }
*/
        result+= "\nLength: " + lenghtInMinutes + " minutes " + "\nGenre: " + genre;

        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLenghtInMinutes(int lenghtInMinutes) {
        this.lenghtInMinutes = lenghtInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setInColor(boolean isInColour) {
        this.isInColour = isInColour;
    }


}
