class Solution {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int pt1 = 0;
        int pt2 = 0;
        String res = "";
        int x = 0;
        while (pt1 < word.length() && pt2 < abbr.length()) {
            String con = "";
            if (word.charAt(pt1) == abbr.charAt(pt2)) {
                res += word.charAt(pt1);
                pt1++;
                pt2++;
            } else if (word.charAt(pt1) != abbr.charAt(pt2)
                && !Character.isDigit(abbr.charAt(pt2))) {
                return false;
            } else if (Character.isDigit(abbr.charAt(pt2)) && abbr.charAt(pt2) != '0') {
                while (pt2 < abbr.length() && Character.isDigit(abbr.charAt(pt2))) {
                    con += abbr.charAt(pt2);
                    pt2++;
                }
                x = Integer.parseInt(con);
                while (pt1 < word.length() && x-- > 0) {
                    res += word.charAt(pt1);
                    pt1++;
                }
                if (x > 0) return false;
            }else return false;
        }
        if (res.length() == word.length()&&pt1==word.length()&&pt2==abbr.length()) return true;
        return false;
    }
}