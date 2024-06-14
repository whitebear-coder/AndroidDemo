package com.example.servicebestpractice;

public class Solution {
    public long maxScore(int[] nums, int x) {
        long res = nums[0];
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0]%2] = nums[0];

        for(int i=0;i<nums.length;i++){
            int parity = (int)(nums[i]%2);
            //取当前的最大值
            long cur = Math.max(dp[parity]+nums[i], dp[1-parity] - x + nums[i]);
            res = Math.max(res, cur);
            //不保留当前值和保留当前值取最大
            dp[parity] = Math.max(dp[parity], cur);
        }
        return res;
    }
}
