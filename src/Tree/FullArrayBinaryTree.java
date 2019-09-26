package Tree;

/**
 * Created by Yingjie.Lu on 2019/9/26.
 */

//完全二叉树的数组实现
public class FullArrayBinaryTree {

    private int[] arr=null;//保存数据

    public FullArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //根据当前节点的index获取其左孩子的index
    public int getLeftChildren(int index) throws Exception {
        if(2*index+1>arr.length-1) return -1;//无左孩子
        return 2*index+1;
    }
    //根据当前节点的index获取其右孩子的index
    public int getRightChildren(int index) throws Exception {
        if(2*index+2>arr.length-1)  return -1;//无右孩子
        return 2*index+2;
    }

    //前序遍历
    public void preOrder(int index) throws Exception {
        System.out.print(arr[index]+" ");//访问当前节点

        int leftChildrenIndex = getLeftChildren(index);
        if(leftChildrenIndex!=-1){
            preOrder(leftChildrenIndex);//访问左孩子
        }

        int rightChildrenIndex = getRightChildren(index);
        if (rightChildrenIndex!=-1){
            preOrder(rightChildrenIndex);//访问右孩子
        }
    }

    //中序遍历
    public void inOrder(int index) throws Exception {
        int leftChildrenIndex = getLeftChildren(index);
        if(leftChildrenIndex!=-1){
            inOrder(leftChildrenIndex);//访问左孩子
        }

        System.out.print(arr[index]+" ");//访问当前节点

        int rightChildrenIndex = getRightChildren(index);
        if (rightChildrenIndex!=-1){
            inOrder(rightChildrenIndex);//访问右孩子
        }
    }

    //后序遍历
    public void postOrder(int index) throws Exception {
        int leftChildrenIndex = getLeftChildren(index);
        if(leftChildrenIndex!=-1){
            postOrder(leftChildrenIndex);//访问左孩子
        }

        int rightChildrenIndex = getRightChildren(index);
        if (rightChildrenIndex!=-1){
            postOrder(rightChildrenIndex);//访问右孩子
        }

        System.out.print(arr[index]+" ");//访问当前节点
    }


    public static void main(String[] args) throws Exception {
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
        FullArrayBinaryTree fullArrayBinaryTree = new FullArrayBinaryTree(arr);
        fullArrayBinaryTree.preOrder(0);//前序遍历
        fullArrayBinaryTree.inOrder(0);//中序遍历
        fullArrayBinaryTree.postOrder(0);//后序遍历
    }


}
