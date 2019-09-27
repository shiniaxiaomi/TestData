package arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yingjie.Lu on 2019/9/27.
 */

//使用回溯算法解决8皇后的问题
public class BackTrack {


    int[][] arr = new int[4][4];

    int lenght = 0;


    //寻找8皇后
    //size是已经放入的皇后的个数
    public void findQueen(int size) {

        if (size == arr.length) {
            lenght++;
            for (int i = 0; i < arr.length; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println("=============");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (check(i, j)) {
                    arr[i][j] = 1;//找到可以放入皇后的位置
                    findQueen(size++);
//                    arr[i][j] = 0;//清除放入的皇后(回溯过程)
                }
            }
        }
    }


    //检查第i行,第j列是否可以防止皇后
    public boolean check(int hang, int lie) {
        //检查行
        for (int i = 0; i < arr.length; i++) {
            if (arr[hang][i] == 1) {
                return false;
            }
        }

        //检查列
        for (int i = 0; i < arr.length; i++) {
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

        //检查左斜下角
        for (int i = hang + 1, j = lie - 1; i < arr.length && j >= 0; i++, j--) {
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

        //检查右斜下角
        for (int i = hang + 1, j = lie + 1; i < arr.length && j < arr.length; i++, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        BackTrack backTrack = new BackTrack();
        backTrack.findQueen(0);
        System.out.println(backTrack.lenght);

    }

}
