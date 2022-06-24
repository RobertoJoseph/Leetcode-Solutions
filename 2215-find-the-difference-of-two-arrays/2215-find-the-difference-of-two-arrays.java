class Solution {
   
   
    public static int removeduplicates(int a[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // creating another array for only storing
        // the unique elements
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                temp[j++] = a[i];
            }
        }

        temp[j++] = a[n - 1];

        // Changing the original array
        for (int i = 0; i < j; i++) {
            a[i] = temp[i];
        }

        return j;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : nums2) {
            ts.add(x);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int index1 = removeduplicates(nums1, nums1.length);
        int index2 = removeduplicates(nums2, nums2.length);

        for (int i = 0; i < index1; i++) {
            if (!ts.contains(nums1[i])) {
                if (!list1.contains(nums1[i]))
                    list1.add(nums1[i]);
            }
        }
        TreeSet<Integer> ts2 = new TreeSet<>();
        for (int x : nums1) {
            ts2.add(x);
        }
        for (int i = 0; i < index2; i++) {
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