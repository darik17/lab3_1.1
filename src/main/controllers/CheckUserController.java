package main.controllers;

import main.models.pojo.User;
import main.services.UserServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 03.05.2017. 123
 */

@Controller
@SessionAttributes("userLogin")
public class CheckUserController {

    private static final Logger LOGGER = Logger.getLogger(CheckUsers.class);
    private  UserServices userServices /* = new UserServicesImpl()*/;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        LOGGER.debug("LOGINNNN");
        return "login";
    }

    @Autowired
    public CheckUserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView checkUser (@RequestParam(name = "user",required = false) String userL,
                                   @RequestParam (name = "password",required = false) String password,
                                   Model model) {
        ModelAndView modelAndView =new ModelAndView();
        User user = userServices.auth(userL,password);
        LOGGER.info(user);
        if (user != null) {

            modelAndView.addObject("user",userL);
            LOGGER.debug("user : " + user + " logged");
            modelAndView.setViewName("redirect: /userpages.jsp");


        } else {
            LOGGER.error("Ошибка входа!");
            modelAndView.setViewName("redirect: /");

        }

        return  modelAndView;
    }
}
