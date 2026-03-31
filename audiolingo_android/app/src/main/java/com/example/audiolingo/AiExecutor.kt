import java.util.concurrent.Executors

val executor = Executors.newFixedThreadPool(2)

fun run(task: () -> Unit) {
    executor.execute(task)
}