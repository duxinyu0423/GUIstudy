package code;

import java.util.List;

// 用户的数据访问接口 UserDao
// 设备用户管理系统中的苏哦有用户保存在一个 ArrayList 中，将系统中关于用户的操作封装在一个接口 UserDao 中

public interface UserDao {
    public void insert(User user);
    public User selectByEmail(String email);
    public List<User>selectAll();
}
