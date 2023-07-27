package code;

import java.util.ArrayList;
import java.util.List;

// ����һ�� UserDao �ӿڵ�ʵ����

public class UserDaoImpForList implements UserDao{
    private List<User>users;

    public UserDaoImpForList() {
        users = new ArrayList<User>();
    }

    @Override
    public void insert(User user) {
        users.add(user);
    }

    @Override
    public User selectByEmail(String email) {
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> selectAll() {
        return users;
    }
}
