package Stack;

public interface MyStack {
    public void push(int value) throws Exception;
    public int pop() throws Exception;
    public int peek() throws Exception;//获取但不删除元素
    public boolean empty();
}
