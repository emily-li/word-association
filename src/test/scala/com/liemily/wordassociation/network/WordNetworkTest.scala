package com.liemily.wordassociation.network

import org.scalatest.{FlatSpec, Matchers}

class WordNetworkTest extends FlatSpec with Matchers {
  "Network" should "instantiate randomised weights between 0 - 1" in {
    val (numRows, numCols) = (5, 2)

    val network1 = WordNetwork(numRows, numCols)
    val network2 = WordNetwork(numRows, numCols)

    network1.weights shouldNot contain theSameElementsAs network2.weights
    network1.weights.length shouldBe numRows
    network1.weights(0).length shouldBe numCols
    network1.weights.foreach(_.foreach(
      weight => {
        weight should be > 0.0
        weight should be < 1.0
      }))
  }
}
