package hospital;

public class HospitalApp {
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Alice Smith", "Hypertension", "Dr. Adams");
        Patient p2 = new Patient(2, "Bob Jones",  "Migraine",     "Dr. Baker");

        PatientView view = new PatientView();
        PatientController c1 = new PatientController(p1, view);
        PatientController c2 = new PatientController(p2, view);

        System.out.println("=== Before update ===");
        c1.updateView();
        c2.updateView();

        c1.setDiagnosis("Hypertension + Type 2 Diabetes");

        System.out.println("=== After update ===");
        c1.updateView();
        c2.updateView();
    }
}
