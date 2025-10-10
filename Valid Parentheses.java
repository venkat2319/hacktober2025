class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack(); 
        Map<Character, Character> mapping = new HashMap<>();
  
        mapping.put('(', ')');
        mapping.put('[', ']');
        mapping.put('{', '}');

        for (int i = 0; i < s.length(); i++) {
            char currentLetter = s.charAt(i);
            if (mapping.containsKey(currentLetter)) {
                stack.push(mapping.get(currentLetter));
                continue;
            }
    
            char currentLetterFromStack;
            try {
                currentLetterFromStack = stack.pop();
            }  catch (Exception e) {
                currentLetterFromStack = '0';
            }
            if (currentLetterFromStack != currentLetter) {
                return false;
            }

        }
        return stack.isEmpty();   
    }
}
