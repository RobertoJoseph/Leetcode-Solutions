class Solution {
   public static String reverseVowels(String s) {
        char[] arr= s.toCharArray();
        Set<Character> vowels=new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        Stack<Character> stack=new Stack<Character>();
        for(char c:arr)
        {
            if(vowels.contains(c)) stack.push(c);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(vowels.contains(arr[i])) 
            {
                arr[i]=stack.pop();
            }
        }
        return new String(arr);
    }

}