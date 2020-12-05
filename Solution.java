package com.company;


import java.util.Arrays;

/**
 * @date: 2020/11/30
 * @author: tianling
 * @email: 859073143@qq.com
 */
public class Solution {
    /**
     * 621. 任务调度器 桶思想 如果少的话不能运行 需要找最大的
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int len =  tasks.length;
        int[] temp = new int[26];
        for (int i = 0; i < len; i++) {
            temp[tasks[i]-'A']++;
        }
        Arrays.sort(temp);
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if(temp[25] == temp[i])
                maxCount++;
            else
                break;
        }
        int num = (n+1) * (temp[25] -1 ) + maxCount;
        return Math.max(num,len);
    }
     /**
     * 401. 二进制手表 第二种解法
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch1(int num) {
        ArrayList<String> list = new ArrayList<>();
        int[] x = new int[10];
        dfs(0,list,num,x);
        return list;
    }
    private static void dfs(int i, List list,int num,int[] x){

        if(Arrays.stream(x).sum() == num){
            int temp = 0;
            int count = 0;
            for (int j = 3; j >= 0; j--) {
                temp += Math.pow(2,count++) * x[j];
            }
            count = 0;
            int temp2 = 0;
            for (int j = 9; j >=4; j--) {
                temp2 += Math.pow(2,count++) * x[j];
            }
            if(temp >=12 || temp2 >= 60)
                return;
            if(temp2 < 10)
                list.add(temp+":0"+temp2);
            else
                list.add(temp+":"+temp2);

        }else{
            if(i >= 10) return ;
            x[i] = 0;
            dfs(i+1,list,num,x);
            x[i] = 1;
            dfs(i+1,list,num,x);
        }
    }

}
