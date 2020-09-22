package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tree: TreeComponent = Trunk(
            listOf(
                Branch(
                    listOf(Leaf(), Leaf(), Leaf()
            )), Branch(
                    listOf(Leaf(), Leaf(), Leaf()))
            )
        )

        Log.v("Composite", tree.getWeight().toString())
    }
}

interface TreeComponent {
    fun getWeight(): Int
}

class Trunk(private val components: List<TreeComponent>): TreeComponent {

    private val weight = 5

    override fun getWeight(): Int {
        return weight + components
            .map { it.getWeight() }
            .reduce { acc, treeComponent -> acc+treeComponent }
    }
}

class Branch(private val components: List<TreeComponent>): TreeComponent {

    private val weight = 3
    override fun getWeight(): Int {
        return weight + components
            .map { it.getWeight() }
            .reduce { acc, treeComponent -> acc+treeComponent }
    }
}

class Leaf: TreeComponent {
    private val weight = 1
    override fun getWeight(): Int {
        return weight
    }

}




