package reducing_dishes

import "sort"

// 2020-12-06 13:34:36
// 1402.Reducing Dishes
// reducing-dishes

//A chef has collected data on the satisfaction level of his n dishes. Chef can
//cook any dish in 1 unit of time.
//
// Like-time coefficient of a dish is defined as the time taken to cook that dis
//h including previous dishes multiplied by its satisfaction level i.e. time[i]*sa
//tisfaction[i]
//
// Return the maximum sum of Like-time coefficient that the chef can obtain afte
//r dishes preparation.
//
// Dishes can be prepared in any order and the chef can discard some dishes to g
//et this maximum value.
//
//
// Example 1:
//
//
//Input: satisfaction = [-1,-8,0,5,-9]
//Output: 14
//Explanation: After Removing the second and last dish, the maximum total Like-t
//ime coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14). Each dish is prepared
//in one unit of time.
//
// Example 2:
//
//
//Input: satisfaction = [4,3,2]
//Output: 20
//Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
//
//
// Example 3:
//
//
//Input: satisfaction = [-1,-4,-5]
//Output: 0
//Explanation: People don't like the dishes. No dish is prepared.
//
//
// Example 4:
//
//
//Input: satisfaction = [-2,5,-1,0,3,-3]
//Output: 35
//
//
//
// Constraints:
//
//
// n == satisfaction.length
// 1 <= n <= 500
// -10^3 <= satisfaction[i] <= 10^3
// Related Topics Dynamic Programming
// 👍 327 👎 71


//leetcode submit region begin(Prohibit modification and deletion)
func maxSatisfaction_W1(satisfaction []int) int {
	sort.Ints(satisfaction)
	idx := 0
	for i := len(satisfaction)-1; i >= 0; i-- {
		if satisfaction[i] >= 0 {
			idx += 1
		}
	}
	res := 0
	for i := len(satisfaction)-1; i >= 0; i-- {
		if satisfaction[i] >= 0 {
			res += idx*satisfaction[i]
			idx -= 1
		}
	}
	return res
}

// 0-1价值背包问题，不同的地方是，这里的价值是变动的。
func maxSatisfaction(satisfaction []int) int {
	sort.Ints(satisfaction)
	res := 0
	changeValue := 0
	for i := len(satisfaction)-1; i >= 0; i-- {
		if res + satisfaction[i] + changeValue >= res {
			res = res + satisfaction[i] + changeValue
			changeValue += satisfaction[i]
		}
	}
	return res
}

func maxSatisfaction_A1(satisfaction []int) int {
	curSum := 0
	res := 0
	sort.SliceStable(satisfaction, func(i, j int)bool{return satisfaction[i]>satisfaction[j]})
	for _, val := range satisfaction {
		newRes := res + curSum + val
		if newRes < res {
			return res
		}
		res = newRes
		curSum += val
	}
	return res
}
//leetcode submit region end(Prohibit modification and deletion)

