package src.dp;

/**
 * A-Z f : 1-26
 * @author tangning
 * 2017年11月22日 下午4:02:40
 */
public class DecodeWays {

	public static void main(String[] args) {
		char[] cArr = new char[26];
		// quick generate upper case:
		
//		char upperZ = 'Z';
//        for(int j = 65; ;j++){
//        	cArr[j-65] = (char)j;
//            if(upperZ == (char)j) {  
//                break;  
//            }  
//        }
        
        
        // 1:
        // 12: 1|2 12|————2种     34: 1种
        // 2|6|10 26|10   :2
        // 26|11 26|1|1 2|6|11 2|6|1|1
        // 题目的最终思路，动态规划：划分String，其需要满足的条件：必须是1/2位，且在1到26之间
        // 动态规划的解题思路是什么？
        // 状态：			d(1) = 1, d(2) = 
        // 状态转移方程：	d(i) = 

//		for (int i=0;i<cArr.length;i++) {
//        	System.out.println(i+1 + " " + cArr[i]);
//        }
        
        String sNum = "2611"; // 2的（len-1）次方种组合
//        sNum.toCharArray();
        int len = sNum.length(); // 1
        for(int i=0;i<len;i++) {
//        	int cNum = Character.getNumericValue(sNum.charAt(i));
        	int cNum = sNum.charAt(i) - '0';
			if (0 < cNum && cNum < 27) {
//				System.out.println(cNum);
			}
        }
        
        DecodeWays dw = new DecodeWays();
        dw.numDecodings_A1("0");
        dw.numDecodings_A1("2611");
	}
	
	/**
	 * ref:
	 * 1、d[i] = d[i-1]
	 * 2、d[i] = 
	 * */
    public int numDecodings(String s) {
    	
    	int sLen = s.length();
    	if (sLen == 0 || (sLen == 1 && s.charAt(0) == '0')) 
    		return 0;
    	
    	int[] d = new int[sLen+1];
    	d[0] = 1; // 有0个数的时候
    	d[1] = 1; // 有一个数的时候
    	
    	for (int i =1;i<sLen;i++) {
    		if((s.charAt(i-1) == '1' || s.charAt(i-1) == '2') && s.charAt(i)<='6') {
    			d[i+1] = d[i-1];
    		}
    		if (s.charAt(i) != '0') {
    			d[i+1] +=d[i];
    		}
    	}
    	for(int j = 0;j<d.length;j++) {
    		System.out.println(d[j]);
    	}
    	return d[sLen];
    }
    
    
    //2611
    
    //初始状态： d[0]=1,d[1]=0/1
    // 从第二位开始，i-1在1到9之间，i的值是dp[i] = dp[i]+ dp[i-1]; 
    // 对于两位数的：dp[i] = dp[i]+ dp[i-2];
    public int numDecodings_A1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
//        	System.out.println("each = " + s.charAt(i-1));
            int first = Integer.valueOf(s.substring(i-1, i));
//            System.out.println("first = " + first );
            int second = Integer.valueOf(s.substring(i-2, i));
//            System.out.println("second=" + second);
            if(first >= 1 && first <= 9) {
               dp[i] = dp[i]+ dp[i-1];  
               System.out.println("dp[i]first = " + dp[i]);
            }
            if(second >= 10 && second <= 26) {
                dp[i] = dp[i]+ dp[i-2];
                System.out.println("dp[i]second = " + dp[i]);
            }
        }
    	for(int j = 0;j<n+1;j++) {
    		System.out.println("## = " +dp[j]);
    	}
        return dp[n];
    }
    
    //first
    public int numDecodings_A2(String s) {
        if(s.length()==0||s==null||s.charAt(0)=='0') return 0;
                
        int pre=1,cur=1;
        for(int i=1;i<s.length();i++){
            int temp=cur;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    cur=pre;
                }
                else return 0;
            }
            else{
                if(s.charAt(i-1)=='1'){
                    cur=pre+temp;
                }
                else if(s.charAt(i-1)=='2'){
                    if(s.charAt(i)-'0'>6){
                        cur=temp;
                    }
                    else{
                        cur=pre+temp;
                    }
                }
                else{
                    cur=temp;
                }
            }
            pre=temp;
        }
        return cur;
    }
    
    public int numDecodings_A3(String s) {
        //DP方法，DP[i]表示，从第i的index往后这个subarray可以被解读的个数。
        if (s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] result = new int[s.length() + 1];
        if (s.charAt(n - 1) - '0' != 0){
            result[n - 1] = 1;
        }
        result[n] = 1; //为了result[n - 2]的统一化更新作准备的
        for (int i = n - 2; i >= 0; i--){
            if (s.charAt(i) - '0' == 0){
                continue;
            }
            if (s.charAt(i) - '0' >= 3 || s.charAt(i) - '0' == 2 && s.charAt(i + 1) - '0' > 6){//说明解读的方式不能从i 跳跃到 i + 2，所以只能以来 i + 1
                result[i] = result[i + 1];
            } else {
                result[i] = result[i + 1] + result[i + 2];
            }
        }
        return result[0];
    }

}
