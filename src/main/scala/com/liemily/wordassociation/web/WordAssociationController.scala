package com.liemily.wordassociation.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, ResponseBody}

@Controller
class WordAssociationController {
  @RequestMapping(value = Array("/wordassociation"), method = Array(RequestMethod.POST))
  @ResponseBody
  def getAssociatedWord(@RequestParam(required = true) word: String) = "help"
}
