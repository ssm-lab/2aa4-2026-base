package hospital;

public class Patient {
    private int patientId;
    private String fullName;
    private String diagnosis;
    private String assignedDoctor;

    public Patient(int patientId, String fullName, String diagnosis, String assignedDoctor) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.diagnosis = diagnosis;
        this.assignedDoctor = assignedDoctor;
    }

    public int getPatientId() { 
        return patientId; 
    }
    public String getFullName() { 
        return fullName; 
    }
    public String getDiagnosis() { 
        return diagnosis; 
    }
    public String getAssignedDoctor() { 
        return assignedDoctor; 
    }
    public void setDiagnosis(String diagnosis) { 
        this.diagnosis = diagnosis; 
    }
    public void setAssignedDoctor(String doctor) { 
        this.assignedDoctor = doctor; 
    }
}