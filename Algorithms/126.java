public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        String[] words = new String[wordList.size()+2];
        words[0] = beginWord;
        words[words.length-1] = endWord;
        int idx = 1;
        for(String word : wordList)
            words[idx++] = word;
        
        List<Integer>[] G = createGraph(words);
        List<Integer>[] edgeTo = findPaths(G, words, 0);
        return pathTo(edgeTo, 0, words.length-1);
    }

    private List<Integer>[] createGraph(String[] words)
    {
        List<Integer>[] G = new List[words.length];
        for(int i = 0; i < G.length; i++)
            G[i] = new LinkedList<>();
        for(int i = 0; i < words.length; i++)
            for(int j = i+1; j < words.length; j++)
            {
                int d = 0;
                for(int k = 0; k < words[i].length(); k++)
                {
                    if(words[i].charAt(k) != words[j].charAt(k))
                        d++;
                    if(d > 1)
                        break;
                }
                if(d == 1)
                {
                    G[i].add(j);
                    G[j].add(i);
                }
            }
        return G;
    }

    private HashMap<String, List<String>> findPaths(HashMap<String, List<String>> G, Set<String> wordList, String beginWord)
    {
        HashMap<String, List<String>> edgeTo = new HashMap<>();
        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, Boolean> marked = new HashMap<>();
        for(String word : wordList)
        {
            edgeTo.put(word, new LinkedList<String>());
            dist.put(word, Integer.MAX_VALUE);
            marked.put(word, false);
        }
        dist.put(beginWord, 0);
        LinkedList<String> vt = new LinkedList<>();
        vt.add(beginWord);
        marked.put(beginWord, true);
        while(!vt.isEmpty())
        {
            String v = vt.remove();
            for(String w : G.get(v))
            {
                if(!marked.get(w))
                {
                    vt.add(w);
                    marked.put(w, true);
                }
                int t_dist = dist.get(v) + 1;
                if(t_dist < dist.get(w))
                {
                    dist.put(w, t_dist);
                    List<String> a = new LinkedList<>();
                    a.add(v);
                    edgeTo.put(w, a);
                }
                else if(t_dist == dist.get(w))
                    edgeTo.get(w).add(v);
            }
        }
        return edgeTo;
    }

    private List<List<String>> pathTo(HashMap<String, List<String>> edgeTo, String beginWord, String endWord)
    {
        List<List<String>> paths = new LinkedList<>();
        pathTo(paths, new LinkedList<String>(), edgeTo, beginWord, endWord);
        return paths;
    }

    private void pathTo(List<List<String>> paths, LinkedList<String> path, HashMap<String, List<String>> edgeTo, String beginWord, String endWord)
    {
        if(endWord.equals(beginWord))
        {
            path.push(beginWord);
            paths.add((List<String>) path.clone());
            path.pop();
            return;
        }
        path.push(endWord);
        for(String w : edgeTo.get(endWord))
            pathTo(paths, path, edgeTo, beginWord, w);
        path.pop();
    }
}
