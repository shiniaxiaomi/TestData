package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("reflect.Student");//指定对象所在的位置
        Student student = (Student)aClass.newInstance();
        student.setName("jack");
        student.hello("nihao");


        //获取所有公共字段
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }
        //获取所有私有字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.toString());
        }

        //获取所有公共方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        //获取所有私有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.toString());
        }
    }
}
