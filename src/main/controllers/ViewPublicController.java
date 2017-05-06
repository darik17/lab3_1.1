package main.controllers;

import main.models.pojo.Publication;
import main.services.PublicationServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 05.05.2017. 123
 */

@Controller
public class ViewPublicController {

    private static final Logger LOGGER = Logger.getLogger(CheckUsers.class);

    private PublicationServices publicationServices;

    @Autowired
    public ViewPublicController(PublicationServices publicationServices) {
        this.publicationServices = publicationServices;
    }

    @RequestMapping(value="/viewpublic",method = RequestMethod.GET)
    public ModelAndView reading(@RequestParam(name="publication_id", required = false) String publicationId,
                                Model model){
        ModelAndView modelAndView = new ModelAndView();
        String name = "", textPublic = "", comment="";

        if ((publicationId != null) && (publicationId.matches("\\d+"))) {
            model.addAttribute("publication_id",publicationId);
            Publication publication = publicationServices.getById(Integer.parseInt(publicationId));
            if (publication != null){
                name = publication.getName_publication();
                textPublic = publication.getText_publication();
            }

        }

        model.addAttribute("name",name);
        model.addAttribute("text",textPublic);
        return modelAndView;
    }

}
