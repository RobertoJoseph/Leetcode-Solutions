class Solution {
    
    public  String getPattern(String word) {
        StringBuilder stb = new StringBuilder();
        char[] chars = word.toCharArray();
         for (int i = 1; i < chars.length; i++) {
            stb.append((char) ((chars[i] - chars[i - 1] + 26)%26  ));
        }
        return stb.toString();
    }
  
    public List<List<String>> groupStrings(String[] strings) {
     
        List<List<String>>result = new LinkedList<>();
        Map<String,List<String>>map = new HashMap<>();
    
        for(String word : strings){
            String pattern = getPattern(word);
            if(!map.containsKey(pattern))
                map.put(pattern,new LinkedList<>());
            map.get(pattern).add(word);
        }
        for(List<String>group:map.values()){
            result.add(group);
        }
        return result;
    }
}
  