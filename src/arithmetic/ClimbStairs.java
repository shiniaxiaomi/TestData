package arithmetic;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/9/27.
 */

//使用动态规划解决台阶问题: 有n个台阶,每次只能迈一步或两步,有几种走法
public class ClimbStairs {

    //保存已经计算过的最优子结构的值
    HashMap<Integer,Integer> map=new HashMap<>();

    //到达n及台阶时所需要的方法数
    public int arrive(int n){

        //如果已经计算过,则直接返回
        if(map.containsKey(n)){
            return map.get(n);
        }

        //如果是第1个台阶和第2个台阶的走法都只有1,所以直接返回1
        if(n==1 || n==2){
            map.put(n,1);//将结果保存
            return 1;
        }else{
            int i = arrive(n - 1) + arrive(n - 2);//通过上一个子结构的值结算得到当前第n个台阶的走法个数
            map.put(n,i);//将结果保存
            return i;
        }
    }
    //测试
    public static void main(String[] args) {
        int arrive = new ClimbStairs().arrive(1000);
        System.out.println(arrive);
    }

}
