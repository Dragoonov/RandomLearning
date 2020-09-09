package com.example.randomlearning

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coroutineWorker()
    }

    fun coroutineWorker() {
        val workManager = WorkManager.getInstance(this)
        workManager.getWorkInfosByTagLiveData("TAG").observe(this, Observer {
            Log.v("Worker", it.toString())
            if (it[0].state.isFinished) {
                it[0].outputData.getInt("key",0)
            }
        })
        val request1 = OneTimeWorkRequestBuilder<ExampleCoroutineWorker>()
            .setInputData(Data.Builder().putInt("key", 15).build())
            .setConstraints(Constraints.Builder().setRequiresCharging(true).build())
            .build()
        workManager.enqueue(request1)
    }

    fun periodicWorker() {
        val workManager = WorkManager.getInstance(this)
        workManager.getWorkInfosByTagLiveData("TAG").observe(this, Observer {
            Log.v("Worker", it.toString())
            if (it[0].state.isFinished) {
                it[0].outputData.getInt("key",0)
            }
        })
        val request1 = PeriodicWorkRequestBuilder<ExampleWorker>(5,TimeUnit.SECONDS)
            .setInputData(Data.Builder().putInt("key", 15).build())
            .setConstraints(Constraints.Builder().setRequiresCharging(true).build())
            .build()
        val request2 = OneTimeWorkRequestBuilder<ExampleWorker>()
            .addTag("TAG")
            .setInputData(Data.Builder().putInt("key", 15).build())
            .build()
        //val request2 = OneTimeWorkRequest.from(ExampleWorker::class.java)
        val request3 = OneTimeWorkRequest.from(ExampleWorker::class.java)
        workManager.enqueue(request1)
        //workManager.cancelAllWork()
    }

    fun oneTimeWorker() {
        val workManager = WorkManager.getInstance(this)
        workManager.getWorkInfosByTagLiveData("TAG").observe(this, Observer {
            Log.v("Worker", it.toString())
            if (it[0].state.isFinished) {
                it[0].outputData.getInt("key",0)
            }
        })
        val request1 = OneTimeWorkRequestBuilder<ExampleWorker>()
            .setInputData(Data.Builder().putInt("key", 15).build())
            .setConstraints(Constraints.Builder().setRequiresCharging(true).build())
            .build()
        val request2 = OneTimeWorkRequestBuilder<ExampleWorker>()
            .addTag("TAG")
            .setInputData(Data.Builder().putInt("key", 15).build())
            .build()
        //val request2 = OneTimeWorkRequest.from(ExampleWorker::class.java)
        val request3 = OneTimeWorkRequest.from(ExampleWorker::class.java)
        workManager
            .beginUniqueWork("name",ExistingWorkPolicy.REPLACE, request1)
            .then(request2)
            .then(request3)
            .enqueue()
        //workManager.cancelAllWork()
    }

}

class ExampleWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val result = inputData.getInt("key", 0) + 1
        Log.v("Worker", "Doing some work on a thread: " + Thread.currentThread() + ", value: " + result)
        return Result.success(Data.Builder().putInt("key", result).build())
    }
}

class ExampleCoroutineWorker(context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        val result = inputData.getInt("key", 0) + 1
        Log.v("Worker", "Doing some work on a thread: " + Thread.currentThread() + ", value: " + result)
        return Result.success(Data.Builder().putInt("key", result).build())
    }
}
