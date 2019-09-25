package Stack;

/**
 * Created by Administrator on 2019/9/25.
 */
public class MyArrayStack implements MyStack {

    private int size=0;
    private int[] arr=null;
    private int index=0;//当前栈顶的指针

    //创建指定大小的堆栈
    public MyArrayStack(int size) {
        this.size = size;
        this.arr=new int[size];
    }

    @Override
    public void push(int value) throws Exception {
        if(index>size-1) throw new Exception("越界");
        arr[index++]=value;
    }

    @Override
    public int pop() throws Exception {
        if(index<0) throw new Exception("越界");
        return arr[--index];
    }

    //获取但不删除元素
    @Override
    public int peek() throws Exception {
        if(index<0) throw new Exception("越界");
        return arr[index];
    }

    @Override
    public boolean empty() {
        return index==0;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<index;i++){
            sb.append(arr[i]+" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        MyArrayStack stack=new MyArrayStack(14);
        //push
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack);
        //pop
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
