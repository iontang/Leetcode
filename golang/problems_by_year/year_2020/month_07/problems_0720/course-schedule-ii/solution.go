// package Course_Schedule_ll
package Course_Schedule_ll

func main() {
	var prerequisites = [][]int{
		{2,0},
		{2,1},
	}
	numCourses := 3
	var res = findOrder(numCourses, prerequisites)
	for _, val := range res {
		println(val)
	}

}

func findOrder(numCourses int, prerequisites [][]int) []int {
	outDegree  := make([]int, numCourses)
	graph := map[int][]int{}
	for _, preq := range prerequisites {
		var toTake = preq[0]
		var preRequisite = preq[1]
		outDegree[preRequisite]++
		if _, ok := graph[toTake]; !ok {
			graph[toTake] = []int{preRequisite}
		} else {
			graph[toTake] = append(graph[toTake], preRequisite)
		}
	}
	queue := []int{}
	for index, val := range outDegree {
		if val == 0 {
			// 往队列中加入的是索引，不是val
			queue = append(queue, index)
		}
	}
	var res []int
	for len(queue) != 0 {
		cur := queue[0]
		queue = queue[1:]
		res = append(res, cur)
		if v, ok := graph[cur]; ok {
			for _, preReq := range v {
				outDegree[preReq] -= 1
				if outDegree[preReq] == 0 {
					queue = append(queue, preReq)
				}
			}
		}
	}

	for _, v := range outDegree {
		if v != 0 {
			return []int{}
		}
	}
	reverse(res)
	return res
}

func reverse(s []int) {
	for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
		s[i], s[j] = s[j], s[i]
	}
}
