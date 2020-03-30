package view

import app.Styles
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.paint.Color
import tornadofx.*

class MainView: View("Calculator") {
    fun numbers() = listOf("7", "8", "9",
                           "4", "5", "6",
                           "1", "2", "3",
                           "0", "(", ")");

    fun operands() = listOf("^", "sqrt",
                            "*", "%",
                            "+", "-",
                            "CE", "=");
    override val root = hbox {
        vbox {
            label(title) {
                addClass(Styles.heading)
            }
            group {
                hbox {
                    label("Type:") {
                        addClass(Styles.text)
                    }
                    textfield {
                        filterInput { it.controlNewText.isInt() }
                    }
                }
            }

            hbox {
                datagrid(numbers()){
                    singleSelect
                    maxRows = 4
                    maxCellsInRow = 3
                    cellFormat {
                        graphic = stackpane {
                            circle(radius = 30.0) {
                                fill = Color.DARKGRAY
                            }
                            label(it)
                        }
                    }
                }
                datagrid(operands()){
                    style {
                        backgroundColor += Color.TRANSPARENT
                    }
                    singleSelect
                    maxRows = 3
                    maxCellsInRow = 2
                    scrollpane { isDisable = true }
                    cellFormat {
                        graphic = stackpane {
                            circle (radius = 30.0) {
                                fill = Color.ROSYBROWN
                                style {
                                    backgroundColor += Color.TRANSPARENT
                                }
                            }
                            label(it)
                        }
                    }
                }
            }

        }
    }
}
