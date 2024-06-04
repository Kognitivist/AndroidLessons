package com.kognitivist.androidlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaceCondition()
        }
    }
}

@Composable
fun ChangeUiStateScreen(){

    val list = remember { mutableStateListOf<Int>() }
    val scope = rememberCoroutineScope()
    val mutex = remember { Mutex() }

    LaunchedEffect(key1 = true) {
        launch {
            mutex.withLock {
                for (i in 1..10){
                    delay(1000)
                    list.add(i)
                }
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = {
            scope.launch {
                mutex.withLock {
                    list.add(0)
                }
            }
        }) {
            Text(text = "AddItem")
        }
        list.forEach {
            Text(text = it.toString())
        }
    }
}

