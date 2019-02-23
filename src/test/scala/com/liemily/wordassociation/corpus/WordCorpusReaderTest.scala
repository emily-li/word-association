package com.liemily.wordassociation.corpus

import org.scalatest.{FlatSpec, Matchers}

class WordCorpusReaderTest extends FlatSpec with Matchers {
  val corpus: WordCorpus = WordCorpusReader.buildCorpus("src/test/resources/wordReaderTest.txt")

  "Word reader" should "read lines from a file" in {
    corpus.sentences.length shouldBe 2
    corpus.sentences(0).length shouldBe 4
    corpus.sentences(1).length shouldBe 6
  }

  it should "extract distinct set of words as vocabulary" in {
    corpus.vocab should contain theSameElementsAs Seq("a", "b", "c", "d", "e", "f")
  }
}