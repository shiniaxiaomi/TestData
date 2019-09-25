package List;

public class MyLinkList implements MyList {

    //定义一个节点类
    private class Node{
        Node before;//上一个节点
        int value;//数据
        Node next;//下一个节点
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head=null;//头节点
    private Node indexNode=null;//当前节点
    private int size=0;

    @Override
    public void add(int value) {
        if(head==null){
            Node node=new Node(value);
            head=node;//将head指向node节点
            indexNode=node;//将indexNode指向node节点
        }else{
            Node node=new Node(value);
            indexNode.next=node;//将indexNode的下一个节点指向node
            node.before=indexNode;//将node的上一个节点指向indexNode
            indexNode=node;//将当前节点修改成node
        }
        size++;
    }

    @Override
    public int remove(int index) throws Exception {
        Node node = getNode(index);
        node.before.next=node.next;//要删除节点的上一个节点的下一个指针指向删除节点的下一个node
        size--;
        return node.value;
    }

    @Override
    public void update(int index, int value) throws Exception {
        Node node = getNode(index);
        node.value=value;
    }

    @Override
    public int get(int index) throws Exception {
        Node node=getNode(index);
        return node.value;
    }

    //根据索引获取node
    public Node getNode(int index) throws Exception {
        if(index>size-1) throw new Exception("越界");

        Node node=head;
        while(index>0){
            node=node.next;
            index--;
        }
        return node;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if(head==null) return null;
        StringBuilder sb=new StringBuilder();
        Node node=head;
        while (node!=null){
            sb.append(node.value+" ");
            node=node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {

        MyLinkList myLinkList = new MyLinkList();
        //增
        for(int i=0;i<10;i++){
            myLinkList.add(i);
        }
        System.out.println(myLinkList);
        //删
        myLinkList.remove(4);
        System.out.println(myLinkList);
        //改
        myLinkList.update(2,100);
        System.out.println(myLinkList);
        //查
        myLinkList.get(6);
        System.out.println(myLinkList);
        //大小
        System.out.println(myLinkList.size());

    }

}
