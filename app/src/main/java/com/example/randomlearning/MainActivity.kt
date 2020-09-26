package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val watcher = Watcher()
        GangMediator().apply {
            registerMember(watcher)
            registerMember(WindowShooter())
            registerMember(Robber())
            registerMember(BangThrower())
            registerMember((Intimidater()))
        }
        watcher.startAction()
    }
}
interface Mediator {
    fun registerMember(member: Member)
    fun startAction()
    fun onFinished()
}

class GangMediator: Mediator {
    private lateinit var robber: Robber
    private lateinit var watcher: Watcher
    private lateinit var bangThrower: BangThrower
    private lateinit var shooter: WindowShooter
    private lateinit var intimidater: Intimidater

    override fun registerMember(member: Member) {
        when(member) {
            is Robber -> robber = member.apply { registerMediator(this@GangMediator) }
            is Watcher -> watcher = member.apply { registerMediator(this@GangMediator) }
            is BangThrower -> bangThrower = member.apply { registerMediator(this@GangMediator) }
            is WindowShooter -> shooter = member.apply { registerMediator(this@GangMediator) }
            is Intimidater -> intimidater = member.apply { registerMediator(this@GangMediator) }
        }
    }

    override fun startAction() {
        bangThrower.throwBangGrenade()
        Thread.sleep(500)
        shooter.shootWindows()
        intimidater.intimidate()
        robber.robPeople()
    }

    override fun onFinished() {
        bangThrower.escape()
        shooter.escape()
        intimidater.escape()
        robber.escape()
        watcher.escape()
    }


}


interface GangMember {
    fun registerMediator(mediator: Mediator)
    fun escape()
}

abstract class Member: GangMember {
    protected lateinit var mediator: Mediator

    override fun registerMediator(mediator: Mediator) {
        this.mediator = mediator
    }
    override fun escape() {
        Log.d("Mediator", "${javaClass.simpleName} escaping!")
    }
}

class Watcher: Member() {
    fun startAction() {
        Thread.sleep(2000)
        Log.d("Mediator", "People are not focused, can start the action")
        mediator.startAction()
    }
}

class BangThrower: Member() {
    fun throwBangGrenade() {
        Log.d("Mediator", "Throwing the bang grenade through the window")
    }
}

class WindowShooter: Member() {
    fun shootWindows() {
        Log.d("Mediator", "People are baffled by the bang, can start shooting")
    }
}

class Intimidater: Member() {
    fun intimidate() {
        Log.d("Mediator", "Intimidating people with the gun")
    }
}

class Robber: Member() {
    fun robPeople() {
        Log.d("Mediator", "Robbing intimidated people")
        Thread.sleep(3000)
        finished()
    }

    private fun finished() {
        Log.d("Mediator", "Finished robbing, time to escape")
        mediator.onFinished()
    }
}


