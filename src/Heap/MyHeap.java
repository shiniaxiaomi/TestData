package Heap;

/**
 * Created by Administrator on 2019/9/26.
 */
public interface MyHeap {
    public void add(int value) throws Exception;//添加元素
    public void build(int[] arr) throws Exception;//通过数组构建最大堆
    public int poll();//获取并删除最大值
    public int peek();//获取但不删除最大值
    public boolean isEmpty();//判空
}
