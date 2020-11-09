package critical_connections_in_a_network

import "math"

func criticalConnections_A2(n int, connections [][]int) [][]int {
	net := connectNetwork(n, connections)
	timer := 0
	visited := make([]bool, n)
	tin := make([]int, n)
	low := make([]int, n)
	result := &[][]int{}

	for i := 0; i < n; i++ {
		if !visited[i] {
			dfs(i, -1, timer, tin, low, visited, net, result)
		}
	}

	return (*result)
}

func connectNetwork(n int, connections [][]int) [][]int {
	net := make([][]int, n)
	for i := 0; i < len(connections); i++ {
		from := connections[i][0]
		to := connections[i][1]

		net[from] = append(net[from], to)
		net[to] = append(net[to], from)
	}
	return net
}

func dfs(at, parent int, timer int, tin []int, low []int, visited []bool, connections [][]int, result *[][]int) {
	visited[at] = true
	timer++
	tin[at], low[at] = timer, timer

	for _, to := range connections[at] {
		if to == parent {
			continue
		}
		if !visited[to] {
			dfs(to, at, timer, tin, low, visited, connections, result)
			low[at] = int(math.Min(float64(low[at]), float64(low[to])))
			if tin[at] < low[to] {
				(*result) = append((*result), []int{at, to})
			}
		} else {
			low[at] = int(math.Min(float64(low[at]), float64(tin[to])))
		}
	}
}
