package JDKDemo;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/9/28.
 */
public class CopyArrayDemo {

    public static void main(String[] args) {
        int[] arr=new int[]{1,45,7,5248,15,488,56,49,8465,67,1,2,13,5986,87,6,547,89,7};

        int[] buff1= Arrays.copyOf(arr,arr.length);//复制数组
        Arrays.sort(buff1);//排序复制的数组

        System.out.println(Arrays.toString(arr));//打印原数组
        System.out.println(Arrays.toString(buff1));//打印复制后排好序的数组
    }
}
