package Queue;

/**
 * Created by Administrator on 2019/9/25.
 */
public interface MyDeque extends MyQueue {
    //尾部的添加和获取操作
    public void addLast(int value) throws Exception;
    public int getLast() throws Exception;

    //头部的添加和获取操作
    public void addFirst(int value) throws Exception;
    public int getFirst() throws Exception;
}
