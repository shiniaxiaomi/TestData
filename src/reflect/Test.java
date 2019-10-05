package reflect;

import java.lang.reflect.Method;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        Method hello = aClass.getMethod("hello", String.class);
        hello.invoke(student, "nihao");
    }
}
