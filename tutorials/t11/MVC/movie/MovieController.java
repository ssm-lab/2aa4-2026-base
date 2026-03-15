package movie;

public class MovieController {
    private Movie model;
    private MovieView view;

    public MovieController(Movie model, MovieView view) {
        this.model = model;
        this.view = view;
    }

    public void toggleAvailability() {
        model.setAvailable(!model.isAvailable());
    }

    public void display() {
        view.displayMovie(model);
    }
}
