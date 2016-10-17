/**
 * 17. Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 2(abc), 3(def), 4(ghi), 5(jkl), 6(mno), 7(pqrs), 8(tuv), 9(wxyz)
 */

public class Solution {
    // iterative solution with FIFO queue (like BFS)
    public List<String> letterCombinations(String digits) {
        LinkedList<String> re = new LinkedList<>();
        if(digits==null || digits.length()==0)
            return re;
        for(int i = 0; i < digits.length(); i++)
            if(digits.charAt(i)<'2' || digits.charAt(i)>'9')
                return re;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        re.add("");
        for(int i = 0; i < digits.length(); i++)
        {
            String ch = map[digits.charAt(i)-'0'];
            while(re.element().length() == i)
            {
                String com = re.remove();
                for(int j = 0; j < ch.length(); j++)
                    re.add(com + ch.charAt(j));
            }
        }
        
        return re;
    }

    // recursive solution
    private final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations_2(String digits) {
        List<String> re = new LinkedList<>();
        if(digits==null || digits.length()==0)
            return re;
        for(int i = 0; i < digits.length(); i++)
            if(digits.charAt(i)<'2' || digits.charAt(i)>'9')
                return re;
        
        gencom(re, digits, 0, new StringBuilder());
        return re;
    }
    
    private void gencom(List<String> re, String digits, int offset, StringBuilder com)
    {
        String ch = MAP[digits.charAt(offset)-'0'];
        for(int i = 0; i < ch.length(); i++)
        {
            com.append(ch.charAt(i));
            if(offset == digits.length()-1)
                re.add(com.toString());
            else
                gencom(re, digits, offset+1, com);
            com.deleteCharAt(offset);
        }
    }
}
