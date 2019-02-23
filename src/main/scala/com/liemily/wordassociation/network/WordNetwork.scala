package com.liemily.wordassociation.network

import scala.util.Random

class WordNetwork(val inputWeights: Array[Array[Double]], val outputWeights: Array[Array[Double]])

object WordNetwork {
  def apply(vocabSize: Int, projectionLayerSize: Int): WordNetwork = {
    val inputWeights = Array.fill(vocabSize, projectionLayerSize)(randomiseInputWeight(projectionLayerSize))
    val outputWeights = Array.ofDim[Double](vocabSize, projectionLayerSize)
    new WordNetwork(inputWeights, outputWeights)
  }

  def randomiseInputWeight(numLayers: Int): Double = standardise(Random.nextDouble, numLayers)
  // 0.5 is the median of the weight range permitted
  // i.e. half way between 0 and 1 provided by Random.nextDouble
  def standardise(weight: Double, numLayers: Int): Double = (weight - 0.5) / numLayers
}
