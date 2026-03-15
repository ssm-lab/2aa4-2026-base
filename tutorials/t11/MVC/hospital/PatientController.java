package hospital;

public class PatientController {
    private Patient model;
    private PatientView view;

    public PatientController(Patient model, PatientView view) {
        this.model = model;
        this.view = view;
    }

    public void setDiagnosis(String diagnosis) { 
        model.setDiagnosis(diagnosis); 
    }
    public void setAssignedDoctor(String doctor) { 
        model.setAssignedDoctor(doctor); 
    }

    public String getDiagnosis() { 
        return model.getDiagnosis(); 
    }
    public String getAssignedDoctor() { 
        return model.getAssignedDoctor(); 
    }

    public void updateView() {
        view.printPatientDetails(
            model.getPatientId(),
            model.getFullName(),
            model.getDiagnosis(),
            model.getAssignedDoctor()
        );
    }
}
