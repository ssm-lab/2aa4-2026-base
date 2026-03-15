package hospital;

public class PatientView {
    public void printPatientDetails(int id, String name, String diagnosis, String doctor) {
        System.out.println("Patient ID: " + id);
        System.out.println("Name:       " + name);
        System.out.println("Diagnosis:  " + diagnosis);
        System.out.println("Doctor:     " + doctor);
        System.out.println("---");
    }
}
