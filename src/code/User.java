package code;

// �û��ķ�װ
// ����һ�� User ���װÿ���û����󣬰��� email, name, sex, hobbies;

public class User {
    private String email;
    private String name;
    private String sex;
    private String hobbies;

    public User() {
        email = new String();
        name = new String();
        sex = new String();
        hobbies = new String();
    }

    public User(String email, String name, String sex, String hobbies) {
        this.email = email;
        this.name = name;
        this.sex = sex;
        this.hobbies = hobbies;
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

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
