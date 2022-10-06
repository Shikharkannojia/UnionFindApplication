package com.shikhar.unionfindapplication

import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.internal.artificialFrame
import java.lang.reflect.Array.get

class DSU(size: Int) {
    private var rank: IntArray
    private var parent: IntArray

    fun find(i: Int): Int {
        var r:Int = i
        while (parent[r] != r) {
            parent[r] = parent[parent[r]]
            r = parent[r]
        }
        return parent[r]
    }
    fun connected(i:Int, j:Int):Boolean{
        return find(i)==find(j)
    }


    fun union(i: Int, j: Int): Boolean {

        val p1 = find(i)
        val p2 = find(j)
        if (p1 == p2) { // found
            return false
        } else if (rank[p1] < rank[p2]) {
            parent[p1] = p2
        } else if (rank[p1] > rank[p1]) {
            parent[p2] = p1
        } else {
            parent[p2] = p1
            rank[p1]++
        }

        return true
    }

    init {
        parent = IntArray(size)
        for (i in 0 until size) {
            parent[i] = i
        }
        rank = IntArray(size)
    }
}