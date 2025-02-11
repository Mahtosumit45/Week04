package JavaGenerics.MultilevelUniversityCourse;
import java.util.*;

// Utility class to handle lists of courses using wildcards
class CourseManager {
    public static void evaluateCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}
