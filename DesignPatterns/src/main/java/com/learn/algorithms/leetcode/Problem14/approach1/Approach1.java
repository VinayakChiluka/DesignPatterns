package com.learn.algorithms.leetcode.Problem14.approach1;

import java.util.Arrays;
import java.util.Comparator;

public class Approach1 {
    public static void main(String[] args) {
       String[] strs = new String[]{"flower","flow","flight"};
       String result = commonPrefix(strs);
        System.out.println(result);
    }

    public static String commonPrefix(String[] strs){
        if(strs == null || strs.length < 2){
            return "";
        }
        String prefix = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).get();
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            for(String str: strs){
                if(str.charAt(i) != c){
                    return prefix.substring(0,i);
                }
            }
        }
        return prefix;
    }
}