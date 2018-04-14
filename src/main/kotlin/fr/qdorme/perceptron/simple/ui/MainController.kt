package fr.qdorme.perceptron.simple.ui

import fr.qdorme.perceptron.simple.AppState
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.control.RadioButton
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color

class MainController{

    @FXML
    lateinit var myCanvas : Canvas

    private val appState = AppState()

    @FXML
    fun initialize(){
        val graphics = myCanvas?.graphicsContext2D
        graphics?.fill=Color.WHITE
        graphics?.fillRect(0.0,0.0,myCanvas.width,myCanvas.height)
    }

    fun addData(mouseEvent: MouseEvent) {
        appState.addData(mouseEvent.x,mouseEvent.y)
        val graphics = myCanvas?.graphicsContext2D
        when(appState.currentColor){
            1 -> graphics.fill=Color.GREEN
            -1 -> graphics.fill=Color.RED
        }
        graphics.fillOval(mouseEvent.x-5,mouseEvent.y-5,10.0,10.0)

    }

    fun selectColor(actionEvent: ActionEvent) {
        val radioButton : RadioButton = actionEvent.source as RadioButton
        when(radioButton.id){
            "greenChoice" -> appState.currentColor = 1
            "redChoice" -> appState.currentColor = -1
        }
    }

    fun runPercepton(actionEvent: ActionEvent) {
        appState.calculate()

        appState.makeGrid(myCanvas.width, myCanvas.height)
        val graphics = myCanvas.graphicsContext2D
        appState.grid.forEach { g ->
            when(g.color){
                1 -> graphics.fill=Color.LIGHTGREEN
                -1 -> graphics.fill=Color.LIGHTPINK
            }
            graphics.fillOval(g.x-2,g.y-2,4.0,4.0)
        }

    }

    fun clear(actionEvent: ActionEvent) {
        initialize()
        appState.clear()
    }

}