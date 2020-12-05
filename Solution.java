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

}