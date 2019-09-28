package huaweiTest;

import java.util.Scanner;


public class Main3 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int nextInt = scanner.nextInt();
            int[] arr = new int[nextInt];

            for (int i = 0; i < nextInt; i++) {
                arr[i] = 1;
            }

            int size = nextInt;

            int flag = 0;
            int index = 0;
            while (size > 1) {

                if (index == arr.length) {
                    index = 0;
                }

                if (arr[index] == 1) {//未删除
                    if (flag == 2) {
                        arr[index] = 0;//删除
                        size--;
                        flag = 0;//清零
                    } else {
                        flag++;
                    }
                }

                index++;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    System.out.println(i);
                    break;
                }
            }

        }


    }
}
