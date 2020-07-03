package view

import app.ONP
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Button
import tornadofx.*
import java.lang.Exception

class MainView: View("Calculator") {

    private var outputResult = SimpleStringProperty("")

    override val root = vbox {
        textfield(outputResult) {
//            filterInput { it.controlNewText.isNotEmpty() }
        }

        hbox {
            button {
                text = "+"
            }
            button {
                text = "-"
            }
            button {
                text = "*"
            }
            button {
                text = "/"
            }
        }
        hbox {
            button {
                text = "7"
            }
            button {
                text = "8"
            }
            button {
                text = "9"
            }
            button {
                text = "="
            }
        }
        hbox {
            button {
                text = "4"
            }
            button {
                text = "5"
            }
            button {
                text = "6"
            }
            button {
                text = "C"
            }
        }
        hbox {
            button {
                text = "1"
            }
            button {
                text = "2"
            }
            button {
                text = "3"
            }
            button {
                text = "0"
            }
        }
    }

    init {
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {
                addToOutput((b as Button).text)
            }
        }
    }

    private fun addToOutput(x: String) {
        if (x == "C") {
            outputResult.set("")
            return
        }

        if (x == "=") {
            try {
                val res = ONP.setResult(arrayOf((outputResult.get())))
                outputResult.set(res)
                return
            } catch (e : Exception) {
                outputResult.set("error")
                return
            }

        }
        outputResult.set(outputResult.value + x)
    }
}
