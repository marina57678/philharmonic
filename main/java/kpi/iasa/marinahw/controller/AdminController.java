package kpi.iasa.marinahw.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String getUsers(Model model)
{
    return "admin/index";
}

}
