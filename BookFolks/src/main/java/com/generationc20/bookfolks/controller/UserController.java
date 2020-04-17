package com.generationc20.bookfolks.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.generationc20.bookfolks.model.Story;
import com.generationc20.bookfolks.model.User;
import com.generationc20.bookfolks.service.StoryService;
import com.generationc20.bookfolks.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private StoryService sService;
	
	@GetMapping("/index")
	public String loadIndexView(Model model) {
		return "index";
	}
	
	@GetMapping("/main")
	public String loadMainPageView(@SessionAttribute("user") User user,Model model) {
		
		if(user.getId() != null) {
			User userSession = service.getById(user.getId()).get();
			List<Story> allStories = sService.getAll();
			Collections.reverse(allStories);
			
			
			model.addAttribute("user",userSession);
			model.addAttribute("allStories", allStories );
			return "main";
		}else {
			return"redirect:/user/loginForm";
		}
		
	}
	
	@GetMapping("/aboutUs")
	public String loadAboutUsView(Model model) {
		return "About_us";
	}
	
	@GetMapping("/signupForm")
	public String loadSignupFormView(Model model) {
		return "signupForm";
	}
	@GetMapping("/loginForm")
	public String loadLoginFormView(Model model) {
		return "loginForm";
	}
	@GetMapping("/editProfile")
	public String loadUpdateProfileView(@SessionAttribute("user")User user,Model model) {
		model.addAttribute("user", service.getById(user.getId()).get());
		return "updateProfile";
	}
	@GetMapping("/deleteAccount")
	public String loadDeleteAccountView(Model model) {
		return "deleteAccount";
	}
	@GetMapping("/profile")
	public String loadProfileView(@SessionAttribute("user")User user,Model model) {
		model.addAttribute("user",service.getById(user.getId()).get());
		return "profile";
	}

	
	@PostMapping("/signup")
	public String signUp(@RequestParam("txtUserName") String username,
			@RequestParam("txtEmail") String email,
			@RequestParam("txtPassword") String password,
			@RequestParam("txtConfirmPassword") String confirmPassword,
			RedirectAttributes redirectAttributes) {
		
		List<User> allUsers = service.getAll();
		
		for(User userDB : allUsers) {
			if(username.equals(userDB.getUsername())) {
				redirectAttributes.addFlashAttribute("errorAccount","Sorry, this account already exist");
				return "redirect:/user/signupForm";
			}
		}
		if(password.equals(confirmPassword)) {
			//Model
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setAge(0);
			
			service.save(user);
			redirectAttributes.addFlashAttribute("success","Your account was created");
			return "redirect:/user/signupForm";
			
		}else {
			redirectAttributes.addFlashAttribute("errorPassword","Your password is not the same, please do not be stupid");
			return "redirect:/user/signupForm";
		}
	}
	
	@PostMapping("/edit")
	public String editProfile(@SessionAttribute("user") User user,
			@RequestParam("txtName") String name,
			@RequestParam("txtLastName") String lastName,
			@RequestParam("txtAge") Integer age,
			@RequestParam("txtGender") String gender,
			@RequestParam("txtDescription") String description,
			@RequestParam("txtEmail") String email,
			@RequestParam("file") MultipartFile multipartFile,
			RedirectAttributes redirectAttributes) {
		
		//Model
		User userDB = service.getById(user.getId()).get();
		User userEdited = new User();
		if(name != null && name.length()>0) {
			userEdited.setName(name);
		}else {
			userEdited.setName(userDB.getName());
		}
		if(lastName != null && lastName.length()>0) {
			userEdited.setLastName(lastName);
		}else {
			userEdited.setLastName(userDB.getLastName());
		}
		if(age != null && age > 0) {
			userEdited.setAge(age);
		}else {
			userEdited.setAge(userDB.getAge());
		}
		if(gender != null && gender.length() > 0) {
			userEdited.setGender(gender);
		}else {
			userEdited.setGender(userDB.getGender());
		}
		if(description != null && description.length() > 0) {
			userEdited.setDescription(description);
		}else {
			userEdited.setDescription(userDB.getDescription());
		}
		if(email != null && email.length() > 0) {
			userEdited.setEmail(email);
		}else {
			userEdited.setEmail(userDB.getEmail());
		}
		
		
		service.update(user.getId(),userEdited,multipartFile);
		redirectAttributes.addFlashAttribute("success","Your profile was updated");
		return "redirect:/user/profile";
	}
	
	@GetMapping("/removeAccount")
	public String removeAccount(@SessionAttribute("user") User user, RedirectAttributes redirectAttributes,
			@RequestParam("txtUsername") String username,
			@RequestParam("txtPassword") String password) {
		
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			
			service.remove(user.getId());
			return "redirect:/logout";
			
			
		}else {
			redirectAttributes.addFlashAttribute("error","Your Username and/or Password are incorrect");
			return "redirect:/user/deleteAccount";
		}
		
	}
	
	
	}
	
	
	

