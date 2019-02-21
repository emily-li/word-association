package com.liemily.wordassociation.web

import org.scalatest.FlatSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestContextManager
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.{MockMvcResultHandlers, MockMvcResultMatchers}

@SpringBootTest
@AutoConfigureMockMvc
class WordAssociationControllerTest extends FlatSpec {
  new TestContextManager(getClass).prepareTestInstance(this)

  @Autowired var mockMvc: MockMvc = _

  "POST /wordassociation" should "return 200 with a word" in {
    mockMvc
      .perform(MockMvcRequestBuilders.get("/wordassociation"))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status.isOk)
  }
}
