package arithmetic;

import java.util.*;

/**
 * Created by Yingjie.Lu on 2019/9/27.
 */

//使用回溯算法解决八皇后的问题
public class BackTrack {
    int size=8;
    int[][] arr = new int[size][size];
    int lenght = 0;//符合条件的个数

    //给定一个行,去寻找这一行能不能放一个皇后
    public void findQueen(int hang,int size) {
        //已经放满八个皇后
        if(size==arr.length){
            lenght++;
            //打印
            for(int i=0;i<arr.length;i++){
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println("========================");
            return;
        }

        //从第hang行开始摆放八皇后,因为之前的行已经摆放过了
        for(int i=hang;i<arr.length;i++){
            //检查每一列能够摆放
            for(int j=0;j<arr.length;j++){
                boolean check = check(i, j);
                if(check){
                    arr[i][j]=1;//放入八皇后
                    findQueen(i+1,size+1);//继续摆放下一行,摆放的八皇后个数加一
                    arr[i][j]=0;//回溯后将摆放的八皇后拿出,继续下一列的尝试摆放
                }
            }
        }
    }
    //给定一个坐标,检查该坐标的列和斜对角有没有冲突
    //只需要检查已经放过皇后的列和斜对角(因为行是由外部控制的)
    public boolean check(int hang, int lie) {
        //检查列
        for (int i = 0; i < hang; i++) {
            if (arr[i][lie] == 1) {
                return false;
            }
        }
        //检查左斜上角
        for (int i = hang - 1, j = lie - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        //检查右斜上角
        for (int i = hang - 1, j = lie + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    //测试
    public static void main(String[] args) {
        BackTrack backTrack = new BackTrack();
        backTrack.findQueen(0,0);
        System.out.println(backTrack.lenght);

    }
}
