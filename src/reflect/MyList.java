package reflect;

import java.util.ArrayList;



public class MyList<T> {

    Object[] arr=new Object[100];
    int index=0;

    public void add(T t){
        arr[index++]=t;
    }

    public T get(int index){
        return (T) arr[index];
    }

    public <E> E add1(E e){
        arr[index++]=e;
        return e;
    }

    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("sfsd");

        String s = myList.get(0);
        System.out.println(s);

        Integer integer = myList.add1(1);
        System.out.println(integer);

//        String s1 = myList.get(2);//报错,因为索引2存储的是Integer类型的,但是再get的时候进行了强转为String,因此会报类型转化异常

    }

}