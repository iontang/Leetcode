package critical_connections_in_a_network

import "math"

type data struct {
	// 输入：map——key是一个顶点，value是一个集合，代表所有被指向的顶点。
	edges   map[interface{}][]interface{}
	DFN     []int
	LOW     []int
	visited []bool
	t       int
	// 输出：以所在的强连通分量划分的顶点的集合【二维】
	ans [][]int
}

/**
[[0,1],[1,2],[2,0],[1,3]]
*/
func criticalConnections(n int, connections [][]int) [][]int {
	graph := make(map[interface{}][]interface{})
	for _, arr := range connections {
		n1 := arr[0]
		n2 := arr[1]
		graph[n1] = append(graph[n1], n2)
		graph[n2] = append(graph[n2], n1)
	}

	g := &data{
		edges:   graph,
		DFN:     make([]int, n),
		LOW:     make([]int, n),
		visited: make([]bool, n),
		t:       0,
		ans:     nil,
	}
	g.tarjan(0, -1)
	return g.ans
}

func (data *data) tarjan(cur int, pre int) {
	data.t++
	data.DFN[cur] = data.t
	data.LOW[cur] = data.t
	data.visited[cur] = true
	for _, subNode := range data.edges[cur] {
		temp := subNode.(int)
		if temp == pre {
			continue
		}
		if !data.visited[temp] {
			data.tarjan(temp, cur)
			data.LOW[cur] = int(math.Min(float64(data.LOW[cur]), float64(data.LOW[temp])))
			if data.LOW[temp] > data.DFN[cur] {
				//var lst []int
				//lst = append(lst, cur)
				//lst = append(lst, temp)
				//data.ans = append(data.ans, lst)
				println(cur, temp)
				data.ans = append(data.ans, []int{cur, temp})
			} else {
				data.LOW[cur] = int(math.Min(float64(data.LOW[cur]), float64(data.DFN[temp])))
			}
		}
	}

}
