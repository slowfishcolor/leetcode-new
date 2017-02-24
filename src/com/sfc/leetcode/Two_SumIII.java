package com.sfc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations:add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * Created by Prophet on 2017/2/24.
 */
public class Two_SumIII {

    Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for(int k: map.keySet()) {
            int t = value - k;
            if (t == k && map.get(k) > 1) {
                return true;
            } else if (t != k && map.containsKey(k)) {
                return true;
            }
        }
        return false;
    }
}
