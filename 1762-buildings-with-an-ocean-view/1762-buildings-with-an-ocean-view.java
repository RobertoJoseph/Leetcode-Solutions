class Solution {
    
    public static int[] findBuildings(int[] heights) {
        
        int max = -1;
        List<Integer>list = new ArrayList<>();
        for(int i = heights.length-1; i>=0; i--){
            if(heights[i]>max){
                max = heights[i];
                list.add(i);
            }
        }
        int[]result = new int[list.size()];
        int j =0;
        for(int i = list.size()-1; i>=0; i--){
            result[j] = list.get(i);
            j++;
        }
        return result;
        
       
    }
}