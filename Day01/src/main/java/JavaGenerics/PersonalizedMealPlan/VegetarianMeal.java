package JavaGenerics.PersonalizedMealPlan;

// Concrete Meal Types
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}
