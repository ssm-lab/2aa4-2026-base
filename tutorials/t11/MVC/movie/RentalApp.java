package movie;

public class RentalApp {
    public static void main(String[] args) {
        MovieView view = new MovieView();

        Movie m1 = new Movie(1, "Inception",      "Sci-Fi",  3.99, true);
        Movie m2 = new Movie(2, "The Godfather",  "Drama",   2.99, false);
        Movie m3 = new Movie(3, "Interstellar",   "Sci-Fi",  3.99, false);

        MovieController c1 = new MovieController(m1, view);
        MovieController c2 = new MovieController(m2, view);
        MovieController c3 = new MovieController(m3, view);

        System.out.println("=== Current catalog ===");
        c1.display(); c2.display(); c3.display();

        // Simulate return of The Godfather
        c2.toggleAvailability();

        System.out.println("\n=== After return ===");
        c1.display(); c2.display(); c3.display();
    }
}

