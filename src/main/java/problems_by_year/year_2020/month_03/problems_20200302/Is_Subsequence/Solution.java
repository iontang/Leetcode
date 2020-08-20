package problems_by_year.year_2020.month_03.problems_20200302.Is_Subsequence;

public class Solution {

    /**
     * time complexity: O(n * m)
     * space complexity: O()
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int slen=s.length(),tlen=t.length();
        if(slen==0)
            return true;
        if(tlen<slen)
            return false;
        int cnt = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = start; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    start = j+1;
                    cnt += 1;
                    break;
                }
            }
        }
        return cnt == s.length();
    }



    public boolean isSubsequence_A1(String s, String t) {
        int slen=s.length(),tlen=t.length();
        if(slen==0)
            return true;
        if(tlen<slen)
            return false;
        int found=0;
        for(int i=0; found<slen && i<tlen;i++)
        {
            if(s.charAt(found)==t.charAt(i))
            {
                found++;
            }
        }
        return found==slen;
    }

}
