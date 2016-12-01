/**
 * Created by Acer on 01.12.2016.
 */
public class Person {
    private String name;
    private int age;
    private boolean gender;
    private int height;

    public Person(String name, int age, boolean gender, int height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public boolean getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return new String(name + ", age: " + age + ", gender: " + gender + ", height: " + height);
    }
}
