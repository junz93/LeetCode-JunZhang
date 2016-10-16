/**
 * 30. Substring with Concatenation of All Words
 * You are given a string, <b>s</b>, and a list of words, <b>words</b>, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words 
 * exactly once and without any intervening characters.
 */

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if(s.length()==0 || words.length==0)
            return res;
        
        int len_word = words[0].length();
        int num_words = words.length;
        HashMap<String, Integer> words_cnt = new HashMap<>();
        for(String word : words)
        {
            if(words_cnt.containsKey(word))
                words_cnt.put(word, words_cnt.get(word)+1);
            else
                words_cnt.put(word, 1);
        }
        
        for(int k = 0; k < len_word; k++)
        {
            int num = 0;
            HashMap<String, Integer> words_enc = new HashMap<>();
            for(int i = k; i <= s.length()-len_word*(num_words-num); i += len_word)
            {
                if(num == 0)
                    words_enc = new HashMap<>();
                String w = s.substring(i, i+len_word);
                if(!words_cnt.containsKey(w))
                    num = 0;
                else
                {
                    if(!words_enc.containsKey(w))
                    {
                        words_enc.put(w, 1);
                        num++;
                    }
                    else if(words_enc.get(w) == words_cnt.get(w))
                    {
                        int p;
                        for(p = i-len_word*num; p < i; p += len_word)
                        {
                            String t = s.substring(p, p+len_word);
                            if(t.equals(w))
                                break;
                            else
                            {
                                words_enc.put(t, words_enc.get(t)-1);
                                num--;
                            }
                        }
                    }
                    else
                    {
                        words_enc.put(w, words_enc.get(w)+1);
                        num++;
                    }
                }                
                
                if(num == num_words)
                {
                    int start = i-len_word*(num-1);
                    res.add(start);
                    String t = s.substring(start, start+len_word);
                    words_enc.put(t, words_enc.get(t)-1);
                    num--;
                }
            }
        }
        
        return res;
    }
}
