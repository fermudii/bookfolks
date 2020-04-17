package com.generationc20.bookfolks.controller;

import java.util.ArrayList;
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

import com.generationc20.bookfolks.model.Chapter;
import com.generationc20.bookfolks.model.Story;
import com.generationc20.bookfolks.model.User;
import com.generationc20.bookfolks.service.ChapterService;
import com.generationc20.bookfolks.service.StoryService;
import com.generationc20.bookfolks.service.UserService;


@Controller
@RequestMapping("story")
public class StoryController {
	
	@Autowired
	UserService uService;
	
	@Autowired
	StoryService service; 
	
	@Autowired
	ChapterService cService;
	
	@GetMapping("/new")
	public String loadNewStoryView(@SessionAttribute("user")User user, Model model) {
		model.addAttribute("user", uService.getById(user.getId()).get());
		return "/storyForm";
	}
	
	@GetMapping("/deleteStory")
	public String loadDeleteStoryView(@RequestParam("id") Integer id,Model model) {
		
		model.addAttribute("story", service.getById(id).get());
		return "/deleteStory";
	}
	@PostMapping("/createStory")
	public String createStory(@SessionAttribute("user")User user,
			@RequestParam("txtTitle") String title,
			@RequestParam("txtSynopsis") String synopsis,
			@RequestParam("txtUrlImage") String urlImage,
			/*@RequestParam("file") MultipartFile multipartFile,*/
			@RequestParam("txtGenre") int genre, RedirectAttributes redirectAttributes) {
		
		User userDB = uService.getById(user.getId()).get();
		//Model
		Story story = new Story();
		story.setTitle(title);
		story.setSynopsis(synopsis);
		story.setIdGenre(genre);
		story.setUrlImage(urlImage);
		story.setIdUser(user.getId());
		story.setAuthor(userDB.getUsername());
		
		service.save(story/*,multipartFile*/);
		redirectAttributes.addFlashAttribute("success","Your story was created");
	return "redirect:/story/all";
	}
	
	@GetMapping("/all")
	public String getAllMyStories(@SessionAttribute("user")User user, Model model,
			RedirectAttributes redirectAttributes) {
		
		List<Story> myStories = new ArrayList<>();
		
		List<Story> allStories = service.getAll();
		for(Story storyDB : allStories) {
			if(user.getId() == storyDB.getIdUser()) {
				myStories.add(storyDB);
			}
		}
		Collections.reverse(myStories);
			if(myStories.isEmpty()) {
				model.addAttribute("error","You don't have any stories yet!");
				return"/allMyStories";
			}else {
				model.addAttribute("myStories",myStories);
			}
		return"/allMyStories";
	}
	
	@GetMapping("/showStory")
	public String getStory(@RequestParam("id") Integer id, @SessionAttribute("user")User user,Model model,
			RedirectAttributes redirectAttributes) {
	
		Chapter myChapter = new Chapter();;
		List<Chapter> allChapters = cService.getAll();
		
		Story currentStory = service.getById(id).get();
		
		for(Chapter chapterDB : allChapters) {
			if(currentStory.getId() == chapterDB.getId_story()) {
				myChapter = (chapterDB);
				model.addAttribute("chapter", myChapter);
				model.addAttribute("story",currentStory);
				model.addAttribute("user", uService.getById(user.getId()).get());
				return "/story";
			}
		}
		
		model.addAttribute("story",currentStory);
		model.addAttribute("user", uService.getById(user.getId()).get());
		model.addAttribute("noChapter","First Chapter doesn't exist");
		return "/story";
	}
	
	@GetMapping("/removeStory")
	public String removeStory(@SessionAttribute("user") User user,RedirectAttributes redirectAttributes,
			@RequestParam("id")Integer id,
			@RequestParam("txtUsername")String username,
			@RequestParam("txtPassword") String password) {
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			service.remove(id);
			redirectAttributes.addFlashAttribute("success","Your story was deleted");
			return "redirect:/user/profile";
			
			
		}else {
			redirectAttributes.addFlashAttribute("error","Your Username and/or Password are incorrect");
			redirectAttributes.addAttribute("id", id);
			return "redirect:/story/deleteStory";
		}
	}
	
	
	
	
	
	
	
	
}
