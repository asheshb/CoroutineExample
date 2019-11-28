package com.example.coroutineexample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel(){


    fun fetchDataAndSave() {
        viewModelScope.launch {
            //Main Thread
            fetchFromNetworkAndSave()
        }
    }

    private suspend fun fetchFromNetworkAndSave() {
        withContext(Dispatchers.IO) {
            //Non Main Thread
            delay(500)
            //result = fetchFromNetwork()
            // save result
        }
        //some code in MainThread
    }

    //region
//    fun fetchDataAndSave() {
//        Log.d("MainViewModel", "Before launch(): " + Thread.currentThread().name)
//        viewModelScope.launch {
//            //Main Thread
//            Log.d("MainViewModel", "Before fetchFromNetworkAndSave(): " + Thread.currentThread().name)
//            fetchFromNetworkAndSave()
//            Log.d("MainViewModel", "After fetchFromNetworkAndSave(): " + Thread.currentThread().name)
//        }

////            viewModelScope.launch(Dispatchers.IO) {
////            //Main Thread
////            Log.d("MainViewModel", "Before fetchFromNetworkAndSave(): " + Thread.currentThread().name)
////            fetchFromNetworkAndSave()
////            Log.d("MainViewModel", "After fetchFromNetworkAndSave(): " + Thread.currentThread().name)
////        }

//    }
//
//    private suspend fun fetchFromNetworkAndSave() {
//        withContext(Dispatchers.IO) {
//            // Non Main Thread
//            Log.d(
//                "MainViewModel",
//                "Before delay() in fetchFromNetworkAndSave(): " + Thread.currentThread().name
//            )
//            delay(500)
////            result = fetchFromNetwork()
////            save result
//        }
//        Log.d(
//            "MainViewModel",
//            "After withContext() in fetchFromNetworkAndSave():" + Thread.currentThread().name
//        )
//    }
    //endregion

}