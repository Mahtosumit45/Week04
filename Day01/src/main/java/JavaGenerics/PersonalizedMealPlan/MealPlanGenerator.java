package JavaGenerics.PersonalizedMealPlan;

// Utility class for meal plan generation
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        return new Meal<>(mealType);
    }
}
