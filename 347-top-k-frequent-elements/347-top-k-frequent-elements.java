class Solution {
    
    public static int[] topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hs.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        int i = 0;
        int[] result = new int[k];
        for (Map.Entry<Integer, Integer> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
            if (k > 0) {
                result[i] = e.getKey();
                k--;
                i++;
            } else break;
        }
        return result;

    }
}