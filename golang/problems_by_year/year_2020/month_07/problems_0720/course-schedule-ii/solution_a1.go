package Course_Schedule_ll



func findOrder_A1(numCourses int, prerequisites [][]int) []int {
	g := &Graph{
		sorted: make([]int, 0),
		unvisited: make([]int, numCourses),
		state: make(map[int]int),
		adjacent: make(map[int][]int),
		isDAG: true,
	}

	for i := 0; i < numCourses; i++ {
		g.unvisited[i] = i
		g.state[i] = _unvisited
		g.adjacent[i] = make([]int, 0)
	}

	for _, edge := range prerequisites {
		g.adjacent[edge[1]] = append(g.adjacent[edge[1]], edge[0])
	}

	for _, node := range g.unvisited {
		if g.isDAG == false {
			break
		}

		if g.state[node] == _unvisited {
			g.visit(node)
		}
	}

	if g.isDAG {
		for i := 0; i < numCourses/2; i++ {
			g.sorted[i], g.sorted[numCourses-i-1] = g.sorted[numCourses-i-1], g.sorted[i]
		}
		return g.sorted
	}

	return []int{}
}

const (
	_unvisited = iota
	_visiting
	_visited
)

type Graph struct {
	// final result
	sorted []int
	// unvisited vertices
	unvisited []int
	// 0 - unvisited, 1 - visiting, 2 - visited
	state map[int]int
	// adjacency list
	adjacent map[int][]int
	isDAG bool
}

func (g *Graph) visit(node int) {
	if g.state[node] == _visited || g.isDAG == false {
		return
	}

	if g.state[node] == _visiting {
		g.isDAG = false
		return
	}

	g.state[node] = _visiting

	for _, adjNode := range g.adjacent[node]{
		if g.isDAG == false {
			break
		}
		g.visit(adjNode)
	}

	g.state[node] = _visited
	g.sorted = append(g.sorted, node)
}