package critical_connections_in_a_network

import (
	"testing"
)

func TestTypeString(t *testing.T) {
	criticalConnections(4, [][]int{{0, 1}, {1, 2}, {2, 0}, {1, 3}})
}
