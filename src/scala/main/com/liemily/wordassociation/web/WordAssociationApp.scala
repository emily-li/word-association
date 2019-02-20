package com.liemily.wordassociation.web

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WordAssociationApp
object WordAssociationApp {
  def main(args: Array[String]): Unit =
    SpringApplication.run(classOf[WordAssociationApp], args: _*)
}
