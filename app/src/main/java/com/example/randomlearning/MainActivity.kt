package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.randomlearning.oneversion.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val visitor = Visitor()
        val visitor2 = Visitor(moneyAmount = 4999)
        val theOffice = QuestionHandler().apply {
            linkWith(BossApprovalHandler())
            .linkWith(GrandmaApprovalHandler())
            .linkWith(MoneyAmountHandler())
            .linkWith(LandBuyableHandler())
        }

        theOffice.handle(visitor)

        theOffice.handle(visitor2)
    }
}


