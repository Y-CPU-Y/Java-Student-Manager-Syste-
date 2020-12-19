package xlm.yt.code;

import java.util.Scanner;

public class main {

    static String[] menu_admin = {
            "------------------------",
            "-------登入界面----------",
            "0.登入",
            "1.注册",
            "2.退出系统",
            "-------------------------"
    };


    static String[] menu_sys = {
            "------------------------",
            "---学生通讯信息管理系统---",
            "0.退出登入",
            "1.增加学生信息",
            "2.按学号查询学生信息",
            "3.按学号修改学生信息",
            "4.按学号删除学生信息",
            "5.显示所有的学生信息",
            "请输入0-5：执行相应的操作",
            "-----------------------"
    };

    public static void showMenuadmin() {
        for (int i = 0; i < menu_admin.length; i++)
            System.out.println(menu_admin[i]);
    }

    public static void showMenusys() {
        for (int i = 0; i < menu_sys.length; i++)
            System.out.println(menu_sys[i]);
    }

    /*
     *@parm args
     * */
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();//学生管理
        AdminManager am = new AdminManager();//登入管理
        boolean quit = false;
        boolean enter = false;
        int task1 = 0;
        Scanner scanner = new Scanner(System.in);//Scanner的使用
        for (; ; ) {
            if (false == enter) {
                showMenuadmin();
                String input1 = scanner.next();
                task1 = Integer.parseInt(input1);//Integer转化成int,Integer对应是int类型的包装类，就是把int类型包装成Object对象。
            }
            switch (task1) {
                case 0:
                    if (true != enter)
                        enter = am.queryByAccount(scanner);
                    if (enter) {
                        showMenusys();
                        String input = scanner.next();
                        int task = Integer.parseInt(input);
                        switch (task) {
                            case 0:
                                enter = false;
                                System.out.println("登入退出！");
                                break;
                            case 1:
                                sm.addStudent(scanner);
                                break;
                            case 2:
                                sm.queryById(scanner);
                                break;
                            case 3:
                                sm.modifyStudent(scanner);
                                break;
                            case 4:
                                sm.deleteStudent(scanner);
                                break;
                            case 5:
                                sm.showAllStudentInfo();
                        }
                    }
                    break;
                case 1:
                    am.addAdmin(scanner);
                    break;
                case 2:
                    System.out.println("系统退出！");
                    quit = true;
            }
            if (true == quit)
                break;
        }
    }
}