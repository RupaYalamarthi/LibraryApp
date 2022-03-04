package perscholascs.mylibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
    @RequestMapping(value  = { "/admin/home" }, method = RequestMethod.GET)
    public ModelAndView admin() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/admin/home");
        return response;
    }
    @RequestMapping(value = "/locations&hours", method = RequestMethod.GET)
    public ModelAndView locationsAndHours() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/include/Locations&Hours");
        return response;
    }
    @RequestMapping(value = "/communityPrograms", method = RequestMethod.GET)
    public ModelAndView communityPrograms() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/include/CommunityPrograms");
        return response;
    }
}
