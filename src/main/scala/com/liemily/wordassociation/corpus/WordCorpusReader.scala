package com.liemily.wordassociation.corpus

import java.nio.file.{Files, Paths}

import scala.collection.JavaConverters._

object WordCorpusReader {
  /**
    * Reads lines from a file. Each line is expected to be a sentence with no punctuation excepting spaces at the moment
    * @param file File path
    * @return Word corpus with sentences from file and distinct set of words as vocabulary
    */
  def buildCorpus(file: String): WordCorpus = {
    val sentences = Files.lines(Paths.get(file))
      .iterator
      .asScala
      .map(_.split(" "))
      .toArray
    val vocab = sentences.flatten.toSet
    WordCorpus(sentences, vocab)
  }
}

case class WordCorpus(sentences: Array[Array[String]], vocab: Set[String])
