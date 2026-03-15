package course;

public class CourseController {
    private Course model;
    private CourseView view;

    public CourseController(Course model, CourseView view) {
        this.model = model;
        this.view = view;
    }

    public void enroll() {
        if (model.getCurrentEnrollment() >= model.getMaxEnrollment()) {
            view.displayError("Cannot enroll: " + model.getTitle() + " is full.");
        } else {
            model.setCurrentEnrollment(model.getCurrentEnrollment() + 1);
        }
    }

    public void drop() {
        if (model.getCurrentEnrollment() > 0) {
            model.setCurrentEnrollment(model.getCurrentEnrollment() - 1);
        }
    }

    public void display() {
        view.displayCourse(model);
    }
}
