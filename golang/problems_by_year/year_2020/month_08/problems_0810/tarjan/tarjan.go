package tarjan

func Connections(graph map[interface{}][]interface{}) [][]interface{}  {
	g := &data{
		graph: graph,
		nodes: make([]node, 0, len(graph)),
		index: make(map[interface{}]int, len(graph)),
	}

	// 遍历顶点
	for v := range g.graph {
		if _, ok := g.index[v]; !ok {
			g.strongConnect(v)
		}
	}

	return g.output
}

type node struct {
	lowlink int
	stacked bool
}

type data struct {
	// 输入：map——key是一个顶点，value是一个集合，代表所有被指向的顶点。
	graph map[interface{}][]interface{}
	//
	nodes []node
	// 栈：存储每次遍历的强连通分量包含的顶点
	stack []interface{}

	index map[interface{}]int
	// 输出：以所在的强连通分量划分的顶点的集合【二维】
	output [][]interface{}
}

func (data *data) strongConnect(v interface{}) *node {
	index := len(data.nodes)
	data.index[v] = index
	data.stack = append(data.stack, v)
	data.nodes = append(data.nodes, node{lowlink: index, stacked: true})
	node := &data.nodes[index]

	// 遍历顶点对应的子节点
	for _, w := range data.graph[v] {
		i, seen := data.index[w]
		if !seen {
			n := data.strongConnect(w)
			if n.lowlink < node.lowlink {
				node.lowlink = n.lowlink
			}
		} else if data.nodes[i].stacked {
			// 父节点的index/dfn 小于
			if i < node.lowlink {
				node.lowlink = i
			}
		}
	}

	if node.lowlink == index {
		var vertices []interface{}
		i := len(data.stack) - 1
		for {
			// 从栈顶取出顶点
			w := data.stack[i]
			// 栈的下标
			stackIndex := data.index[w]
			data.nodes[stackIndex].stacked = false
			vertices = append(vertices, w)
			if stackIndex == index {
				break
			}
			i--
		}
		data.stack = data.stack[:i]
		data.output = append(data.output, vertices)
	}
	return node

}
