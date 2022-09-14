class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> hs = new HashMap<Character, Integer>() {

            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int result = 0;
        char[] chrs = s.toCharArray();
        int i =0;
        while (i < chrs.length - 1) {
            if (hs.get(chrs[i + 1]) > hs.get(chrs[i])) {
                result += (hs.get(chrs[i + 1]) - hs.get(chrs[i]));
                i+=2;
            } else {
                result += (hs.get(chrs[i]));
                i++;
            }
        }
        int len = chrs.length;
        if (len == 1) result += hs.get(chrs[0]);
        if (len >= 2) {
            System.out.println(hs.get(chrs[len - 1]));
            if (hs.get(chrs[len - 1]) <= hs.get(chrs[len - 2])) result = result + hs.get(chrs[len - 1]);
        }
        return result;
    }
}
