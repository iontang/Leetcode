package tarjan


import (
	"fmt"
	"reflect"
	"sort"
	"testing"
)

func TestTypeString(t *testing.T) {
	graph := make(map[interface{}][]interface{})
	graph["1"] = []interface{}{"2"}
	graph["2"] = []interface{}{"3"}
	graph["3"] = []interface{}{"1"}
	graph["4"] = []interface{}{"2", "3", "5"}
	graph["5"] = []interface{}{"4", "6"}
	graph["6"] = []interface{}{"3", "7"}
	graph["7"] = []interface{}{"6"}
	graph["8"] = []interface{}{"5", "7", "8"}

	o := Connections(graph)
	output := sortConnections(o)
	exp := [][]string{
		{"1", "2", "3"},
		{"6", "7"},
		{"4", "5"},
		{"8"},
	}
	if !reflect.DeepEqual(output, exp) {
		t.Fatalf("FAIL.\nexp=%v\ngot=%v\n", exp, output)
	}
}

func TestTypeInt(t *testing.T) {
	graph := make(map[interface{}][]interface{})
	graph[1] = []interface{}{2}
	graph[2] = []interface{}{3}
	graph[3] = []interface{}{1}
	graph[4] = []interface{}{2, 3, 5}
	graph[5] = []interface{}{4, 6}
	graph[6] = []interface{}{3, 7}
	graph[7] = []interface{}{6}
	graph[8] = []interface{}{5, 7, 8}

	o := Connections(graph)
	output := sortConnections(o)
	exp := [][]string{
		{"1", "2", "3"},
		{"6", "7"},
		{"4", "5"},
		{"8"},
	}
	if !reflect.DeepEqual(output, exp) {
		t.Fatalf("FAIL.\nexp=%v\ngot=%v\n", exp, output)
	}
}

func TestTypeMixed(t *testing.T) {
	graph := make(map[interface{}][]interface{})
	graph[1] = []interface{}{2}
	graph[2] = []interface{}{"3"}
	graph["3"] = []interface{}{1}
	graph[4] = []interface{}{2, "3", 5}
	graph[5] = []interface{}{4, "6"}
	graph["6"] = []interface{}{"3", 7}
	graph[7] = []interface{}{"6"}
	graph[8] = []interface{}{5, 7, 8}

	o := Connections(graph)
	output := sortConnections(o)
	exp := [][]string{
		{"1", "2", "3"},
		{"6", "7"},
		{"4", "5"},
		{"8"},
	}
	if !reflect.DeepEqual(output, exp) {
		t.Fatalf("FAIL.\nexp=%v\ngot=%v\n", exp, output)
	}
}

func TestEmptyGraph(t *testing.T) {
	graph := make(map[interface{}][]interface{})

	output := Connections(graph)
	if len(output) != 0 {
		t.FailNow()
	}
}

func TestSingleVertex(t *testing.T) {
	graph := make(map[interface{}][]interface{})
	graph["1"] = []interface{}{}

	o := Connections(graph)
	output := sortConnections(o)
	if output[0][0] != "1" {
		t.FailNow()
	}
}

func TestSingleVertexLoop(t *testing.T) {
	graph := make(map[interface{}][]interface{})
	graph["1"] = []interface{}{"1"}

	o := Connections(graph)
	output := sortConnections(o)
	if output[0][0] != "1" {
		t.FailNow()
	}
}

func TestMultipleVertexLoop(t *testing.T) {
	graph := make(map[interface{}][]interface{})
	graph["1"] = []interface{}{"2"}
	graph["2"] = []interface{}{"3"}
	graph["3"] = []interface{}{"1"}

	o := Connections(graph)
	output := sortConnections(o)
	if output[0][0] != "1" {
		t.FailNow()
	}
	if output[0][1] != "2" {
		t.FailNow()
	}
	if output[0][2] != "3" {
		t.FailNow()
	}
}

func ExampleConnections() {
	graph := make(map[interface{}][]interface{})
	graph["1"] = []interface{}{"2"}
	graph["2"] = []interface{}{"3"}
	graph["3"] = []interface{}{"1"}
	graph["4"] = []interface{}{"2", "3", "5"}
	graph["5"] = []interface{}{"4", "6"}
	graph["6"] = []interface{}{"3", "7"}
	graph["7"] = []interface{}{"6"}
	graph["8"] = []interface{}{"5", "7", "8"}

	o := Connections(graph)
	output := sortConnections(o)
	fmt.Println(output)

	// Output:
	// [[1 2 3] [6 7] [4 5] [8]]
}

func sortConnections(connections [][]interface{}) [][]string {
	out := make([][]string, 0, len(connections))
	for _, cons := range connections {
		slice := make([]string, 0, len(cons))
		for _, v := range cons {
			switch v := v.(type) {
			case string:
				slice = append(slice, v)
			case int:
				slice = append(slice, fmt.Sprintf("%d", v))
			default:
				panic(fmt.Errorf("invalid type [%T]", v))
			}
		}
		sort.Strings(slice)
		out = append(out, slice)
	}
	return out
}