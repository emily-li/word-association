package com.liemily.wordassociation.network

import scala.util.Random

case class WordNetwork(weights: Array[Array[Double]])
object WordNetwork {
  def apply(vocabSize: Int, numLayers: Int): WordNetwork = {
    val weights = Array.fill(vocabSize, numLayers)(Random.nextDouble)
    new WordNetwork(weights)
  }
}
