class Solution {
    private List<List<Integer>>allSubsets;

    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        allSubsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            // just add empty subset.
            allSubsets.add(new LinkedList<Integer>());
            return allSubsets;
        }
        
        this.nums = nums.clone();

        subsetsHelper(0, new LinkedList<Integer>());

        return allSubsets;
    }

    // Recursive functions are often called "helpers".
    // Out state here is the current index in nums, and subset we have so far
    private void subsetsHelper(int index, List<Integer> currentSubset) {
        // if we are beyond the end of the nums array, copy current subset to the result
        if (index == nums.length) {
            allSubsets.add(new LinkedList<Integer>(currentSubset));
            return;
        }

        // we skip the current nums[index] number, and move to the next index
        subsetsHelper(index + 1, currentSubset);

        // we add the current number nums[index] to the current subset.
        currentSubset.add(nums[index]);
        subsetsHelper(index + 1, currentSubset);
        // after the recursive call we remove the current number 
        // (last element in the list) to restore the current subset.
        currentSubset.remove(currentSubset.size() - 1);
    }
}