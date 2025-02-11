package JavaGenerics.MultilevelUniversityCourse;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UniversityCourseManagementTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testExamCourseEvaluation() {
        ExamCourse examCourse = new ExamCourse("Math 101");
        examCourse.evaluate();
        assertTrue(outputStream.toString().contains("Math 101 is evaluated through exams."));
    }

    @Test
    void testAssignmentCourseEvaluation() {
        AssignmentCourse assignmentCourse = new AssignmentCourse("CS 201");
        assignmentCourse.evaluate();
        assertTrue(outputStream.toString().contains("CS 201 is evaluated through assignments."));
    }

    @Test
    void testResearchCourseEvaluation() {
        ResearchCourse researchCourse = new ResearchCourse("AI 301");
        researchCourse.evaluate();
        assertTrue(outputStream.toString().contains("AI 301 is evaluated through research papers."));
    }

    @Test
    void testCourseManagerEvaluation() {
        List<CourseType> courses = new ArrayList<>();
        courses.add(new ExamCourse("Math 101"));
        courses.add(new AssignmentCourse("CS 201"));
        courses.add(new ResearchCourse("AI 301"));

        CourseManager.evaluateCourses(courses);
        String output = outputStream.toString();
        assertTrue(output.contains("Math 101 is evaluated through exams."));
        assertTrue(output.contains("CS 201 is evaluated through assignments."));
        assertTrue(output.contains("AI 301 is evaluated through research papers."));
    }
}

