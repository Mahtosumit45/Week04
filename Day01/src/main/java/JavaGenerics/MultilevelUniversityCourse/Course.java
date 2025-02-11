package JavaGenerics.MultilevelUniversityCourse;

// Generic Course class
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public void conductEvaluation() {
        courseType.evaluate();
    }
}

