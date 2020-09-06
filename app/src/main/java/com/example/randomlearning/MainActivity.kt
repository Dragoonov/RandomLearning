package com.example.randomlearning

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.os.HandlerCompat
import androidx.core.os.postDelayed
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun printMessage(message: Any?) = Log.v(MainActivity::class.simpleName, message.toString())

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //handlersTesting()
        executorsHandlers()
    }

    private fun executorsHandlers() {
        val executorService = Executors.newFixedThreadPool(5)
        val mainThreadHandler = Handler(Looper.getMainLooper())
        val backgroundHandlerThread = HandlerThread("background thread")
        backgroundHandlerThread.start()
        val backgroundHandler = Handler(backgroundHandlerThread.looper)
        backgroundHandler.post {
            printMessage("Executing on a backgroundHandler:" + Thread.currentThread())
            mainThreadHandler.post {
                printMessage("And now switched to main (backgroundHandler): " + Thread.currentThread())
            }
            printMessage("And again on backgroundHandler:" + Thread.currentThread())
        }
        executorService.execute {
            printMessage("Executing on a " + Thread.currentThread())
            mainThreadHandler.post {
                printMessage("And now switched to main: " + Thread.currentThread())
            }
            printMessage("And again on " + Thread.currentThread())
        }
    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private fun handlersTesting() {
        val runnable = Runnable {
            Thread.sleep(250)
            printMessage("Created runnable, in a thread: " + Thread.currentThread().name)
        }
        val notLoopedThread = Thread(runnable,"NotLoopedThread")
        val looperThread = MyLooperThread()
        val handler = Handler()
        looperThread.start()
        notLoopedThread.start()
        Thread.sleep(200) // Wait for loopedThread to initialize looper
        handler.postDelayed(300) { printMessage("Printing delayed 300ms: " + Thread.currentThread())}
        looperThread.handler?.post { printMessage("2 + 2 is 42: " + Thread.currentThread()) }
        val handler2 = object : Handler(looperThread.handler?.looper!!) {
            override fun handleMessage(msg: Message) {
                printMessage(msg.obj as String + " in " + Thread.currentThread())
            }
        }
        val message = Message().also {
            it.obj = "Custom message"
        }
        handler2.dispatchMessage(message)
        handler2.sendMessage(message)
        handler2.post { printMessage("3 + 3 is 33: " + Thread.currentThread()) }

        val handlerThread = HandlerThread("Handler Thread")
        handlerThread.start()
        val handler3 = Handler(handlerThread.looper)
        handler3.post { printMessage("Inside a handlerThread!") }
        handlerThread.quitSafely()
        looperThread.handler!!.looper.quitSafely()
        Thread.sleep(500)
    }

    class MyLooperThread : Thread("My looped thread") {
        var handler: Handler? = null

        override fun run() {
            Looper.prepare()
            handler = object : Handler() {
                override fun handleMessage(msg: Message) {
                    printMessage("Message handled: $msg")
                }

                override fun dispatchMessage(msg: Message) {
                    printMessage("Message dispatched: $msg")
                    super.dispatchMessage(msg)
                }
            }
            Looper.loop()
        }
    }
}
