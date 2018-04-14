package fr.qdorme.perceptron.simple

import javafx.application.Application
import javafx.fxml.FXMLLoader.load
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage


class Run: Application(){

    override fun start(primaryStage: Stage?) {
        primaryStage?.title="Perceptron"
        val parent = load<AnchorPane>(javaClass.getResource("./ui/mainUi.fxml"))
        val scene = Scene(parent,600.0, 400.0)
        primaryStage?.scene = scene
        primaryStage?.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Run::class.java,*args)
        }
    }
}



