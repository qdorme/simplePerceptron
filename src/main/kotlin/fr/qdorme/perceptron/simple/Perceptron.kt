package fr.qdorme.perceptron.simple

import java.util.*
import kotlin.math.tanh

class Perceptron(numEntries : Int){
    private var weights = mutableListOf<Double>()

    init {
        for(i in 0..numEntries){
            weights.add(Random().nextDouble()*100)
        }
    }

    fun resetWeights(){
        for(i in 0 until weights.size){
            weights[i] = Random().nextDouble()*100
        }
    }

    fun activatedResult(entries : MutableList<Double>):Double{
        if (weights.size != entries.size +1) throw Exception("calcul of entries can't be done du to number of entries")
        entries.add(index = 0, element = -1.0)
        return tanh( weights.zip(entries, { w, e -> w * e }).sum())
    }


    fun correction(entries : MutableList<Double>,learningRate:Double, error : Double){
        entries.add(index = 0, element = -1.0)
        weights = weights.zip(entries,{w,e -> w+learningRate*error*e}).toMutableList()
    }



}