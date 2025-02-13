package QueueInterface.HospitalTriageSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriageSystemTest {

    @Test
    void testPatientTreatmentOrder() {
        TriageSystem triageSystem = new TriageSystem();
        triageSystem.addPatient("John", 3);
        triageSystem.addPatient("Alice", 5);
        triageSystem.addPatient("Bob", 2);

        assertEquals("Alice", triageSystem.treatNextPatient().getName()); // Highest severity
        assertEquals("John", triageSystem.treatNextPatient().getName());
        assertEquals("Bob", triageSystem.treatNextPatient().getName());  // Lowest severity
    }

    @Test
    void testEmptyQueue() {
        TriageSystem triageSystem = new TriageSystem();
        assertNull(triageSystem.treatNextPatient()); // No patients to treat
    }

    @Test
    void testSinglePatient() {
        TriageSystem triageSystem = new TriageSystem();
        triageSystem.addPatient("Emma", 4);

        assertEquals("Emma", triageSystem.treatNextPatient().getName());
        assertTrue(triageSystem.isEmpty());
    }

    @Test
    void testQueueSize() {
        TriageSystem triageSystem = new TriageSystem();
        triageSystem.addPatient("Tom", 1);
        triageSystem.addPatient("Jerry", 4);

        assertEquals(2, triageSystem.getQueueSize());
        triageSystem.treatNextPatient(); // Treat highest severity
        assertEquals(1, triageSystem.getQueueSize());
    }
}
