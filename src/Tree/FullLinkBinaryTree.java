package Tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

public class FullLinkBinaryTree {

    Node head;//头节点

    private class Node{
        Node leftChildren;
        int value;
        Node rightChildren;
        public Node(int value){
            this.value=value;
        }
    }

    public FullLinkBinaryTree(int[] arr){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        head=new Node(arr[0]);
        deque.add(head);
        int i=1;
        while(!deque.isEmpty()){
            Node poll = deque.poll();

            if(i+1>arr.length){
                deque.clear();
                break;
            }
            Node leftChildren=new Node(arr[i++]);
            poll.leftChildren=leftChildren;
            deque.add(leftChildren);

            if(i+1>arr.length){
                deque.clear();
                break;
            }
            Node rightChildren=new Node(arr[i++]);
            poll.rightChildren=rightChildren;
            deque.add((rightChildren));
        }
    }
    //先序遍历
    public void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.value+" ");//访问当前节点
        preOrder(node.leftChildren);//访问左节点
        preOrder(node.rightChildren);//访问右节点
    }
    //中序遍历
    public void inOrder(Node node){
        if(node==null) return;
        inOrder(node.leftChildren);//访问左节点
        System.out.print(node.value+" ");//访问当前节点
        inOrder(node.rightChildren);//访问右节点
    }
    //后序遍历
    public void postOrder(Node node){
        if(node==null) return;
        postOrder(node.leftChildren);//访问左节点
        postOrder(node.rightChildren);//访问右节点
        System.out.print(node.value+" ");//访问当前节点
    }

    //广度优先遍历
    public void BFS(Node node){
        if(node==null) {
            System.out.println("null");
            return;
        }

        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(node);
        //如果deque不为空
        while(!deque.isEmpty()){
            Node poll = deque.poll();
            System.out.print(poll.value+" ");

            if(poll.leftChildren!=null) {
                deque.add(poll.leftChildren);//压入左节点
            }

            if(poll.rightChildren!=null){
                deque.add(poll.rightChildren);//压入右节点
            }
        }
    }


    //测试
    public static void main(String[] args) {
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
        FullLinkBinaryTree fullLinkBinaryTree = new FullLinkBinaryTree(arr);
//        fullLinkBinaryTree.preOrder(fullLinkBinaryTree.head);//前序遍历
//        System.out.println();
//        fullLinkBinaryTree.inOrder(fullLinkBinaryTree.head);//中序遍历
//        System.out.println();
//        fullLinkBinaryTree.postOrder(fullLinkBinaryTree.head);//后序遍历

        fullLinkBinaryTree.BFS(fullLinkBinaryTree.head);//广度优先遍历
    }
}
