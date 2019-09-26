package Tree;

/**
 * Created by Yingjie.Lu on 2019/9/26.
 */

//不允许重复
public interface MyTreeSet {

    public void build(int[] arr);//构建一颗二叉搜索树

    public void add(Node node,int value);

    public void remove(int value);

    public void find(int value);

    public void update(int beforeValue,int nowValue);

    public void empty();

    public void getFirst();

    public void getLast();

    public void pollFirst();

    public void pollLast();

}
