package bookstore;

public class BookController {
    private Book model;
    private BookView view;

    public BookController(Book model, BookView view) {
        this.model = model;
        this.view = view;
    }

    public void setBookTitle(String title) {
        model.setTitle(title);
    }

    public String getBookTitle() {
        return model.getTitle();
    }

    public void setBookAuthor(String author) {
        model.setAuthor(author);
    }

    public String getBookAuthor() {
        return model.getAuthor();
    }

    public void updateView() {
        view.printBookDetails(model.getTitle(), model.getAuthor());
    }
}
