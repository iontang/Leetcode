package problems_by_year.year_2020.month_05.problems_0511.Implement_Trie;

public class TrieA1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() & 100);
        Thread.sleep(System.currentTimeMillis() & 100);
        System.out.println(1000 & 100);
    }

    TrieA1[] ts = new TrieA1[26];
    boolean hit = false;

    /** Initialize your data structure here. */
    public TrieA1() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        load(word, 0, word.length());
    }

    void load(String v, int i, int l){
        if (i == l) {
            hit = true;
        } else{
            int j = v.charAt(i) - 'a';
            if (ts[j] == null) {
                ts[j] = new TrieA1();
            }
            ts[j].load(v, i+1, l);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return query(word, 0, word.length());
    }

    boolean query(String v, int i, int l){
        if(i == l){
            return hit;
        }
        else{
            int j = v.charAt(i) - 'a';
            if (ts[j] == null) {
                return false;
            }
            return ts[j].query(v, i+1, l);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return queryPrefix(prefix, 0, prefix.length());
    }

    boolean queryPrefix(String v, int i, int l){
        if(i == l){
            if(hit) return true;
            for(int j = 0; j < 26; j++){
                if(ts[j] != null) return true;
            }
            return false;
        }
        else{
            int j = v.charAt(i) - 'a';
            if(ts[j] == null) return false;
            return ts[j].queryPrefix(v, i+1, l);
        }
    }
}
