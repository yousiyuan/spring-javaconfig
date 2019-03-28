package com.lnson.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("home/index");
    }

}
