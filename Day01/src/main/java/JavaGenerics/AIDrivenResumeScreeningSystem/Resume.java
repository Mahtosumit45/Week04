package JavaGenerics.AIDrivenResumeScreeningSystem;

// Generic Resume class
class Resume<T extends JobRole> {
    private T jobRole;
    private String content;

    public Resume(T jobRole, String content) {
        this.jobRole = jobRole;
        this.content = content;
    }

    public boolean processResume() {
        return jobRole.evaluateResume(content);
    }
}
