class Solution {
    
    public static boolean checkAll(String[] strs, StringBuilder start) {
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(start.toString())) return false;
        }
        return true;

    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        StringBuilder x =new StringBuilder();
        int i = 0;
        while (i < strs[0].length()) {
         
            x.append(strs[0].charAt(i));
            if (checkAll(strs, x)) result.append(strs[0].charAt(i));
            i++;
        }
        return result.toString();

    }
}