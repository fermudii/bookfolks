package com.generationc20.bookfolks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.generationc20.bookfolks.model.User;
import com.generationc20.bookfolks.service.UserService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	private UserService service;

	@ModelAttribute("user")
	public User setUpUserForm() {
		return new User();
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		
		List<User> allUsers = service.getAll();
		
		for(User userDB : allUsers) {
			if(user.getUsername().equals(userDB.getUsername())) {
				if(user.getPassword().equals(userDB.getPassword())) {
					user.setId(userDB.getId());
				}else {
					redirectAttributes.addFlashAttribute("errorPassword","Your password is incorrect");
					return "redirect:/user/loginForm";
				}
				return "redirect:/user/main";
			}	
		}
		redirectAttributes.addFlashAttribute("errorUsername","Your account does not exist");
		return "redirect:/user/loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(@ModelAttribute User user, WebRequest request, SessionStatus status, RedirectAttributes redirectAttributes) {
		status.setComplete();
	    request.removeAttribute("user",WebRequest.SCOPE_SESSION);
	    if(!(service.getById(user.getId()).isPresent())) {
			redirectAttributes.addFlashAttribute("success","Your account was deleted");
	    }else {
	    	redirectAttributes.addFlashAttribute("logout","Session was closed");
	    }
	    return "redirect:/";
	}
	
}
