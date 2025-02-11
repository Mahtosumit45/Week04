package JavaGenerics.MultilevelUniversityCourse;

import java.util.*;
// Abstract CourseType class
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract void evaluate();
}
