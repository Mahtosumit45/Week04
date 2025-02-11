package JavaGenerics.AIDrivenResumeScreeningSystem;

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public boolean evaluateResume(String resumeContent) {
        return resumeContent.contains("Agile") || resumeContent.contains("Scrum");
    }
}
