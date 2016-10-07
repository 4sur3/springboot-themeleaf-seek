package com.jmbplabs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by joan on 10/7/16.
 */
@Controller
public class MainController {

    /**
     * Get all the requests for all the methods
     * @return
     */
    @RequestMapping("/")
    public String toIndex(){
        return "home";
    }

    /**
     * Gets requests to /model for all the methods.
     * Accepts a parameter "name". To test it localhost:PORT/model?name=the name
     *
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String usingModel(@RequestParam("name") String name, Model model){
        if(!StringUtils.isEmpty(name)){
            model.addAttribute("name", name); // <-- Puts the value of name in the model
            return "modelpage";
        }
        return "error";
    }

    /**
     * JUST TO EXPLAIN
     * If you want specify the http method use the method property
     */
    @RequestMapping(value = "/gettest", method = RequestMethod.GET)
    public String otherMethod(){
        String nameOfTheThemeLeafPage = null;
        return nameOfTheThemeLeafPage;
    }

}
