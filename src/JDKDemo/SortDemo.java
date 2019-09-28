package JDKDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2019/9/28.
 */
public class SortDemo {

    Integer[] arr=new Integer[]{1,45,7,5248,15,488,56,49,8465,67,1,2,13,5986,87,6,547,89,7};

    //普通数组排序
    public void sort1(){
        Integer[] buff1=Arrays.copyOf(arr,arr.length);//复制数组
        Arrays.sort(buff1);//升序
        System.out.println(Arrays.toString(buff1));
    }

    //普通数组指定范围排序
    public void sort2(){
        Integer[] buff2=Arrays.copyOf(arr,arr.length);//复制数组
        Arrays.sort(buff2,2,8);
        System.out.println(Arrays.toString(buff2));
    }

    //自定义排序规则
    public void sort3(){
        Integer[] buff3=Arrays.copyOf(arr,arr.length);//复制数组
        //注意,buff3的数组类型必须和Comparator中的类型一致,不然会报错(如buff3为int,而Comparator为Integer就会报错)
        Arrays.sort(buff3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(buff3));
    }

    //定义一个Student类
    class Student{
        int age;
        String name;
        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return "[age:"+age+",name:"+name+"]";
        }
    }
    //自定义对象排序
    public void sort4(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(5,"555555"));
        students.add(new Student(9,"999999"));
        students.add(new Student(1,"111111"));
        students.add(new Student(7,"777777"));

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age>o2.age){
                    return -1;
                }else if(o1.age<o2.age){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }
    }

    public static void main(String[] args) {
        SortDemo sortDemo = new SortDemo();

        sortDemo.sort1();//普通排序
        sortDemo.sort2();//指定范围排序
        sortDemo.sort3();//自定义排序规则
        sortDemo.sort4();//自定义排序对象
    }
}
