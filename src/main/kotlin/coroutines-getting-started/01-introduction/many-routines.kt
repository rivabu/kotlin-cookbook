import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger


const val num_tasks = 1_000
const val loops = 5
const val wait_ms = 10L

fun main() = runBlocking { // blocks the current thread
    println("Starting")

    val result = AtomicInteger()
    val jobs = mutableListOf<Job>()

    for (i in 1..num_tasks) {
        jobs.add(launch(Dispatchers.IO) {
            test(result)
        })
    }
    println("jobs: ${jobs.size}")
    jobs.forEach {it.join()}

    println(result.get())

}

private suspend fun test(result: AtomicInteger) {
    for (x in 1..loops) {
        delay(wait_ms)
    }
    result.getAndIncrement()
}