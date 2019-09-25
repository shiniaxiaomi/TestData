package List;

import java.util.Arrays;

public class MyArrayList implements MyList {

    private int size=10;//定义数组的初始大小
    private int index=0;//数组索引
    private int[] arr=new int[size];//数组

    @Override
    public void add(int value) {
        if(index>=size){//如果超过数组长度,则扩容
            int[] newArr=new int[size*=2];
            System.arraycopy(arr,0,newArr,0,10);
            arr=newArr;
        }
        arr[index++]=value;
    }

    @Override
    public int remove(int index) throws Exception {
        if(index>this.index-1) throw new Exception("数组越界");//防止数组越界
        int buff=arr[index];
        for(int i=index;i<this.index-1;i++){
            arr[i]=arr[i+1];
        }
        this.index--;
        return buff;
    }

    @Override
    public void update(int index, int value) throws Exception {
        if(index>this.index-1) throw new Exception("数组越界");
        arr[index]=value;
    }

    @Override
    public int get(int index) throws Exception {
        if(index>this.index-1) throw new Exception("数组越界");
        return arr[index];
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }

    public static void main(String[] args) throws Exception {

        MyArrayList myArrayList = new MyArrayList();

        //增
        for(int i=0;i<8;i++){
            myArrayList.add(i);
        }
        System.out.println("增:"+myArrayList);
        //删
        int obj=myArrayList.remove(2);
        System.out.println("删:"+myArrayList);
        //改
        myArrayList.update(4,100);
        System.out.println("改:"+myArrayList);
        //查找
        int i = myArrayList.get(6);
        System.out.println(i);
        //大小
        System.out.println(myArrayList.size());
    }
}
