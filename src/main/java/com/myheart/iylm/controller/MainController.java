package com.myheart.iylm.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myheart.iylm.service.impl.DrugServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

    @Autowired(required = false)
    DrugServiceImpl drugService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        //	    List
        model.addAttribute("drugSelect", drugService.selectDrug());
        System.out.println("test");
        return "home";
    }

}
