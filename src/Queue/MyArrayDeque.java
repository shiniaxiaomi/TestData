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
    private int firstIndex=-1;
    private int lastIndex=0;

    //生成指定大小的双端循环队列
    public MyArrayDeque(int length){
        this.arr=new int[length+1];
    }

    @Override
    public void add(int value) throws Exception {
        if(lastIndex==arr.length) lastIndex=0;//指向最后一个元素时,则让其指向0
        if(lastIndex==firstIndex) throw new Exception("队列已满");//如果头指针和尾指针相等,则不允许再放元素(其实中间还空着一个位置,因为lastIndex永远都指向下一个要放入的节点)
        arr[lastIndex++]=value;
        size++;
    }

    @Override
    public int poll() throws Exception {
        if(lastIndex==-1) lastIndex=arr.length-1;
        if(Math.abs(lastIndex-firstIndex)==1) throw new Exception("队列已空");//如果相差一个元素,则不允许再弹出元素
        size--;
        return arr[--lastIndex];
    }

    @Override
    public int peek() {
        return arr[lastIndex-1];
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
        if(firstIndex<=-1){
            firstIndex=this.arr.length-1;//如果到顶,则回到尾部
        }
        if(lastIndex==firstIndex) throw new Exception("队列已满");
        arr[firstIndex--]=value;
    }

    @Override
    public int getFirst() {
        if(firstIndex==this.arr.length-1){
            firstIndex=-1;//因为这里的firstIndex是先++,再取值,所以赋值为-1
        }
        return arr[++firstIndex];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) throws Exception {
        MyArrayDeque myArrayDeque = new MyArrayDeque(10);
        for(int i=0;i<6;i++){
            myArrayDeque.add(i);
        }
        System.out.println(myArrayDeque);
        System.out.println(myArrayDeque.peek());
        while (!myArrayDeque.empty()){
            int poll = myArrayDeque.poll();
            System.out.println(poll);
        }

        for(int i=0;i<10;i++){
            myArrayDeque.addLast(i);
        }
        System.out.println(myArrayDeque);

        for(int i=0;i<8;i++){
            int first = myArrayDeque.getFirst();
            System.out.println(first);
        }
        for(int i=0;i<2;i++){
            int last = myArrayDeque.getLast();
            System.out.println(last);
        }
    }
}
