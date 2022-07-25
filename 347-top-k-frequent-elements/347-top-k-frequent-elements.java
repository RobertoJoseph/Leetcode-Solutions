class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i =0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer>[]buckets = new List[arr.length+1];
        for(int i =0; i<buckets.length; i++){
            buckets[i]= new ArrayList<>();
        }
        for(int key: map.keySet()){
            buckets[map.get(key)].add(key);
        }
        List<Integer>flattened = new ArrayList<>();
        for(int i = buckets.length-1; i>=0; i--){
            for(int num : buckets[i]){
                flattened.add(num);
            }
        }
        int[]result = new int[k];
        for(int i =0; i<k; i++){
            result[i]=flattened.get(i);
        }
        return result;
        
     
    }
}