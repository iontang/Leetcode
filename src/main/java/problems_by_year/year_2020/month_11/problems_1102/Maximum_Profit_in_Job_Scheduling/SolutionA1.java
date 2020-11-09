package problems_by_year.year_2020.month_11.problems_1102.Maximum_Profit_in_Job_Scheduling;

/**
 * ClassName SolutionA1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/11/3 11:19 下午
 */
public class SolutionA1 {
    private void quickSort(int[] arry, int[] arry1, int[] arry2, int l, int r) {
        if (r <= l) return;
        int x = arry[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do i++; while (arry[i] < x);
            do j--; while (arry[j] > x);
            if (i < j) {
                int tmp = arry[i];
                arry[i] = arry[j];
                arry[j] = tmp;

                tmp = arry1[i];
                arry1[i] = arry1[j];
                arry1[j] = tmp;

                tmp = arry2[i];
                arry2[i] = arry2[j];
                arry2[j] = tmp;
            }
        }
        quickSort(arry, arry1, arry2, l, j);
        quickSort(arry, arry1, arry2, j + 1, r);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        if (n == 0) return 0;
        if (n == 1) return profit[0];
        quickSort(endTime, startTime, profit, 0, n - 1);
        int[] w = new int[n];
        int[] results = new int[n];
        for (int i = 1; i < n; i++) {
            //找第i个作业的开始时间距离最近的某个作业的结束时间，返回这个作业的结束时间
            int j = i - 1;
            while (j >= 0 && endTime[j] > startTime[i]) j--;
            w[i] = j;
        }
        results[0] = profit[0];
        int max = results[0];
        for (int i = 1; i < n; i++) {
            if (w[i] == -1) results[i] = Math.max(results[i - 1], profit[i]);
            else results[i] = Math.max(results[i - 1], results[w[i]] + profit[i]);
        }
        return results[n - 1];
    }
}

