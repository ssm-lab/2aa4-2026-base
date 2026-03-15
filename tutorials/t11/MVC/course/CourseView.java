package course;

public class CourseView {
    public void displayCourse(Course c) {
        System.out.println("[" + c.getCourseCode() + "] " + c.getTitle()
            + " | Instructor: " + c.getInstructorName()
            + " | Enrollment: " + c.getCurrentEnrollment() + "/" + c.getMaxEnrollment());
    }

    public void displayError(String message) {
        System.out.println("ERROR: " + message);
    }
}
