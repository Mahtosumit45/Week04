package QueueInterface.HospitalTriageSystem;

public class Main {
    public static void main(String[] args) {
        TriageSystem triageSystem = new TriageSystem();

        // Adding patients
        triageSystem.addPatient("John", 3);
        triageSystem.addPatient("Alice", 5);
        triageSystem.addPatient("Bob", 2);

        // Treating patients based on severity
        System.out.println("Patients treated in order:");
        while (!triageSystem.isEmpty()) {
            System.out.println(triageSystem.treatNextPatient());
        }
    }
}

