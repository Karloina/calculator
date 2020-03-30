package app
import tornadofx.App
import tornadofx.launch
import view.MainView
import java.util.*

class MainApp: App(MainView::class, Styles::class)

val outpu = "";
val symbols = mapOf("(" to 0, ")" to 0, "+" to 1, "-" to 1, "*" to 2, "/" to 2, "^" to 3, "sqrt" to 3, "=" to 4)


fun main(args: Array<String>) {
    launch<MainApp>(args)
  /*  val input = Scanner(System.`in`)
    println("chose int")
    val T = input.nextLine()
    println("The oldest is: $T")*/
}