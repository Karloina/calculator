package view

import app.ONP
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Button
import javafx.scene.input.KeyEvent
import tornadofx.*

class MainView: View("Calculator") {

    private var outputResult = SimpleStringProperty("")

    override val root = vbox {
        textfield(outputResult) {
          //  filterInput { it.controlNewText.isNotEmpty()) }
        }

        hbox {
            button {
                text = "√"
            }
            button {
                text = "^2"
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
                text = "+"
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
                text = "-"
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
                text = "="
            }
        }
        hbox {
            button {
                text = "0"
            }
            button {
                text = "C"
            }
            button {
                text = "("
            }
            button {
                text = ")"
            }
        }
    }

    init {
        root.lookupAll(".button").forEach { b ->
            b.setOnMouseClicked {
                addToOutput((b as Button).text)
            }
        }

        root.addEventFilter(KeyEvent.KEY_TYPED) {
            addToOutput(it.character.toUpperCase().replace("\r", "="))
        }
    }

    private fun addToOutput(x: String) {
        if (x == "C") {
            outputResult.set("")
            return
        }

        if (x == "=") {
          //  ONP.main()
            //call compute function and set hashProperty to result
            return
        }
        outputResult.set(outputResult.value + x)
    }
}
