package com.learn.algorithms.leetcode.Problem14.approach2;

public class Approach2 {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String result = commonPrefix(strs);
        System.out.println(result);
    }

    public static String commonPrefix(String[] strs){
        if(strs == null || strs.length < 2){
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                    return "";

            }
        }
        return prefix;
    }

}
