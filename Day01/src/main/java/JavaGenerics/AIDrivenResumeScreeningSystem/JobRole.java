package JavaGenerics.AIDrivenResumeScreeningSystem;
// Abstract JobRole class
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract boolean evaluateResume(String resumeContent);
}
