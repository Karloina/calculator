package app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val text by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

      text {
          padding = box(5.px)
          fontSize = 20.px
          fontWeight = FontWeight.BOLD
      }

        textField {
            padding = box(10.px)
            minWidth = 100.px
            prefWidth = 260.px
            minHeight = 50.px
            prefHeight = 50.px
        }

        button {
            minWidth = 70.px
            prefWidth = 70.px
            minHeight = 70.px
            prefHeight = 70.px
        }
    }
}