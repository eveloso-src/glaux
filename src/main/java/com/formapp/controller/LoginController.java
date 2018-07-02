package com.formapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formapp.model.User;
import com.formapp.service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, params = "action=registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
//		User userExists = userService.findUserByEmail(user.getEmail());
//		if (userExists != null) {
//			bindingResult.rejectValue("email", "error.user", "Ya existe el email ");
//		}
//		if (bindingResult.hasErrors()) {
//			modelAndView.setViewName("registration");
//		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Usuario registrado correctamente");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

//		}
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, params = "action=search")
	public ModelAndView search(User user) {
		ModelAndView modelAndView = new ModelAndView();
		// List<User> users = userService.findAll();
		List<User> users = userService.findByExample(user);
		
//		users.forEach(u -> System.out.println("usuario " + u.getName()));
		modelAndView.addObject("users", users);
		modelAndView.setViewName("search");
		return modelAndView;
	}

}
