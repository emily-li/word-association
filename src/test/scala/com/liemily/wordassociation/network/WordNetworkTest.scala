package com.liemily.wordassociation.network

import org.scalatest.{FlatSpec, Matchers}

class WordNetworkTest extends FlatSpec with Matchers {
  val (numRows, numCols) = (5, 2)
  val network = WordNetwork(numRows, numCols)

  "Network" should "instantiate randomised input weights between 0 - 1" in {
    val network2 = WordNetwork(numRows, numCols)

    network.inputWeights shouldNot contain theSameElementsAs network2.inputWeights
    network.inputWeights.length shouldBe numRows
    network.inputWeights.foreach(_.length shouldBe numCols)
    network.inputWeights.flatten.foreach {
      weight =>
        weight should be > WordNetwork.standardise(0.0, numCols)
        weight should be < WordNetwork.standardise(1.0, numCols)
    }
  }

  it should "instantiate output weights as 0" in {
    network.outputWeights.length shouldBe numRows
    network.outputWeights.foreach(_.length shouldBe numCols)
    network.outputWeights.flatten.foreach(_ shouldBe 0)
  }
}
