package xlm.yt.code;

import java.util.Scanner;

/*
 * 包含各种学生的信息
 * */
public class Student {//数据对象  java entity bean
    private int id;
    private String name;
    private String mobile;
    private int java_score;
    //可以再加入一些新的信息：邮政地址，城市，小区，街道，微信，qq，等等
    //Alt+Insert快捷插入getter and setter
    //Ctrl+Alt+L  可以快速进行代码格式化（即完美空格和完美空行，美化代码
    public Student(int id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override//覆盖重写
    public String toString() {
        return "[" + id + "," + name + "," + mobile + "]";
    }

    public static int inputId(Scanner scanner) {
        System.out.println("请输入学生的id：");

        for (; ; ) {
            try {
                String ids = scanner.next();
                int id = Integer.parseInt(ids);
                return id;
            } catch (NumberFormatException nfe) {//异常处理,一异常是一个事件
                System.out.println("输入不能转化成INT,请再输入一次");
            }
        }
    }

    public static String inputName(Scanner scanner) {
        System.out.println("请输入学生的name：");
        String name = scanner.next();
        return name;
    }

    public static String inputMobile(Scanner scanner) {
        System.out.println("请输入学生的mobile：");
        String mobile = scanner.next();
        return mobile;
    }
}