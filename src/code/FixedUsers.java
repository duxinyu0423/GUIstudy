package code;

import java.util.List;

public class FixedUsers {
    private UserDao users; // user 要共享
    // 创建用户对象
    private User Jerry;
    private User Tom;
    private User Harper;
    private User Ashley;
    private User Alex;
    private User Astrid;
    private User Kerwin;
    private User Sylvia;
    private User Dylan;
    private User Douglas;
    private User Hazel;
    private User Kaia;
    private User Arthur;
    private User Owen;
    private User Iris;
    private User Eden;
    private User Wade;
    private User Ryan;
    private User Felix;
    private User Calliope;
    private User Barry;

    public FixedUsers() {
        users = new UserDaoImpForList();
        Jerry = new User("18354384051@163.com", "Jerry", "female", "surfing the Internet  playing games  ");
        Tom = new User("5186246545@126.com", "Tom", "male", "sports  surfing the Internet  ");
        Harper = new User("3448563435@qq.com", "Harper", "female", "reading books  playing games  ");
        Ashley = new User("1435432453@139.com", "Ashley", "female", "sports  surfing the Internet  reading books  ");
        Alex = new User("354765435@126.com", "Alex", "male", "surfing the Internet  ");
        Astrid = new User("35754525763@qq.com", "Astrid", "female", "sports  reading books  ");
        Kerwin = new User("32135746978@163.com", "Kerwin", "male", "sports  ");
        Sylvia = new User("5438745432@126.com", "Sylvia", "female", "playing games  ");
        Dylan = new User("7386346453@163.com", "Dylan", "male", "surfing the Internet  playing games  ");
        Douglas = new User("3454325464@126.com", "Douglas", "male", "playing games  ");
        Hazel = new User("746352416@163.com", "Hazel", "female", "sports  reading books  playing games  ");
        Kaia = new User("1310042351@139.com", "Kaia", "female", "sports  ");
        Arthur = new User("2402740524@126.com", "Arthur", "male", "surfing the Internet  ");
        Owen = new User("746024552@139.com", "Owen", "female", "playing games  ");
        Iris = new User("210574642@qq.com", "Iris", "female", "surfing the Internet  ");
        Eden = new User("4804034586@163.com", "Eden", "male", "sports  surfing the Internet  ");
        Wade = new User("3540463040@163.com", "Wade", "female", "playing games  ");
        Ryan = new User("7504604440@qq.com", "Ryan", "male", "sports  playing games  ");
        Felix = new User("6875404864@139.com", "Felix", "female", "reading books  ");
        Calliope = new User("7068745224@qq.com", "Calliope", "female", "surfing the Internet  ");
        Barry = new User("746655780@163.com", "Barry", "male", "sports  reading books  ");
        users.insert(Jerry);
        users.insert(Tom);
        users.insert(Harper);
        users.insert(Ashley);
        users.insert(Alex);
        users.insert(Astrid);
        users.insert(Kerwin);
        users.insert(Sylvia);
        users.insert(Dylan);
        users.insert(Douglas);
        users.insert(Hazel);
        users.insert(Kaia);
        users.insert(Arthur);
        users.insert(Owen);
        users.insert(Iris);
        users.insert(Eden);
        users.insert(Wade);
        users.insert(Ryan);
        users.insert(Felix);
        users.insert(Calliope);
        users.insert(Barry);
    }
    public UserDao copyAssignment() {
        return users;
    }
}
