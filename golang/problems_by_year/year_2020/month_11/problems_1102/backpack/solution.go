package backpack

import "math"

/**
 * @param m: An integer m denotes the size of a backpack
 * @param A: Given n items with size A[i]
 * @return: The maximum size
 */
func backPack_W1(m int, A []int) int {
	n := len(A)
	maxRes := 0
	for i := 0; i < n-1; i++ {
		tempTotal := A[i]
		for j := i + 1; j < n; j++ {
			tempTotal += A[j]
			if tempTotal > m {
				tempTotal -= A[j]
			}
			maxRes = int(math.Max(float64(maxRes), float64(tempTotal)))
		}
	}
	return maxRes
}

type packParam struct {
	m        int
	A        []int
	maxValue int
}

// Time Limit Exceeded
func backPack_W2(m int, A []int) int {
	pack := &packParam{
		m:        m,
		A:        A,
		maxValue: 0,
	}
	pack.helper(0, 0, -1)
	return pack.maxValue
}

/**
 * @param idx: 传入idx是满足每个元素只使用一次
 */
func (pack *packParam) helper(ele int, sum int, idx int) {
	sum += ele
	if sum > pack.m {
		return
	}
	pack.maxValue = int(math.Max(float64(pack.maxValue), float64(sum)))
	for i := idx + 1; i < len(pack.A); i++ {
		pack.helper(pack.A[i], sum, i)
	}
	return
}

var maxValue = 0

// 还是超时：Time Limit Exceeded
func backPack_W3(m int, A []int) int {
	helper(0, 0, A, len(A), m)
	return maxValue
}
func helper(idx int, cw int, A []int, n int, m int) {
	if cw == m || idx == n {
		if cw > maxValue {
			maxValue = cw
		}
		return
	}
	helper(idx+1, cw, A, n, m) // 不加入当前物品
	if cw+A[idx] <= m {
		helper(idx+1, cw+A[idx], A, n, m) // 加入当前物品
	}
}

func backPack(m int, A []int) int {
	arrLen := len(A)
	dp := make([][]bool, arrLen)
	for i := 0; i < arrLen; i++ {
		dp[i] = make([]bool, m+1)
	}
	dp[0][0] = true
	if A[0] <= m {
		dp[0][A[0]] = true
	}

	for i := 1; i < arrLen; i++ {
		for j := 0; j <= m; j++ {
			if dp[i-1][j] {
				dp[i][j] = dp[i-1][j]
			}
		}
		for j := 0; j <= m-A[i]; j++ {
			if dp[i-1][j] {
				dp[i][j+A[i]] = true
			}
		}
	}
	for i := m; i >= 0; i-- {
		if dp[arrLen-1][i] {
			return i
		}
	}
	return 0
}
