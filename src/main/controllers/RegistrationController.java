package main.controllers;

import main.services.PersonServices;
import main.services.UserServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 03.05.2017. 123
 */

@Controller
public class RegistrationController  {

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
    private final PersonServices personServices;
    private final UserServices userService;

    @Autowired
    public RegistrationController(PersonServices personService, UserServices userServices) {
        this.personServices = personService;
        this.userService = userServices;
    }

    @RequestMapping(value = "/Registration",method = RequestMethod.POST)
    public ModelAndView registration (@RequestParam (name = "user",required = false) String user,
                                      @RequestParam (name = "password",required = false) String password,
                                      @RequestParam (name = "fio",required = false) String fio,
                                      @RequestParam (name = "email",required = false) String email,
                                      @RequestParam (name = "phone",required = false) String phone,
                                      Model model){
        ModelAndView modelAndView =new ModelAndView();

        LOGGER.debug("user " + user + fio);

        if(user=="" && password=="" && fio=="" &&
                email=="" && phone=="") {
            modelAndView.setViewName("redirect: /Registration");
        }else{
            userService.insert(user,password);
            personServices.insert(fio,email,phone);
           modelAndView.setViewName("redirect: /");
        }
        return modelAndView;
    }
}
