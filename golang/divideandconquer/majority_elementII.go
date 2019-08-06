package main

import "fmt"

func majorityElementII(nums []int) []int {

	length := len(nums)/3+1
	if nums == nil || len(nums) == 0 {
		return nil
	}

	num1, num2 := nums[0], nums[0]
	count1, count2 := 0, 0

	// first round to find candidates：获取候选集
	for _, v := range nums {
		if v == num1 {
			count1++
		} else if v == num2 {
			count2++
		} else if count1 == 0 {
			num1 = v
			count1 = 1
		} else if count2 == 0 {
			num2 = v
			count2 =1
		} else {
			// This condition is important, which means a pair out,
			// filtering a set of three elements out
			count1--
			count2--
		}
	}


	// 重新对数进行统计
	var result []int
	count1 = 0
	count2=0
	for _, v := range nums {
		// 此处必须是if else，否则 [1]这个测试用例无法通过
		if v == num1 {
			count1++
		} else if v == num2 {
			count2++
		}
	}
	if count1 >= length {
		result = append(result, num1)
	}
	if count2 >= length {
		result = append(result, num2)
	}

	return result
}



func majorityElement_II_A1(nums []int) []int {
	cand1, cand2, cnt1, cnt2 := 0, 0, 0, 0
	for _, n := range nums {
		if cand1 == n {
			cnt1++
		} else if cand2 == n {
			cnt2++
		} else if cnt1 == 0 {
			cand1, cnt1 = n, 1
		} else if cnt2 == 0 {
			cand2, cnt2 = n, 1
		} else {
			cnt1--
			cnt2--
		}
	}

	cnt1, cnt2 = 0, 0
	for _, n := range nums {
		if n == cand1 {
			cnt1++
		} else if n == cand2 {
			cnt2++
		}
	}

	ans := []int{}
	if cnt1 > len(nums)/3 {
		ans = append(ans, cand1)
	}
	if cnt2 > len(nums)/3 {
		ans = append(ans, cand2)
	}
	return ans
}

func main() {

	//s :=[] int {1}

	s1 := []int {2,2,1,3}

	fmt.Println(majorityElementII(s1))

}
