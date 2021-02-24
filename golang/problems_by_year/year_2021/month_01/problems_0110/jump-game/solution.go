package jump_game
// 2021-01-16 16:05:00
// 55.Jump Game
// jump-game

//Given an array of non-negative integers nums, you are initially positioned at
//the first index of the array.
//
// Each element in the array represents your maximum jump length at that positio
//n.
//
// Determine if you are able to reach the last index.
//
//
// Example 1:
//
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics Array Greedy
// 👍 5547 👎 389


//leetcode submit region begin(Prohibit modification and deletion)
//
func canJump(nums []int) bool {
	n := len(nums)
	curMax := nums[0]
	for i := 1; i < n; i++ {
		if curMax >= i {
			if curMax < nums[i] + i  {
				curMax = nums[i] + i
			}
		}
	}
	return curMax >= n-1
}
//leetcode submit region end(Prohibit modification and deletion)

