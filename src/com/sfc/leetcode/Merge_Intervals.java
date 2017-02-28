package com.sfc.leetcode;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * Created by Prophet on 2017/2/28.
 */
public class Merge_Intervals {
    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        // 放置 merge 后的 list
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) return result;

        // 实现 Comparator 接口
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start > b.start) return 1;
                else if (a.start < b.start) return -1;
                else {
                    if (a.end > b.end) return 1;
                    else if (a.end < b.end) return -1;
                    else return 0;
                }
            }
        };

        // 对 intervals 进行排序
        Collections.sort(intervals, comparator);

        // 当前 interval
        Interval current = intervals.get(0);
        result.add(current);
        // result 中的上一个 interval，要进行判断，看是否将 current merge 到 last 中
        Interval last = result.get(0);

        for (int i = 0; i < intervals.size(); i++) {
            // 取得 intervals 中的当前一个
            current = intervals.get(i);
            // 取得 result 中的最后一个
            last = result.get(result.size() - 1);

            if (last.end >= current.start) {
                // 有重复区间，合并 current 与 last 的区间
                last.end = Math.max(current.end, last.end);
            } else {
                // result 中添加新的无重复区间的 interval
                result.add(new Interval(current.start, current.end));
            }
        }


        return result;
    }
}
