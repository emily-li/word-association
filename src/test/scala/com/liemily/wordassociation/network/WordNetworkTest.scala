package com.liemily.wordassociation.network

import org.scalatest.{FlatSpec, Matchers}

class WordNetworkTest extends FlatSpec with Matchers {
  "Network" should "instantiate randomised weights between 0 - 1" in {
    val (numRows, numCols) = (5, 2)

    val network1 = WordNetwork(numRows, numCols)
    val network2 = WordNetwork(numRows, numCols)

    network1.inputWeights shouldNot contain theSameElementsAs network2.inputWeights
    network1.inputWeights.length shouldBe numRows
    network1.inputWeights(0).length shouldBe numCols
    network1.inputWeights.foreach(_.foreach(
      weight => {
        weight should be > WordNetwork.standardise(0.0, numCols)
        weight should be < WordNetwork.standardise(1.0, numCols)
      }))
  }
}
