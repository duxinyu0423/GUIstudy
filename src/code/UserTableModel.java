package code;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {
    private List<User> users;

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return users.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { // ���� rowIndex �У�columnIndex �еı������
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 +" ";
            case 1:
                return user.getEmail();
            case 2:
                return user.getName();
            case 3:
                return user.getSex();
            case 4:
                return user.getHobbies();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) { //����ָ���е������ַ���
        switch (column) {
            case 0:
                return "IDX";
            case 1:
                return "email";
            case 2:
                return "name";
            case 3:
                return "sex";
            case 4:
                return "hobby";
        }
        return null;
    }
}
