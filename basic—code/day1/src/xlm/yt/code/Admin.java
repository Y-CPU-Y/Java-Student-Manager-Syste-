package xlm.yt.code;

import java.util.Scanner;

public class Admin {
    private int account;
    private String password;

    public Admin(int account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int inputAccount(Scanner scanner) {
        System.out.println("请输入账号：");
        for (; ; ) {
            try {
                String accounts = scanner.next();
                int account = Integer.parseInt(accounts);
                return account;
            } catch (NumberFormatException nfe) {//异常处理,一异常是一个事件
                System.out.println("输入不能转化成INT,请再输入一次");
            }
        }
    }
    public static String inputPassword(Scanner scanner) {
        System.out.println("请输入密码：");
        String password = scanner.next();
        return password;
    }

}