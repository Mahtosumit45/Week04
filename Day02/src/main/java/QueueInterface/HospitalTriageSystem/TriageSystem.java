package QueueInterface.HospitalTriageSystem;

import java.util.PriorityQueue;
import java.util.Queue;

public class TriageSystem {
    private final Queue<Patient> patientQueue;

    public TriageSystem() {
        this.patientQueue = new PriorityQueue<>();
    }

    public void addPatient(String name, int severity) {
        Patient patient = new Patient(name, severity);
        patientQueue.add(patient);
    }

    public Patient treatNextPatient() {
        return patientQueue.poll(); // Removes and returns highest-priority patient
    }

    public boolean isEmpty() {
        return patientQueue.isEmpty();
    }

    public int getQueueSize() {
        return patientQueue.size();
    }
}

