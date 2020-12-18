package com.maxxxwk.threads

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock


var counter = 0
val lock = ReentrantLock()


fun increaseCounter(){
    lock.lock()
    counter++
    lock.unlock()
}
fun main() {
    val executor = Executors.newScheduledThreadPool(5)
    executor.scheduleWithFixedDelay(::increaseCounter, 10, 10, TimeUnit.MILLISECONDS)
    executor.scheduleWithFixedDelay(::increaseCounter, 10, 10, TimeUnit.MILLISECONDS)
    executor.scheduleWithFixedDelay(::increaseCounter, 10, 10, TimeUnit.MILLISECONDS)
    executor.scheduleWithFixedDelay(::increaseCounter, 10, 10, TimeUnit.MILLISECONDS)
    executor.scheduleWithFixedDelay({ println(counter) }, 1000, 1000, TimeUnit.MILLISECONDS)
    TimeUnit.SECONDS.sleep(10)
    executor.shutdown()
    println(counter)
}