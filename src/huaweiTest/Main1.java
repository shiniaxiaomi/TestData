package huaweiTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    //size表示换的瓶数,n表示空瓶的个数
    public void trans(int size,int n){
        if(n==1){
            System.out.println(size);
            return;
        }else if(n==2){
            System.out.println(size+1);
            return;
        }else{
            trans(size+=n/3,n/3+n%3);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Main1 main = new Main1();
        ArrayList<Integer> list = new ArrayList<>();
        int nextInt=0;

        while (scanner.hasNext()) {
            while((nextInt=scanner.nextInt())!=0){
                main.trans(0, nextInt);
            }
        }

    }
}
