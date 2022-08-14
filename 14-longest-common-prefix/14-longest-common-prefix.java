class Solution {
    
    public static boolean checkAll(String[] strs, String start) {
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(start)) return false;
        }
        return true;

    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        String x = "";
        int i = 0;
        while (i < strs[0].length()) {
            x += strs[0].charAt(i); //F
            if (checkAll(strs, x)) result = result + strs[0].charAt(i);
            i++;
        }
        return result;

    }
}