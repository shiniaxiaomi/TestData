package Tree;

import java.util.ArrayDeque;

/**
 * Created by Yingjie.Lu on 2019/9/26.
 */
class Node{
    Node leftChildren;
    int value;
    Node rightChildren;
    public Node(int value){
        this.value=value;
    }
}

public class MyBinarySearchTree implements MyTreeSet {

    Node root;//根节点
    
    @Override
    public void build(int[] arr) {


        for(int i=0;i<arr.length;i++){
            add(root,arr[i]);
        }
    }

    @Override
    public void add(Node node,int value) {
        if(root==null){
            root=new Node(value);
            return;
        }

        //放入左子树
        if(value<node.value){
            if(node.leftChildren==null){
                node.leftChildren=new Node(value);
                return;
            }

            add(node.leftChildren,value);
        }else{
            if(node.rightChildren==null){
                node.rightChildren=new Node(value);
                return;
            }

            add(node.rightChildren,value);
        }

    }


    @Override
    public void remove(int value) {

    }

    @Override
    public void find(int value) {

    }

    @Override
    public void update(int beforeValue, int nowValue) {

    }

    @Override
    public void empty() {

    }

    @Override
    public void getFirst() {

    }

    @Override
    public void getLast() {

    }

    @Override
    public void pollFirst() {

    }

    @Override
    public void pollLast() {

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

    public static void main(String[] args) {
        int[] arr={1,4,743,327,82,2,79,23,7};
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        myBinarySearchTree.build(arr);

        
        System.out.println(myBinarySearchTree);



    }
}
