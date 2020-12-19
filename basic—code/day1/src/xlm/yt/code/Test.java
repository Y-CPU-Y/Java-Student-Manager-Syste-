package xlm.yt.code;

public class Test {
    public static void main(String[] args) {
        Student b = new Student(132,"1321","123");
        Student a = b;
        a = null;
        System.out.println("b的Id:"+b.getId());
        System.out.println("a的Id:"+a.getId());
    }
}
