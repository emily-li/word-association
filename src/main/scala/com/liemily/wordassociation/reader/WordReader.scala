package com.liemily.wordassociation.reader

import java.io.IOException
import java.nio.file.{Files, Paths}

import scala.collection.JavaConverters._
import scala.util.{Failure, Success, Try}

class WordReader {
  def read(file: String): Set[String] =
    Try {
      Files.lines(Paths.get(file))
        .iterator
        .asScala
        .map(_.split(" "))
        .toSet
        .flatten
    } match {
      case Failure(e) =>  new IOException(s"Failure reading file '$file'. Skipping and returning empty wordset.", e)
                            .printStackTrace()
                          Set.empty[String]
      case Success(s) =>  s
    }
}
