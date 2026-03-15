package course;

public class Course {
    private String courseCode;
    private String title;
    private String instructorName;
    private int maxEnrollment;
    private int currentEnrollment;

    public Course(String courseCode, String title, String instructorName, int maxEnrollment, int currentEnrollment) {
        this.courseCode = courseCode;
        this.title = title;
        this.instructorName = instructorName;
        this.maxEnrollment = maxEnrollment;
        this.currentEnrollment = currentEnrollment;
    }

    public String getCourseCode() { 
        return courseCode; 
    }
    public String getTitle() { 
        return title; 
    }
    public String getInstructorName() { 
        return instructorName; 
    }
    public int getMaxEnrollment() { 
        return maxEnrollment; 
    }
    public int getCurrentEnrollment() { 
        return currentEnrollment; 
    }
    public void setCurrentEnrollment(int n) { 
        this.currentEnrollment = n; 
    }
}
