package main.controllers;

import main.services.PublicationServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 05.05.2017. 123
 */

@Controller
@RequestMapping(value="/freepublic")
public class PrintAllPublicationController {

    private static final Logger LOGGER = Logger.getLogger(CheckUsers.class);
    private PublicationServices publicationServices;

    @Autowired
    public PrintAllPublicationController(PublicationServices publicationServices) {
        this.publicationServices = publicationServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model){
        model.addAttribute("freepublic",publicationServices.getAllPublicationToFree());
        //model.addAttribute("value", "Hello,user");
        return "freepublic";
    }

}
