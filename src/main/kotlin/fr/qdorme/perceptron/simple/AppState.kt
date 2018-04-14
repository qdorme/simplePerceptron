package fr.qdorme.perceptron.simple

data class Data(var color:Int, var x: Double, var y: Double)

class AppState{

    private val neuronalNetwork = NeuronalNetwork()
    var currentColor = 1
    private val data = mutableListOf<Data>()
    val grid = mutableListOf<Data>()

    fun addData(x: Double, y: Double){
        data.add(Data(currentColor,x,y))
    }

    fun calculate(){
        neuronalNetwork.reset()
        neuronalNetwork.datas.addAll(data)
        neuronalNetwork.learn()
    }

    fun makeGrid(width: Double, height: Double) {
        for( w in 1 .. width.toInt() step 10){
            for (h in 1 .. height.toInt() step 10){
                val calcul = neuronalNetwork.perceptron.activatedResult(mutableListOf(w.toDouble(), h.toDouble()))
                if(calcul < 0){
                    grid.add(Data(-1, w.toDouble(),h.toDouble()))
                }else{
                    grid.add(Data(1, w.toDouble(),h.toDouble()))
                }
            }
        }
    }

    fun clear() {
        data.clear()
        grid.clear()
    }

}