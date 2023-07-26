package code;

public class User {
    private String email;
    private String name;
    private String sex;
    private String[] hobbies;

    public User() {
        email = new String();
        name = new String();
        sex = new String();
        hobbies = new String[]{null, null, null, null};
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
