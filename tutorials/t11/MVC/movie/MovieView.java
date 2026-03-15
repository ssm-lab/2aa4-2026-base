package movie;

public class MovieView {
    public void displayMovie(Movie m) {
        System.out.println(m.getTitle() + " [" + m.getGenre() + "]"
            + " | $" + m.getRentalPricePerDay() + "/day"
            + " | " + (m.isAvailable() ? "Available" : "Rented"));
    }
}
