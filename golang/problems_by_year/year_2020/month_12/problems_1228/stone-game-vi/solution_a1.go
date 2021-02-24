package stone_game_vi

import "sort"

func stoneGameVI(aliceValues []int, bobValues []int) int {
	n := len(aliceValues)
	sumMap := make(map[int]int)
	for i := 0; i < n; i++ {
		sumMap[i] = aliceValues[i] + bobValues[i]
	}

	type mapPair struct {
		Key   int
		Value int
	}
	var pairList []mapPair
	for k, v := range sumMap {
		pairList = append(pairList, mapPair{k, v})
	}

	sort.Slice(pairList, func(i, j int) bool {
		return pairList[i].Value > pairList[j].Value
	})


	cnt := 0
	aliceSum, bobSum := 0, 0
	for _, i2 := range pairList {
		if cnt % 2 == 0 {
			aliceSum += aliceValues[i2.Key]
		} else {
			bobSum += bobValues[i2.Key]
		}
		cnt++
	}

	if aliceSum > bobSum {
		return 1
	} else if aliceSum < bobSum {
		return -1
	} else {
		return 0
	}

}