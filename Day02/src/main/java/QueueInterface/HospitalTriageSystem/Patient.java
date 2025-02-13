package QueueInterface.HospitalTriageSystem;

import java.util.Objects;

public class Patient implements Comparable<Patient> {
    private final String name;
    private final int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Higher severity should come first
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return severity == patient.severity && Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, severity);
    }
}

