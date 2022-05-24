class Solution {
      public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helperFunction(result, current, nums);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] nums) {
       if (current.size() == nums.length) {
           result.add(new ArrayList<>(current));
           return;
        }
        for (int i=0; i<nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            helperFunction(result, current, nums);
            current.remove(current.size()-1);
            
        }
    }
}