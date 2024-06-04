package com.kognitivist.androidlessons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.random.Random

@Composable
fun RaceCondition() {

    val state = remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val mutex = remember { Mutex() }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                scope.launch {
                    delay(getRandomNumber().toLong())
                    state.intValue = 1
                }
                scope.launch {
                    delay(getRandomNumber().toLong())
                    state.intValue = 2
                }
            },
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(text = "ChangeState")
        }
        Text(
            text = state.intValue.toString(),
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

fun getRandomNumber(): Int {
    return Random.nextInt(1, 4)
}