package JavaGenerics.PersonalizedMealPlan;

class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public String prepareMeal() {
        return "Preparing " + mealType.getMealType();
    }
}
