package Tree;

/**
 * Created by Yingjie.Lu on 2019/9/26.
 */

//数据不允许重复
public interface MyTreeSet {

    public void build(int[] arr);//构建一颗二叉搜索树

    public void add(Node node,int value);

    public Node remove(int value) throws Exception;

    public Node find(Node node,int value);

    public void update(int beforeValue,int nowValue) throws Exception;

    public boolean empty();

    public Node getFirst(Node node) throws Exception;

    public Node getLast(Node node) throws Exception;

    public Node pollFirst(Node node) throws Exception;

    public Node pollLast(Node node) throws Exception;

}
