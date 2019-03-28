package com.lnson.temp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("doc")
public class DocumentController {

    @RequestMapping(value = "/api", method = {RequestMethod.GET})
    public ModelAndView apiAction() {
        return new ModelAndView("webapi/testapi");
    }

}
