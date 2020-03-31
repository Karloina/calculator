package app
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch
import view.MainView

class MainApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        stage.isResizable = false
        super.start(stage)
    }
}

val output = "";
val symbols = mapOf("(" to 0, ")" to 0, "+" to 1, "-" to 1, "*" to 2, "/" to 2, "^" to 3, "sqrt" to 3, "=" to 4)



fun main(args: Array<String>) {
    launch<MainApp>(args)

  /*  val input = Scanner(System.`in`)
    println("chose int")
    val T = input.nextLine()
    println("The oldest is: $T")*/
}
