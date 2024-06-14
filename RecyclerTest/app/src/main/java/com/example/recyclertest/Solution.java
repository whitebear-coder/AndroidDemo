package com.example.recyclertest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (item0, item1)->item1[0] - item0[0]);
        HashSet<Integer> categorySet = new HashSet<Integer>();
        long profit = 0, res = 0;
        Queue<Integer> st = new ArrayDeque<Integer>();

        for(int i=0;i<items.length;i++){
            if(i<k){
                profit+=items[i][0];
                if(!categorySet.add(items[i][1])){
                    st.push(items[i][0]);
                }
            }else if(!st.isEmpty() && categorySet.add(items[i][1])){
                profit += items[i][0] - st.pop();
            }
            res = Math.max(res, profit + (long) categorySet.size() * categorySet.size());
        }
        return res;

    }
}
