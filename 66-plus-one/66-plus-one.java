class Solution {
   
   
    public  int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int x : digits) list.add(x);
            int i = digits.length - 1;
            while (i >= 0 && digits[i] == 9) {
                list.remove(i);
                list.add(i, 0);
                i--;
            }
            if (i < 0) {
                list.add(0, 1);
            } else {
                int element = list.remove(i);
                list.add(i, element + 1);
            }
            int[] result = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                result[j] = list.get(j);
            }
            return result;

        }


    }
}