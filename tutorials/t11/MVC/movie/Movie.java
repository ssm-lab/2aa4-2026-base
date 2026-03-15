package movie;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private double rentalPricePerDay;
    private boolean available;

    public Movie(int movieId, String title, String genre, double rentalPricePerDay, boolean available) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = available;
    }

    public int getMovieId() { 
        return movieId; 
    }
    public String getTitle() { 
        return title; 
    }
    public String getGenre() { 
        return genre; 
    }
    public double getRentalPricePerDay() { 
        return rentalPricePerDay; 
    }
    public boolean isAvailable() { 
        return available; 
    }
    public void setAvailable(boolean available) { 
        this.available = available; 
    }
}
