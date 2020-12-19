package xlm.yt.code;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 包含各种对学生信息的操作
 * */
public class StudentManager {
    ArrayList<Student> students = null;//ArrayList的使用，创建对象数组

    public StudentManager() {//无参构造方法
        students = new ArrayList<Student>();//新建学生管理对象，在本程序中只有在newsm对象的时候才用到了，只用了一次
    }

    private Student findStudent(int id) {
        for (int i = 0; i < students.size(); i++) {//size()函数获取数组大小
            if (id == students.get(i).getId())//get(i)函数取对象数组中第i个对象元素
                return students.get(i);
        }
        return null;
    }

    public void addStudent(Scanner scanner) {
        int id = Student.inputId(scanner);
        if (null != findStudent(id)) {
            System.out.println("student with id：" + id + " is already in this system.");
            return;
        }
        String name = Student.inputName(scanner);
        String mobile = Student.inputMobile(scanner);
        Student student = new Student(id, name, mobile);
        students.add(student);
        System.out.println(student.toString() + "added.");
    }

    public void queryById(Scanner scanner) {
        int id = Student.inputId(scanner);
        Student a = findStudent(id);
        if (null != a)
            System.out.println(a.toString());
        else
            System.out.println("没有该学号" + id);

    }

    public void modifyStudent(Scanner scanner) {
        int id = Student.inputId(scanner);
        Student a = findStudent(id);
        if (null != a) {
            a.setId(id);
            a.setName(Student.inputName(scanner));
            a.setMobile(Student.inputMobile(scanner));
        } else
            System.out.println("系统中没有学号:" + id);
    }

    public void deleteStudent(Scanner scanner) {
        int id = Student.inputId(scanner);
        Student a = findStudent(id);
        if (null != a) {
            students.remove(a);
        } else
            System.out.println("系统中没有学号:" + id);
    }

    public void showAllStudentInfo() {
        System.out.println("All Student Info:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}