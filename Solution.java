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
     * 401. 二进制手表
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch(int num) {
        ArrayList<String> list = new ArrayList<>();
        String str = null;
        for (Integer i = 0; i < 12; i++) {
            for (Integer j = 0; j < 60; j++) {
                Integer integer = Stream.of(Integer.toBinaryString(i)).flatMap(u -> Arrays.stream(u.split(""))).map(v -> Integer.valueOf(v)).reduce((a, b) -> a + b).get();
                Integer integer1 = Stream.of(Integer.toBinaryString(j)).flatMap(u -> Arrays.stream(u.split(""))).map(v -> Integer.valueOf(v)).reduce((a, b) -> a + b).get();
                if(integer + integer1 == num){
                    if(j >= 10)
                       str= new String(i+":"+j);
                    else
                        str = new String(i+":0"+j);
                    list.add(str);
                }
            }
        }
        return list;
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

    /**
     * 118. 杨辉三角
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            lists.add(arrayList);
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < lists.get(i-1).size(); j++) {
                lists.get(i).add(lists.get(i-1).get(j-1) + lists.get(i-1).get(j));
            }
            lists.get(i).add(1);
        }

        return lists;
    }

}
