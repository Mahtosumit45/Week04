package JavaGenerics.MultilevelUniversityCourse;
import java.util.*;

public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Creating courses
        ExamCourse math101 = new ExamCourse("Math 101");
        AssignmentCourse cs201 = new AssignmentCourse("CS 201");
        ResearchCourse ai301 = new ResearchCourse("AI 301");

        // Wrapping in generic Course class
        Course<ExamCourse> examCourse = new Course<>(math101);
        Course<AssignmentCourse> assignmentCourse = new Course<>(cs201);
        Course<ResearchCourse> researchCourse = new Course<>(ai301);

        // Conduct evaluations
        examCourse.conductEvaluation();
        assignmentCourse.conductEvaluation();
        researchCourse.conductEvaluation();

        // Handling lists of courses with wildcards
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(math101);
        allCourses.add(cs201);
        allCourses.add(ai301);

        System.out.println("\nEvaluating all courses using CourseManager:");
        CourseManager.evaluateCourses(allCourses);
    }
}
