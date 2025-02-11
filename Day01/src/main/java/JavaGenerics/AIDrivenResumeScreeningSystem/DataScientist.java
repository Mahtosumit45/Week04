package JavaGenerics.AIDrivenResumeScreeningSystem;
class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public boolean evaluateResume(String resumeContent) {
        return resumeContent.contains("Machine Learning") || resumeContent.contains("Data Analysis");
    }
}
