class Solution {
   
   
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> ts = new HashSet<>();
        for (int x : nums2) {
            ts.add(x);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!ts.contains(nums1[i])) {
                if (!list1.contains(nums1[i]))
                    list1.add(nums1[i]);
            }
        }
        HashSet<Integer> ts2 = new HashSet<>();
        for (int x : nums1) {
            ts2.add(x);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!ts2.contains(nums2[i])) {
                if (!list2.contains(nums2[i]))
                    list2.add(nums2[i]);
            }
        }
        List<List<Integer>> newResult = new ArrayList<>();
        newResult.add(list1);
        newResult.add(list2);
        return newResult;


    }
}