package JavaGenerics.MultilevelUniversityCourse;

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated through research papers.");
    }
}
