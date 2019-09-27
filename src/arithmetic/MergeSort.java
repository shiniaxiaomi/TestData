package arithmetic;

import java.util.Arrays;

/**
 * Created by Yingjie.Lu on 2019/9/27.
 */

//归并排序
public class MergeSort {
    //将传入的arr进行排序
    public void sort(int[] arr){
        int[] temp=new int[arr.length];//开辟和原数组一样大的空间
        sort(arr,0,arr.length-1,temp);
    }
    //将arr中[left,right]的内容进行排序
    public void sort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            //分治
            sort(arr,left,mid,temp);//先将左边分至最小,并排序好
            sort(arr,mid+1,right,temp);//再将右边分至最小,并排序好
            //归并
            merge(arr,left,mid,right,temp);
        }
    }
    //归并
    public void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//左指针
        int j=mid+1;//右指针
        int t=0;//临时数组的指针(从零开始装)

        while(i<=mid && j<=right){//两边都还有数值
            if(arr[i]<arr[j]){
                temp[t++]=arr[i++];
            }else{
                temp[t++]=arr[j++];
            }
        }

        //有一边装完之后,就直接把另一半装到临时数据
        //如果右边已经装完了
        while(i<=mid){
            temp[t++]=arr[i++];
        }
        //如果左边已经装完了
        while(j<=right){
            temp[t++]=arr[j++];
        }

        //将临时数组里已经排好序的数据复制会arr
        t=0;//临时数据的索引清零
        while(left<=right){
            arr[left++]=temp[t++];
        }

    }
    //测试
    public static void main(String[] args) {
        int[] arr=new int[]{8,4,5,7,1,3,6,2};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
