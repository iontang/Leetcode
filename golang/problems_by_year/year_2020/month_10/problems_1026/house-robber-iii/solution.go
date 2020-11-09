package house_robber_iii

import "math"

// 2020-11-01 21:18:56
// 337.House Robber III
// house-robber-iii

//The thief has found himself a new place for his thievery again. There is only
//one entrance to this area, called the "root." Besides the root, each house has o
//ne and only one parent house. After a tour, the smart thief realized that "all h
//ouses in this place forms a binary tree". It will automatically contact the poli
//ce if two directly-linked houses were broken into on the same night.
//
// Determine the maximum amount of money the thief can rob tonight without alert
//ing the police.
//
// Example 1:
//
//
//Input: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//Output: 7
//Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//
// Example 2:
//
//
//Input: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//Output: 9
//Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// Related Topics Tree Depth-first Search
// 👍 3211 👎 59

//leetcode submit region begin(Prohibit modification and deletion)
func rob(root *TreeNode) int {
	res := dp(root)
	return int(math.Max(float64(res[0]), float64(res[1])))
}

func dp(root *TreeNode) []int {
	if root == nil {
		return []int{0, 0}
	}
	left := dp(root.Left)
	right := dp(root.Right)
	rob := root.Val + left[0] + right[0]
	notRob := int(math.Max(float64(left[0]), float64(left[1])) + math.Max(float64(right[0]), float64(right[1])))
	return []int{notRob, rob}
}

/**
* Definition for a binary tree node.
* type TreeNode struct {
*     Val int
*     Left *TreeNode
*     Right *TreeNode
* }
 */
// [2,1,3,null,4] error
// 不是按层遍历就能解决的。
func rob_w1(root *TreeNode) int {
	if root == nil {
		return 0
	}
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

	prevMax := 0
	currMax := 0
	for len(queue) > 0 {
		size := len(queue)
		var sum int
		for i := 0; i < size; i++ {
			curNode := queue[i]
			sum += curNode.Val
			if curNode.Left != nil {
				queue = append(queue, curNode.Left)
			}
			if curNode.Right != nil {
				queue = append(queue, curNode.Right)
			}
		}
		temp := currMax
		if prevMax+sum > currMax {
			currMax = prevMax + sum
		}
		prevMax = temp
		queue = queue[size:]
	}
	return currMax
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//leetcode submit region end(Prohibit modification and deletion)
