class Solution {
    public List<String> removeAnagrams(String[] words) {
       // sorting-based approach
       List<String> res = new ArrayList<>();
       String lastKey=  null;
       for(String w : words) {
        char[] ca = w.toCharArray();
        Arrays.sort(ca);
        String key = new String(ca);
        if(lastKey == null || !lastKey.equals(key)) {
            res.add(w);
            lastKey = key;
        }
        //else skip(its an anagram of last added)
       } 
       return res;
    }
    //count-based approach (O(n*m) time)
    public List<String> removeAnagramCount(String[] words) {
        List<String> res = new ArrayList<>();
        String lastKey = null;
        for(String w : words) {
            String key = buildCountKey(w);
            if(lastKey == null || !lastKey.equals(key)) {
                res.add(w);
                lastKey = key;
            }
        }
        return res;
    }
    private String buildCountKey(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) freq[c-'a']++;
        //build compact signature
        StringBuilder sb = new StringBuilder(52);
        for(int f : freq) {
            sb.append(f).append('#');// delimiter to avoid ambiguity
        }
        return sb.toString();
    }
}