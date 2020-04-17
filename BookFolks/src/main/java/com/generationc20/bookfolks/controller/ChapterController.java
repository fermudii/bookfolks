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
@RequestMapping("/chapter")
public class ChapterController {

	@Autowired
	ChapterService service;
	
	@Autowired
	UserService uService;
	
	@Autowired
	StoryService sService;
	
	@PostMapping("/createChapter")
	public String loadNewChapterView(@SessionAttribute("user") User user,
			@RequestParam("id") Integer id,
			@RequestParam("flag")int flag, Model model, @RequestParam("txtTitle") String title,
			@RequestParam("txtContent") String content,
			@RequestParam("txtIdStory") Integer idStory,
			@RequestParam("txtUrlImage") String urlImage,
			@RequestParam("txtIdContinuity") Integer idContinuity,
			RedirectAttributes redirectAttributes) {
				User userDB = uService.getById(user.getId()).get();
				Story storyDB = sService.getById(idStory).get();
				
				//Model
				Chapter chapter = new Chapter();
				chapter.setTitle(title);
				chapter.setContent(content);
				chapter.setId_user(user.getId());
				chapter.setUrlImage(urlImage);
				chapter.setId_story(idStory);
				chapter.setId_continuity(idContinuity);
				chapter.setAuthor(userDB.getUsername());
				chapter.setStoryTitle(storyDB.getTitle());

				service.save(chapter);
				redirectAttributes.addFlashAttribute("success","Your chapter was created");
				
				if(idContinuity == 0) {
					model.addAttribute("user", uService.getById(user.getId()).get());
					model.addAttribute("story", sService.getById(id).get());
					model.addAttribute("flag", flag);
					
					redirectAttributes.addAttribute("id",idStory);
					
					return "redirect:/story/showStory";
				} 
				model.addAttribute("user", uService.getById(user.getId()).get());
				model.addAttribute("chapter", service.getById(id).get());
				model.addAttribute("story",sService.getById(service.getById(id).get().getId_story()).get());
				model.addAttribute("flag", flag);
				redirectAttributes.addAttribute("id",idContinuity);
				
				return "redirect:/chapter/showChapter";
		
		
		
		
	}
	
	@PostMapping("/new")
	public String createChapter(@SessionAttribute("user") User user,
			@RequestParam("txtTitle") String title,
			@RequestParam("txtContent") String content,
			@RequestParam("txtIdStory") Integer idStory,
			@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("txtIdContinuity") Integer idContinuity,
			RedirectAttributes redirectAttributes) {
		
		User userDB = uService.getById(user.getId()).get();
		Story storyDB = sService.getById(idStory).get();
		
		//Model
		Chapter chapter = new Chapter();
		chapter.setTitle(title);
		chapter.setContent(content);
		chapter.setId_user(user.getId());
		chapter.setId_story(idStory);
		chapter.setId_continuity(idContinuity);
		chapter.setAuthor(userDB.getUsername());
		chapter.setStoryTitle(storyDB.getTitle());

		service.save(chapter,multipartFile);
		redirectAttributes.addFlashAttribute("success","Your chapter was created");
		
		if(idContinuity == 0) {
			redirectAttributes.addAttribute("id",idStory);
			return "redirect:/story/showStory";
		}
		redirectAttributes.addAttribute("id",idContinuity);
		return "redirect:/chapter/showChapter";
	}
	
	@GetMapping("/showChapter")
	public String getChapter(@RequestParam("id")Integer id, @SessionAttribute("user")User user,Model model,
			RedirectAttributes redirectAttributes) {
		List<Chapter> chapters = new ArrayList<>();
		List<Chapter> allChapters = service.getAll();
		
		Chapter currentChapter = service.getById(id).get();
		int size=0;
		for(Chapter chapterDB : allChapters) {
			if(currentChapter.getId() == chapterDB.getId_continuity()) {
				chapters.add(chapterDB);
				size++;
			}
		}
		if(chapters.isEmpty()) {
			model.addAttribute("story",sService.getById(service.getById(id).get().getId_story()).get());
			model.addAttribute("chapter",currentChapter);
			model.addAttribute("user", uService.getById(user.getId()).get());
			model.addAttribute("size",size);
			return "/chapter";
		}else {
			model.addAttribute("story",sService.getById(service.getById(id).get().getId_story()).get());
			model.addAttribute("chaptersChild", chapters);
			model.addAttribute("chapter",currentChapter);
			model.addAttribute("user", uService.getById(user.getId()).get());
			model.addAttribute("size",size);
		return "/chapter";
		}
	}
	
	@GetMapping("/all")
	public String getAllMyChapters(@SessionAttribute("user") User user,Model model, RedirectAttributes redirectAttributes) {
		
		List<Chapter> myChapters = new ArrayList<>();
		List<Chapter> allChapters = service.getAll();
		
		for(Chapter chapterDB : allChapters) {
			if(user.getId() == chapterDB.getId_user() && chapterDB.getId_continuity() !=0) {
				myChapters.add(chapterDB);
			}
		}
		System.out.println(myChapters.isEmpty());
			Collections.reverse(myChapters);
			if(myChapters.isEmpty()) {
				model.addAttribute("error","You don't have any collaborations yet!");
				return"/allMyChapters";
			}else {
				model.addAttribute("myChapters",myChapters);
			}
		return"/allMyChapters";
		}
	
}
