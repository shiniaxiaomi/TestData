package Tree;

import java.util.ArrayDeque;

//定义节点类,提供MyTreeSet接口使用
class Node{
    Node leftChildren;
    int value;
    Node rightChildren;
    public Node(int value){
        this.value=value;
    }
}

//实现了一个二叉搜索树
public class MyBinarySearchTree implements MyTreeSet {

    Node root;//根节点

    //使用数组生成一个二叉搜索树
    @Override
    public void build(int[] arr) {
        for(int i=0;i<arr.length;i++){
            add(root,arr[i]);
        }
    }

    //添加一个节点
    @Override
    public void add(Node node,int value) {
        if(root==null){
            root=new Node(value);
            return;
        }

        //不考虑相等的情况,相当于一个set集合
        if(value<node.value){//小于放入左子树
            if(node.leftChildren==null){
                node.leftChildren=new Node(value);
                return;
            }

            add(node.leftChildren,value);
        }else if(value>node.value){//大于放入右子树
            if(node.rightChildren==null){
                node.rightChildren=new Node(value);
                return;
            }

            add(node.rightChildren,value);
        }
    }

    //删除一个节点
    @Override
    public Node remove(int value) throws Exception {

        if(root==null){
            throw new Exception("null");
        }

        Node node =root;
        Node parentNode=null;
        while(node!=null){
            if(value<node.value){
                parentNode=node;
                node=node.leftChildren;
            }else if(value>node.value){
                parentNode=node;
                node=node.rightChildren;
            }else{
                //找到要删除的节点了
                if(parentNode.value>node.value){//要删除的节点是父节点的左子树
                    Node node1=pollLast(node);
                    if(node1==null){
                        //没有右节点
                        parentNode.leftChildren=node.leftChildren;
                    }else{
                        //有右节点
                        parentNode.leftChildren=node1;
                        node1.leftChildren=node.leftChildren;
                        node1.rightChildren=node.rightChildren;
                    }
                }else{//要删除的节点是父节点的右子树
                    if(node.leftChildren==null){
                        parentNode.rightChildren=node.rightChildren;
                    }else{
                        Node node1 = pollLast(node.leftChildren);
                        if(node1==null){
                            //没有左节点
                            parentNode.rightChildren=node.leftChildren;
                            node.leftChildren=node.rightChildren;
                        }else{
                            //有右节点
                            parentNode.rightChildren=node1;
                            node1.leftChildren=node.leftChildren;
                            node1.rightChildren=node.rightChildren;
                        }
                    }
                }
                return node;
            }
        }

        if(node==null){
            throw new Exception("没有找到该值");
        }

        return null;
    }


    //查找节点
    @Override
    public Node find(Node node,int value) {
        if(node==null){
            return null;
        }

        if(value<node.value){
            return find(node.leftChildren,value);
        }else if(value>node.value){
            return find(node.rightChildren,value);
        }else{//相等
            return node;
        }
    }

    //更新节点
    @Override
    public void update(int beforeValue, int nowValue) throws Exception {
        Node node = find(root, beforeValue);
        if(node!=null){
            node.value=nowValue;
        }else {
            throw new Exception("不存在该数值");
        }
    }

    @Override
    public boolean empty() {
        return root==null;
    }

    //获取但不删除最小节点
    @Override
    public Node getFirst(Node node) throws Exception {
        if(root==null){
            throw new Exception("null");
        }

        while(node.leftChildren!=null){
            node=node.leftChildren;
        }
        return node;
    }

    //获取但不删除最大节点
    @Override
    public Node getLast(Node node) throws Exception {
        if(root==null){
            throw new Exception("null");
        }

        while(node.rightChildren!=null){
            node=node.rightChildren;
        }
        return node;
    }

    //获取且删除最小节点
    @Override
    public Node pollFirst(Node node) throws Exception {
        if(node==null){
            throw new Exception("null");
        }

        Node parentNode=null;
        while(node.leftChildren!=null){
            parentNode=node;//备份父节点
            node=node.leftChildren;
        }

        //如果原来node节点就没有左节点
        if(parentNode==null){
            return null;//除了本身,就没有最小值了
        }else{//要删除的节点有右节点
            //删除node节点,并将父节点的左子树指向node节点的右子树(node已经没有左子树了)
            parentNode.leftChildren=node.rightChildren;
            return node;
        }

    }

    //获取且删除最大节点
    @Override
    public Node pollLast(Node node) throws Exception {

        if(node==null){
            throw new Exception("null");
        }

        Node parentNode=null;
        while(node.rightChildren!=null){
            parentNode=node;//备份父节点
            node=node.rightChildren;
        }

        //如果原来node节点就没有右节点
        if(parentNode==null){
            return null;//除了本身,就没有最大值了
        }else{//要删除的节点有左节点
            //删除node节点,并将父节点的右子树指向node节点的左子树(node已经没有右子树了)
            parentNode.rightChildren=node.leftChildren;
            return node;
        }
    }

    @Override
    public String toString() {

        if(root==null) return "null";

        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        
        StringBuilder sb=new StringBuilder();
        while(!arrayDeque.isEmpty()){
            Node poll = arrayDeque.poll();
            sb.append(poll.value+" ");

            if(poll.leftChildren!=null){
                arrayDeque.add(poll.leftChildren);
            }

            if(poll.rightChildren!=null){
                arrayDeque.add(poll.rightChildren);
            }

        }

        return sb.toString();
    }

    //测试
    public static void main(String[] args) throws Exception {
        int[] arr={67,4,743,327,82,2,79,23,7};
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        //构建一个二叉搜索树
        myBinarySearchTree.build(arr);
        System.out.println(myBinarySearchTree);

        //查找
        Node node = myBinarySearchTree.find(myBinarySearchTree.root, 82);
        System.out.println(node.value);


        //弹出最大值
        Node node1 = myBinarySearchTree.pollLast(myBinarySearchTree.root);
        System.out.println(node1.value);
        System.out.println(myBinarySearchTree);

        //弹出最小值
        Node node2 = myBinarySearchTree.pollFirst(myBinarySearchTree.root);
        System.out.println(node2.value);
        System.out.println(myBinarySearchTree);

        //获取最大值
        Node node3 = myBinarySearchTree.getLast(myBinarySearchTree.root);
        System.out.println(node3.value);
        System.out.println(myBinarySearchTree);

        //获取最小值
        Node node4 = myBinarySearchTree.getFirst(myBinarySearchTree.root);
        System.out.println(node4.value);
        System.out.println(myBinarySearchTree);

        //删除节点
        Node remove = myBinarySearchTree.remove(23);
        System.out.println(remove.value);
        System.out.println(myBinarySearchTree);

    }
}
