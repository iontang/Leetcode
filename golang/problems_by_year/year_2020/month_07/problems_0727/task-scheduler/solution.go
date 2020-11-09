package main

import "sort"

func main() {

}

func leastInterval(tasks []byte, n int) int {
	charCount := make([]int, 26)
	for _, ch := range tasks {
		charCount[ch-'A']++
	}

	sort.Ints(charCount)
	maxVal := charCount[25] - 1
	idleCount := maxVal * n
	for _, v := range charCount[:25] {
		idleCount -= min(v, maxVal)
	}
	if idleCount > 0 {
		return idleCount + len(tasks)
	}
	return len(tasks)
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
