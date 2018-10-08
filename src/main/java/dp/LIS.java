package dp;

/**
 * 最长子序列
 *
 * @author tangning
 * 2017年11月23日 下午2:18:06
 */
public class LIS {

    public int getLis(int A[], int n) {
        int[] dArr = new int[n]; // O(n)的空间
        int len = 1;
        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            dArr[i] = 1; // 每次初始化都为1，
            for (int j = 0; j < i; j++) {
                System.out.println("##j  = " + j + " | " + "dArr[" + j + "]= " + dArr[j]);
                if (A[j] <= A[i] && dArr[j] + 1 > dArr[i]) {
                    dArr[i] = dArr[j] + 1;
                }
                if (dArr[i] > len) {
                    len = dArr[i];
                }
            }
            System.out.println("------");
//			System.out.println(dArr[i] + " " + i);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] A = {5, 3, 4, 8, 6, 7};
        LIS lis = new LIS();
        System.out.println(lis.getLis(A, A.length));
    }

}
