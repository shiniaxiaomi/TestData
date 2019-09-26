package Heap;

/**
 * Created by Administrator on 2019/9/26.
 */
public interface MyHeap {

    public void add(int value) throws Exception;
    public void build(int[] arr) throws Exception;
    public int poll();
    public int peek();
    public boolean isEmpty();

}
