package Queue;


public class MyLinkDeque implements MyDeque{

    private Node head;//记录头节点
    private Node last;//记录尾节点
    private int size=0;//记录当前节点个数

    private class Node{
        Node before;//指向上一个节点
        int value;//保存的数据
        Node next;//指向下一个节点
        public Node(int value){
            this.value=value;
        }
    }

    //默认添加在尾部
    @Override
    public void add(int value) {
        if(last==null){
            Node node = new Node(value);
            last=node;
            if(head==null){
                head=node;
            }
        }else{
            Node node=new Node(value);
            last.next=node;
            node.before=last;
            last=node;
        }
        size++;
    }

    //默认从头部弹出数据
    @Override
    public int poll() throws Exception {
        if(size==0) throw new Exception("empty");
        Node node=last;//保存要删除的节点
        last.before.next=null;//删除该节点
        last=last.before;
        size--;
        return node.value;
    }

    @Override
    public int peek() {
        return last.value;
    }

    @Override
    public boolean empty() {
        return size==0;
    }
    //将数据添加到尾部
    @Override
    public void addLast(int value) {
        this.add(value);
    }

    @Override
    public int getLast() throws Exception {
        return this.poll();
    }

    //将数据添加到头部
    @Override
    public void addFirst(int value) {
        if(head==null){
            Node node=new Node(value);
            head=node;
            if(last==null){
                last=node;
            }
        }else{
            Node node=new Node(value);
            head.before=node;
            node.next=head;
            head=node;
        }
        size++;
    }

    //从头部获取数据
    @Override
    public int getFirst() throws Exception {
        if(size==0) throw new Exception("empty");
        Node node=head;//保存要删除的节点
        head.next.before=null;//删除节点
        head=head.next;
        size--;
        return node.value;
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
        MyLinkDeque myLinkDeque = new MyLinkDeque();
        //添加
        for(int i=0;i<10;i++){
            myLinkDeque.add(i);
        }
        System.out.println(myLinkDeque);
        //弹出
        for(int i=0;i<3;i++){
            int poll = myLinkDeque.poll();
            System.out.println(poll);
        }
        System.out.println(myLinkDeque);

        //添加头部数据
        for(int i=0;i<5;i++){
            myLinkDeque.addFirst(i);
        }
        //添加尾部数据
        for(int i=50;i<55;i++){
            myLinkDeque.addLast(i);
        }
        System.out.println(myLinkDeque);

        //获取头部数据
        for(int i=0;i<3;i++){
            int first = myLinkDeque.getFirst();
            System.out.println(first);
        }
        //获取尾部数据
        for(int i=0;i<3;i++){
            int last = myLinkDeque.getLast();
            System.out.println(last);
        }
        System.out.println(myLinkDeque);

    }
}
