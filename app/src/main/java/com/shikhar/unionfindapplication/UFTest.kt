package com.shikhar.unionfindapplication

class UFTest {
    val ans:Boolean = false



    fun findRedundantConnection(edges: Array<IntArray>): IntArray? {
        val dsu = DSU(edges.size + 1)
        for (edge in edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge
            }
        }
        return intArrayOf(0, 0)
    }


}
