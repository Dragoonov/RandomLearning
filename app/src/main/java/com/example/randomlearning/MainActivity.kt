package com.example.randomlearning

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val workManager = WorkManager.getInstance(this)
        val request1 = OneTimeWorkRequestBuilder<ExampleWorker>().setInputData(Data.Builder().putInt("key", 15).build()).build()
        val request2 = OneTimeWorkRequestBuilder<ExampleWorker>().setInputData(Data.Builder().putInt("key", 15).build()).build()
        //val request2 = OneTimeWorkRequest.from(ExampleWorker::class.java)
        val request3 = OneTimeWorkRequest.from(ExampleWorker::class.java)
        workManager.beginUniqueWork("name",ExistingWorkPolicy.REPLACE, request1).then(request2).then(request3).enqueue()
    }
}

class ExampleWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val result = inputData.getInt("key", 0) + 1
        Log.v("Worker", "Doing some work on a thread: " + Thread.currentThread() + ", value: " + result)
        return Result.success(Data.Builder().putInt("key", result).build())
    }
}
