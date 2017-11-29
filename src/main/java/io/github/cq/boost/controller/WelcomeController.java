package io.github.cq.boost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class WelcomeController extends AbstractBaseController {

  public static final String VIEW_WELCOME_MAPPING = "welcome";

  @RequestMapping(value = VIEW_WELCOME_MAPPING)
  public ModelAndView welcome(final ModelAndView modelAndView) {
    final String viewName = computeTemplate(VIEW_WELCOME_MAPPING);
    modelAndView.setViewName(viewName);
    return modelAndView;
  }

}
