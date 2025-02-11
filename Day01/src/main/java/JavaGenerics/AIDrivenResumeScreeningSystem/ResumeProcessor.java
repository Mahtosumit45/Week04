package JavaGenerics.AIDrivenResumeScreeningSystem;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
// Utility class to process multiple resumes
class ResumeProcessor {
    public static void evaluateResumes(List<? extends JobRole> jobRoles, String resumeContent) {
        for (JobRole jobRole : jobRoles) {
            System.out.println("Evaluating for " + jobRole.getRoleName() + ": " + jobRole.evaluateResume(resumeContent));
        }
    }
}
