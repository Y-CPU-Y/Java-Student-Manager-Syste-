package xlm.yt.code;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminManager {
    ArrayList<Admin> admins = null;//空的ArrayList用于保存注册人员的信息

    public AdminManager() {
        admins = new ArrayList<>();
    }

    private Admin findAdmin(int account) {
        for (int i = 0; i < admins.size(); i++) {//size()函数获取数组大小
            if (account == admins.get(i).getAccount())//get(i)函数取对象数组中第i个对象元素
                return admins.get(i);
        }
        return null;
    }

    public void addAdmin(Scanner scanner) {
        int account = Admin.inputAccount(scanner);
        if (null != findAdmin(account)) {
            System.out.println("Admin with account：" + account + " is already in this system.");
            return;
        }
        String password = Admin.inputPassword(scanner);//这里必须使用scanner
        Admin admin = new Admin(account, password);
        admins.add(admin);
        System.out.println(admin.getAccount() + "added.");
    }

    public boolean queryByAccount(Scanner scanner) {
        int account = Admin.inputAccount(scanner);
        Admin a = findAdmin(account);
        String password = Admin.inputPassword(scanner);
        //用户名不存在
        if (null == a){
            System.out.println("系统中没有账号：" + account);
            return false;
        }
        //用户名存在
        if (a.getPassword().equals(password)){
            System.out.println("登入成功！");
            return true;
        }
        else{
            System.out.println("密码错误！");
            return false;
        }
    }

}