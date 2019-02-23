package com.liemily.wordassociation.network

import scala.util.Random

case class WordNetwork(inputWeights: Array[Array[Double]])
object WordNetwork {
  def apply(vocabSize: Int, numLayers: Int): WordNetwork = {
    val inputWeights = Array.fill(vocabSize, numLayers)(randomiseInputWeight(numLayers))
    new WordNetwork(inputWeights)
  }

  def randomiseInputWeight(numLayers: Int): Double = standardise(Random.nextDouble, numLayers)
  def standardise(weight: Double, numLayers: Int): Double = (weight - 0.5) / numLayers
}
