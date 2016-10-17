public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        String[] words = new String[wordList.size()+2];
        words[0] = beginWord;
        words[words.length-1] = endWord;
        int idx = 1;
        for(String word : wordList)
            words[idx++] = word;
        
        List<Integer>[] G = createGraph(words);
        List<Integer>[] edgeTo = findPaths(G, 0);
        return pathTo(edgeTo, 0, words.length-1, words);
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

    private List<Integer>[] findPaths(List<Integer>[] G, int begin)
    {
        List<Integer>[] edgeTo = new List[G.length];
        int[] dist = new int[G.length];         // all 0
        boolean[] marked = new boolean[G.length];   // all false
        for(int i = 0; i < G.length; i++)
        {
            edgeTo[i] = new LinkedList<>();
        }
        dist[begin] = -1;
        LinkedList<Integer> vt = new LinkedList<>();
        vt.add(begin);
        marked[begin] = true;
        while(!vt.isEmpty())
        {
            int v = vt.remove();
            for(int w : G[v])
            {
                if(!marked[w])
                {
                    vt.add(w);
                    marked[w] = true;
                }
                int t_dist = dist[v] + 1;
                if(dist[w]==0 || t_dist<dist[w])
                {
                    dist[w] = t_dist;
                    List<Integer> a = new LinkedList<>();
                    a.add(v);
                    edgeTo[w] = a;
                }
                else if(t_dist == dist[w])
                    edgeTo[w].add(v);
            }
        }
        return edgeTo;
    }

    private List<List<String>> pathTo(List<Integer>[] edgeTo, int begin, int end, String[] words)
    {
        List<List<String>> paths = new LinkedList<>();
        pathTo(paths, new LinkedList<String>(), edgeTo, begin, end, words);
        return paths;
    }

    private void pathTo(List<List<String>> paths, LinkedList<String> path, List<Integer>[] edgeTo, int begin, int end, String[] words)
    {
        if(end == begin)
        {
            path.push(words[begin]);
            paths.add((List<String>) path.clone());
            path.pop();
            return;
        }
        path.push(words[end]);
        for(int w : edgeTo[end])
            pathTo(paths, path, edgeTo, begin, w, words);
        path.pop();
    }
}
