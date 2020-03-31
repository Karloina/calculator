package view

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.input.KeyEvent
import tornadofx.*

class MainView: View("Calculator") {

    override val root = vbox {
        textfield {
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

    @FXML
    var display: TextField = TextField("")

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

    private fun addToOutput(x: String) {//adding to display val but not showing on textfield
            display.text += x
    }
}
