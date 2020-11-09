package main

import (
	"math"
)

func majorityElement(nums []int) int {
	f := int(math.Floor(float64(len(nums) / 2)))
	h := make(map[int]int)
	for _, v := range nums {
		if val, ok := h[v]; ok {
			h[v] = val + 1
		} else {
			h[v] = 1
		}
	}
	for k, v := range h {
		if v > f {
			return k
		}
	}
	return 0
}

func majorityElement_A1(nums []int) int {
	m := map[int]int{}
	for _, num := range nums {
		m[num] = m[num] + 1
	}
	h := len(nums) >> 1   // equal divide 2
	if len(nums)&1 == 1 { // 这一步有什么用？
		h++
	}
	for num, cnt := range m {
		if cnt >= h {
			return num
		}
	}
	return 0

}

func majorityElement_A2(nums []int) int {

	m := make(map[int]int)

	for _, v := range nums {
		m[v]++
	}

	halfLength := len(nums) / 2
	for i, v := range m {
		if v > halfLength {
			return i
		}
	}
	return 0
}

func main() {
}
