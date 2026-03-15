package course;

public class PlatformApp {
    public static void main(String[] args) {
        CourseView view = new CourseView();

        Course c1 = new Course("SFWRENG2AA4", "Software Design I - Introduction to Software Development", "Dr. David", 3, 2);
        Course c2 = new Course("COMPSCI2ME3", "Intro to Software Development", "Dr. Yuan", 5, 1);

        CourseController ctrl1 = new CourseController(c1, view);
        CourseController ctrl2 = new CourseController(c2, view);

        ctrl1.enroll(); // fills the last spot
        ctrl1.display();
        ctrl1.enroll(); // triggers overflow error
        ctrl1.drop();
        ctrl1.display();
        ctrl2.enroll();
        ctrl2.display();
        ctrl2.enroll();

        System.out.println("=== Final status ===");
        ctrl1.display();
        ctrl2.display();
    }
}
