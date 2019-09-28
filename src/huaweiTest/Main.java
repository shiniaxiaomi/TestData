package huaweiTest;

import java.util.Scanner;

/**
 * Created by Yingjie.Lu on 2019/9/28.
 */

//计算数独
public class Main {

    public void print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public boolean tryNum(int[][] arr,int i,int j){
        if(j>=arr.length){
            i++;
            j=0;
        }

        if(i>=arr.length){
            print(arr);
            return true;
        }

        if(arr[i][j]==0){
            for(int k=1;k<=9;k++){
                boolean panduan = panduan(arr, i, j, k);
                if(panduan){
                    arr[i][j]=k;
                    boolean b = tryNum(arr, i, j + 1);
                    if(b){
                        return true;
                    }
                    arr[i][j]=0;
                }
            }
        }else{
            boolean b = tryNum(arr, i, j + 1);
            if(b){
                return true;
            }
        }

        return false;
    }

    //给定一个坐标,判断该坐标能够填写哪些数字
    public boolean panduan(int[][] arr,int hang,int lie,int num){

        //lie
        for(int i=0;i<arr.length;i++){
            if(arr[i][lie]==num){
                return false;
            }
        }

        //hang
        for(int i=0;i<arr.length;i++){
            if(arr[hang][i]==num){
                return false;
            }
        }

        //9宫格
        //0-2,3-5,6-8
        int startHang=0,startLie=0;
        int endHang=0,endLie=0;
        if(hang>=0 && hang<=2){
            startHang=0;
            endHang=2;
        }else if(hang>=3 && hang<=5){
            startHang=3;
            endHang=5;
        }else if(hang>=6 && hang<=8){
            startHang=6;
            endHang=8;
        }
        if(lie>=0 && lie<=2){
            startLie=0;
            endLie=2;
        }else if(lie>=3 && lie<=5){
            startLie=3;
            endLie=5;
        }else if(lie>=6 && lie<=8){
            startLie=6;
            endLie=8;
        }
        for(int i=startHang;i<=endHang;i++){
            for(int j=startLie;j<=endLie;j++){
                if(arr[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Main main = new Main();

        int[][] arr=new int[9][9];
        while (scanner.hasNext()){

            //获取数独
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    arr[i][j]=scanner.nextInt();
                }
            }

            main.tryNum(arr,0,0);

        }
    }
}
