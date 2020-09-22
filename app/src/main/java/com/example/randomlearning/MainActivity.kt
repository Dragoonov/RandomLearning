package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomlearning.predators.Pantera
import com.example.randomlearning.predators.PawWithClaws
import com.example.randomlearning.predators.Tarantula
import com.example.randomlearning.predators.VenomFangs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pantera = Pantera(PawWithClaws())
        val venomPantera = Pantera(VenomFangs())
        val spider = Tarantula()

        pantera.fight()
        pantera.kill()

        venomPantera.fight()
        venomPantera.kill()

        spider.fight()
        spider.kill()

    }
}




