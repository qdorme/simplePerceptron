package fr.qdorme.perceptron.simple

class NeuronalNetwork{
    private val learningRate = 0.9
    val perceptron = Perceptron(2)

    val datas = mutableListOf<Data>()

    fun learn() {
        var increment = 0
        var error = 1.0
        while(error > 0.2){
            increment++
            error = 0.0
            datas.shuffle()
            datas.forEach {
                val e : Double = it.color - perceptron.activatedResult(mutableListOf(it.x,it.y))
                error += Math.abs(e)
                perceptron.correction(mutableListOf(it.x,it.y),learningRate,e)
            }
        }
        println(increment)
    }

    fun reset() {
        datas.clear()
        perceptron.resetWeights()
    }
}