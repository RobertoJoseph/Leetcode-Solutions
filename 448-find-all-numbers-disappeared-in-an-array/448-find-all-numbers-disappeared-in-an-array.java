class Solution {
    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) hs.add(x);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1) && !hs.contains(i+1)) {
                list.add(i + 1);
            }

        }
        return list;
    }

}