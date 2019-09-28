package JDKDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2019/9/28.
 */
public class BinarySearchDemo {

    public static void main(String[] args) {

        int[] arr=new int[]{1,45,7,5248,15,488,56,49,8465,67,1,2,13,5986,87,6,547,89,7};

        Arrays.sort(arr);//先进行排序
        System.out.println(Arrays.toString(arr));

        int index = Arrays.binarySearch(arr, 15);//如果找到,则返回排好序的数组中元素坐在的索引,否则返回-1
        System.out.println(index);
        System.out.println(arr[index]);

    }
}
