class Solution {
       static List<List<Integer>> ans;
    public  List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        ArrayList<Integer> newNums = new ArrayList<>();
        for (int x : nums) newNums.add(x);
        permuteHelper(newNums, new ArrayList<>());
        return ans;
    }

    public  void permuteHelper(ArrayList<Integer> nums,
                                     ArrayList<Integer> currentSubset) {
        if (nums.size() == 0) {
            ans.add(new ArrayList<>(currentSubset));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            ArrayList ArrList2 = (ArrayList) nums.clone();
            ArrList2.remove(ArrList2.get(i)); //Remove the object
            currentSubset.add(nums.get(i));
            permuteHelper(ArrList2, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}