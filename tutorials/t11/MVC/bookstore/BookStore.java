package bookstore;

public class BookStore {
    public static void main(String[] args) {
        Book model = new Book("Book Title", "Book Author");
        BookView view = new BookView();
        BookController controller = new BookController(model, view);

        controller.updateView();

        controller.setBookTitle("New Title");
        controller.setBookAuthor("New Author");
        controller.updateView();
    }  
}
