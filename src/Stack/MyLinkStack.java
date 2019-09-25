package Stack;

public class MyLinkStack implements MyStack {
    private Node head=null;//记录一下头节点,方便toString()
    private int size=0;
    private Node indexNode=null;//当前栈顶的指针

    private class Node{
        Node before;
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    @Override
    public void push(int value) throws Exception {
        if(indexNode==null){
            indexNode=new Node(value);
            head=indexNode;
        }else{
            Node node=new Node(value);
            indexNode.next=node;
            node.before=indexNode;
            indexNode=node;
        }
        size++;
    }

    @Override
    public int pop() throws Exception {
        if(size<0) throw new Exception("越界");
        //如果是头节点
        if(size==1) {
            int value=indexNode.value;
            indexNode=null;//删除节点
            head=null;//头节点置空
            size--;
            return value;
        }

        int value=indexNode.value;
        indexNode.before.next=null;//删除当前节点
        indexNode=indexNode.before;
        size--;
        return value;
    }

    @Override
    public int peek() throws Exception {
        if(size<0) throw new Exception("越界");
        return indexNode.value;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public String toString() {
        if(head==null) return null;
        StringBuilder sb=new StringBuilder();
        Node node=head;
        while(node!=null){
            sb.append(node.value+" ");
            node=node.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        MyLinkStack stack=new MyLinkStack();
        //push
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack);
        //pop
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
