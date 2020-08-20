package problems_by_year.year_2020.month_03.problems_20200309.Number_of_Matching_Subsequences;

public class Solution {

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        Solution solution = new Solution();
        solution.numMatchingSubseq(S, words);
    }


    public int numMatchingSubseq(String S, String[] words) {

        TrieNode root = new TrieNode('/'); // 存储无意义字符
        insert(0, S.toCharArray(), root);

        return 1;
    }

    public void insert(int start, char[] text, TrieNode root) {
        if (start == text.length)
            return;
        TrieNode p = root;
        for (int i = start; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    /**
     * Time Limit Exceeded.
     * @param S
     * @param words
     * @return
     */
    public int numMatchingSubseq_W1(String S, String[] words) {
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            int found = 0;
            String t = words[i];
            for (int j = 0; j < S.length() && found < t.length(); j++) {
                if (S.charAt(j) == t.charAt(found)) {
                    ++found;
                }
                if (found == t.length()) {
                    ++cnt;
                    break;
                }
            }
        }
        return cnt;
    }

}
