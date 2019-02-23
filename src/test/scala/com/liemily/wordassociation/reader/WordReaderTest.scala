package com.liemily.wordassociation.reader

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Emily Li on 22/02/2019.
  */
class WordReaderTest extends FlatSpec with Matchers {
  "Word reader" should "read words from file into a set" in {
    val words = new WordReader().read("src/test/resources/wordReaderTest.txt")
    words.size shouldBe 3
    words should contain theSameElementsAs Seq("a", "b", "c")
  }

  it should "return empty if no file found" in {
    val words = new WordReader().read("not a file")
    words.size shouldBe 0
  }
}