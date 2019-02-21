package com.liemily.wordassociation.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}

@Controller
class WordAssociationController {
  @RequestMapping(Array("/wordassociation"))
  @ResponseBody
  def blah = "help"
}
