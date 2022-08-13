class Solution {
    
    public  String getPattern(String word) {
        StringBuilder stb = new StringBuilder();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int x = (chars[i + 1] - chars[i] + 26) % 26;
            stb.append( (char)(x));
        }
        System.out.println(stb);
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
  