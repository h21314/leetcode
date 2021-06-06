package com.hetufei.leetcode.middle.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Created by hekangmin on 2021/6/6 15:04
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<>();
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (list.contains(s.charAt(j))){
                    break;
                }else{
                    list.add(s.charAt(j));
                }
            }
            maxLength = Math.max(maxLength, list.size());
        }
        return maxLength;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringByDp(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end = 0,start = 0; end < len; end++) {
            char temp = s.charAt(end);
            if (map.containsKey(temp)) {//如果包含end所在的字符，则更新start的位置，否则讲end所在的字符放入map中
                start = Math.max(map.get(temp), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end),end + 1);
        }
        return ans;

    }
}
