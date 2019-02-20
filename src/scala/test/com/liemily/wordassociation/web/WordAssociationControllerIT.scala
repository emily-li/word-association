package com.liemily.wordassociation.web

import org.scalatest.FlatSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestContextManager
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
class WordAssociationControllerIT extends FlatSpec {
  new TestContextManager(getClass).prepareTestInstance(this)

  @Autowired var mockMvc: MockMvc = _

  "POST /wordassociation" should "return 200 with a word" in {
    assert(mockMvc != null)
  }
}
