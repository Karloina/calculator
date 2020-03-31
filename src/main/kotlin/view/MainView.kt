package view

import app.Styles
import javafx.scene.input.MouseButton
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.paint.Color
import tornadofx.*

class MainView: View("Calculator") {

    override val root = vbox {
        textfield {
            filterInput { it.controlNewText.isInt() }
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
}
