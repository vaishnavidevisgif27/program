class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char pc = pattern.charAt(i);
            String w = words[i];

            if (p2w.containsKey(pc)) {
                if (!p2w.get(pc).equals(w)) return false;
            } else {
                if (w2p.containsKey(w)) return false;
                p2w.put(pc, w);
                w2p.put(w, pc);
            }
        }
        return true;
    }
}