package code;

import java.util.List;

// �û������ݷ��ʽӿ� UserDao
// �豸�û�����ϵͳ�е���Ŷ���û�������һ�� ArrayList �У���ϵͳ�й����û��Ĳ�����װ��һ���ӿ� UserDao ��

public interface UserDao {
    public void insert(User user);
    public User selectByEmail(String email);
    public List<User>selectAll();
}
