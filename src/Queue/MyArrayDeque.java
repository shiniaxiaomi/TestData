package Queue;

import Stack.MyArrayStack;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/9/25.
 */

//该实现为简单起见,会浪费一个数组空间
public class MyArrayDeque implements MyDeque {

    private int size;//记录队列中的元素个数
    private int[] arr;
    private int firstIndex=-2;
    private int lastIndex=0;

    //生成指定大小的双端循环队列
    public MyArrayDeque(int length){
        this.arr=new int[length+1];
    }

    @Override
    public void add(int value) throws Exception {
        if(lastIndex>arr.length) lastIndex=0;
        if(lastIndex==firstIndex) throw new Exception("队列已满");
        arr[lastIndex++]=value;
        size++;
    }

    @Override
    public int poll() throws Exception {
        if(lastIndex<0) lastIndex=size-1;
        if(lastIndex==firstIndex) throw new Exception("队列已空");
        size--;
        return arr[--lastIndex];
    }

    @Override
    public int peek() {
        return arr[lastIndex];
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public void addLast(int value) throws Exception {
        this.add(value);
    }

    @Override
    public int getLast() throws Exception {
        return this.poll();
    }

    @Override
    public void addFirst(int value) throws Exception {
        if(firstIndex<0){
            firstIndex=this.arr.length-1;
        }

        if(firstIndex==lastIndex) throw new Exception("队列已满");

        arr[firstIndex--]=value;

    }

    @Override
    public int getFirst() {
        if(firstIndex>this.arr.length){
            firstIndex=0;
        }
        return arr[firstIndex++];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) throws Exception {
        MyArrayDeque myArrayDeque = new MyArrayDeque(10);
//        for(int i=0;i<6;i++){
//            myArrayDeque.add(i);
//        }
//        System.out.println(myArrayDeque);
//        while (!myArrayDeque.empty()){
//            int poll = myArrayDeque.poll();
//            System.out.println(poll);
//        }

        for(int i=0;i<5;i++){
            myArrayDeque.addLast(i);
        }
        for(int i=100;i<105;i++){
            myArrayDeque.addFirst(i);
        }
        System.out.println(myArrayDeque);

        for(int i=0;i<8;i++){
            int first = myArrayDeque.getFirst();
            System.out.println(first);
        }
        for(int i=0;i<3;i++){
            int last = myArrayDeque.getLast();
            System.out.println(last);
        }
    }
}
