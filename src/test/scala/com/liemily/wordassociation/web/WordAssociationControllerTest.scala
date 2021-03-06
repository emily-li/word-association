package com.liemily.wordassociation.web

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestContextManager
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.{MockMvcResultHandlers, MockMvcResultMatchers}

@RunWith(classOf[SpringRunner])
@WebMvcTest
class WordAssociationControllerTest extends FlatSpec {
  new TestContextManager(getClass).prepareTestInstance(this)

  @Autowired var mockMvc: MockMvc = _

  "POST /wordassociation" should "return 200 with a word when posted a word" in {
    mockMvc
      .perform(
        MockMvcRequestBuilders.post("/wordassociation")
          .contentType(MediaType.APPLICATION_JSON)
          .param("word", "i need"))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status.isOk)
      .andExpect(MockMvcResultMatchers.content.string("help"))
  }

  it should "return 400 when no word is posted" in {
    mockMvc
      .perform(MockMvcRequestBuilders.post("/wordassociation"))
      .andDo(MockMvcResultHandlers.print())
      .andExpect(MockMvcResultMatchers.status.isBadRequest)
  }
}
