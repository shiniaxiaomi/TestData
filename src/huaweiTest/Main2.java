package huaweiTest;

import java.util.Scanner;
import java.util.TreeSet;

public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        TreeSet<Integer> treeSet=new TreeSet<>();
        for(int i=0;i<num;i++){
            int nextInt = scanner.nextInt();
            treeSet.add(nextInt);
        }

        while(!treeSet.isEmpty()){
            System.out.print(treeSet.pollFirst()+"\n");
        }

    }

}
