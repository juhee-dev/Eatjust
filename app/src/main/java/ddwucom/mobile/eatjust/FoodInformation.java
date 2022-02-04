package ddwucom.mobile.eatjust;

public class FoodInformation {
    private long _id;
    private String name;
    private int serving;
    private float calorie;
    private float fat;
    private float protein;
    private float carbohydrate;

    public FoodInformation(long _id, String name, int serving, float calorie, float carbohydrate, float protein, float fat) {
        this._id = _id;
        this.name = name;
        this.serving = serving;
        this.calorie = calorie;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public FoodInformation(String name, int serving, float calorie, float carbohydrate, float protein, float fat) {
        this.name = name;
        this.serving = serving;
        this.calorie = calorie;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
    }

    public long get_id() {
        return _id;
    }
    public void set_id(long _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getServing() {
        return serving;
    }
    public void setServing(int serving) {
        this.serving = serving;
    }
    public float getCalorie() {
        return calorie;
    }
    public void setCalorie(float calorie) {
        this.calorie = calorie;
    }
    public float getCarbohydrate() {
        return carbohydrate;
    }
    public void setCarbohydrate(float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
    public float getProtein() {
        return protein;
    }
    public void setProtein(float protein) {
        this.protein = protein;
    }
    public float getFat() {
        return fat;
    }
    public void setFat(float fat) {
        this.fat = fat;
    }
}
