package reflect;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        Student student = Student.class.newInstance();
        student.setName("jack");
        student.hello("nihao");
    }
}
