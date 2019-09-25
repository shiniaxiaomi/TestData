package Queue;

/**
 * Created by Administrator on 2019/9/25.
 */
public interface MyQueue {
    //正常队列操作
    public void add(int value) throws Exception;
    public int poll() throws Exception;
    public int peek();
    public boolean empty();
}
