package Heap;

import java.util.Arrays;


//数组实现最大堆
public class MyArrayMaxHeap implements MyHeap {

    int[] arr;//数据
    int size;//个数

    public MyArrayMaxHeap(int size){
        this.arr=new int[size];
    }

    //交换数组中两个index中的值
    public void swap(int index1,int index2){
        int buff=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=buff;
    }

    //给定一个index,将数组中的index所在的值,使用shiftUp将其往上调整到合适的位置
    public void shiftUp(int index){
        //如果当前值比父节点大,则往上调整
        while(arr[index]>arr[index/2]){
            swap(index,index/2);
            index=index/2;
        }
    }

    //给定一个index,将数组中的index所在的值,使用shiftDown将其往下调整到合适的位置
    public void shiftDown(int index){
        while(true){
            if(index*2+1>arr.length-1){
                //无左右孩子
                break;
            }else if(index*2+2>arr.length-1){
                //有左孩子
                if(arr[index]<arr[index*2+1]){
                    swap(index,index*2+1);
                }
                index=index*2+1;
            }else{
                //有左右孩子
                int max=Math.max(arr[index*2+1],arr[index*2+2]);
                //如果比两个孩子节点都大,则退出
                if(arr[index]>max){
                    break;
                }

                //哪个大和哪个交换
                if(arr[index*2+1]>arr[index*2+2]){
                    swap(index,index*2+1);
                    index=index*2+1;
                }else{
                    swap(index,index*2+2);
                    index=index*2+2;
                }
            }
        }
    }

    //添加一个元素
    @Override
    public void add(int value) throws Exception {
        if(size>arr.length-1){
            throw new Exception("已满");
        }
        arr[size]=value;//将值放在数组的最后一位
        if(size!=0){
            shiftUp(size);//向上调整放入的值的位置
        }
        size++;
    }

    //通过数据构建最大堆
    @Override
    public void build(int[] arr) throws Exception {
        if(this.arr.length<arr.length) throw new Exception("超出范围");
        for(int i=0;i<arr.length;i++){
            add(arr[i]);
        }
    }

    //获取并删除最大值
    @Override
    public int poll() {
        int buff=arr[0];
        arr[0]=arr[size-1];//将最后一位数据放在最顶端
        //执行shiftDown操作,将顶部数据调整到一个合适的位置
        shiftDown(0);
        size--;
        return buff;
    }
    //获取但不删除最大值
    @Override
    public int peek() {
        return arr[0];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++){
            sb.append(arr[i]+" ");
        }
        return sb.toString();
    }

    //测试
    public static void main(String[] args) throws Exception {
        int[] arr=new int[]{5,48,154,687,1,3,87,151,94};
        MyArrayMaxHeap maxHeap = new MyArrayMaxHeap(10);
        //根据数组构建一个最大堆
        maxHeap.build(arr);
        System.out.println(maxHeap);
        //添加元素
        maxHeap.add(799);
        System.out.println(maxHeap);
        //获取并删除最大值
        int poll = maxHeap.poll();
        System.out.println(poll);
        System.out.println(maxHeap);
        //获取但不删除最大值
        int peek = maxHeap.peek();
        System.out.println(peek);
        System.out.println(maxHeap);
    }
}
