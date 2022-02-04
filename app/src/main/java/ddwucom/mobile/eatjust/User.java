package ddwucom.mobile.eatjust;

import java.io.Serializable;

public class User implements Serializable {
    private String age, height, weight, cycle, latest;
    private int pregnancy, pCalorie;

    public User(String age, String height, String weight, int pregnancy, String cycle, String latest) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.pregnancy = pregnancy;
        this.cycle = cycle;
        this.latest = latest;
    }

    public String getAge() { return age; }
    public void setAge(String birth) { this.age = age; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }

    public int getPregnancy() { return pregnancy; }
    public void setPregnancy(int pregnancy) { this.pregnancy = pregnancy; }

    public String getCycle() { return cycle; }
    public void setCycle(String cycle) { this.cycle = cycle; }

    public String getLatest() { return latest; }
    public void setLatest(String latest) { this.latest = latest; }

    public int calcPCalorie() {
        pCalorie = (int) (655 + (9.6 * Integer.parseInt(getWeight())) + (1.8 * Integer.parseInt(getHeight())) - (4.7 * Integer.parseInt(getAge())) * 1.22);
        return pCalorie;
    }

    public int getPCalorie() { return pCalorie; }
    public void setPCalorie(int pCalorie) { this.pCalorie = pCalorie; }
}
