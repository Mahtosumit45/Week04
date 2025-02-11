package JavaGenerics.PersonalizedMealPlan;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
class PersonalizedMealPlanGeneratorTest {
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
    void testVegetarianMeal() {
        Meal<VegetarianMeal> meal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        assertEquals("Preparing Vegetarian Meal", meal.prepareMeal());
    }

    @Test
    void testVeganMeal() {
        Meal<VeganMeal> meal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        assertEquals("Preparing Vegan Meal", meal.prepareMeal());
    }

    @Test
    void testKetoMeal() {
        Meal<KetoMeal> meal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        assertEquals("Preparing Keto Meal", meal.prepareMeal());
    }

    @Test
    void testHighProteinMeal() {
        Meal<HighProteinMeal> meal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
        assertEquals("Preparing High Protein Meal", meal.prepareMeal());
    }
}