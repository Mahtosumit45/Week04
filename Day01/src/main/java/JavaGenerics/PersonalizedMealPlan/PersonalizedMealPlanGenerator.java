package JavaGenerics.PersonalizedMealPlan;

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());

        System.out.println(veganMeal.prepareMeal());
        System.out.println(ketoMeal.prepareMeal());
    }
}
