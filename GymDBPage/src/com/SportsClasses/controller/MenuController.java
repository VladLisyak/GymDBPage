package com.SportsClasses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Влад on 15.11.2014.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @RequestMapping("/showMenu")
    public String showMenu(){
           return "/menu";
       }
    @RequestMapping("/byePage")
    public String bye(){
           return "/bye";
       }
}
