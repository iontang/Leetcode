package largest_sum_of_averages

import (
	"math"
	"sort"
)

// 2020-12-07 22:28:15
// 813.Largest Sum of Averages
// largest-sum-of-averages

//We partition a row of numbers A into at most K adjacent (non-empty) groups, th
//en our score is the sum of the average of each group. What is the largest score
//we can achieve?
//
// Note that our partition must use every number in A, and that scores are not n
//ecessarily integers.
//
//
//Example:
//Input:
//A = [9,1,2,3,9]
//K = 3
//Output: 20
//Explanation:
//The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 +
//(1 + 2 + 3) / 3 + 9 = 20.
//We could have also partitioned A into [9, 1], [2], [3, 9], for example.
//That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 100.
// 1 <= A[i] <= 10000.
// 1 <= K <= A.length.
// Answers within 10^-6 of the correct answer will be accepted as correct.
//
// Related Topics Dynamic Programming
// 👍 1068 👎 51


//leetcode submit region begin(Prohibit modification and deletion)
// can not sort the array,
// because the positions of the array elements are not interchangeable
func largestSumOfAverages_W1(A []int, K int) float64 {
	sort.SliceStable(A, func(i, j int)bool{return A[i]<A[j]})
	arrLen := len(A)
	res := 0.0
	subLen := 0
	subTotal := 0
	for i := arrLen-1; i >=0; i-- {
		if K > 1 {
			res += float64(A[i])
			K--
		} else {
			subLen += 1
			subTotal += A[i]
		}
	}
	subAvg := float64(subTotal)/float64(subLen)
	return res + subAvg
}

func largestSumOfAverages_W2(A []int, K int) float64 {
	arrLen := len(A)
	dp := make([][]float64, K+1)
	for i := 0; i <= K; i++ {
		dp[i] = make([]float64, arrLen+1)
	}
	sum := 0
	for i := 1; i <= arrLen; i++ {
		sum += A[i-1]
		dp[1][i] = float64(sum)/float64(i)
	}
	for k := 2; k <= K; k++ {
		for i := k; i <= arrLen; i++ { // 起始值需要注意，是k, 不是1
			subSum := 0
			for j := k-1; j < i; j++ {
				subSum+=A[j]
				dp[k][i] = math.Max(dp[k][i], dp[k-1][j] + float64(subSum)/float64(i-j))
			}

		}
	}
	return dp[K][arrLen]
}

func largestSumOfAverages(A []int, K int) float64 {
	arrLen := len(A)
	dp := make([][]float64, K+1)
	for i := 0; i <= K; i++ {
		dp[i] = make([]float64, arrLen+1)
	}
	sum := make([]int, arrLen+1)
	for i := 1; i <= arrLen; i++ {
		sum[i] += sum[i-1]+A[i-1]
		dp[1][i] = float64(sum[i])/float64(i)
	}
	for k := 2; k <= K; k++ {
		for i := k; i <= arrLen; i++ { // 起始值需要注意，是k, 不是1
			for j := k-1; j < i; j++ {
				dp[k][i] = math.Max(dp[k][i], dp[k-1][j] + float64(sum[i] -sum[j])/float64(i-j))
			}
		}
	}
	return dp[K][arrLen]
}

// 空间可以缩小到一维
func largestSumOfAverages_A1(A []int, K int) float64 {
	n := len(A)
	sum := make([]int, n+1)
	for i := range A {
		sum[i+1] = sum[i] + A[i]
	}
	if K <= 1 {
		return float64(sum[n])/float64(n)
	} else if K >= n {
		return float64(sum[n])
	}

	dp := make([]float64, n)
	for i := 0; i < n; i++ {
		dp[i] = float64(sum[n]-sum[i])/float64(n-i)
	}

	for k := 0; k < K-1; k++ {
		for i := 0; i < n; i++ {
			for j := i+1; j < n; j++ {
				dp[i] = math.Max(dp[i], float64(sum[j]-sum[i])/float64(j-i) + dp[j])
			}
		}
	}

	return dp[0]
}
//leetcode submit region end(Prohibit modification and deletion)

