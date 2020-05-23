package com.faqs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faqs.eneity.Classes;
import com.faqs.eneity.Faqs;
import com.faqs.service.FaqsService;

@Controller
public class WinController {
	@Autowired
	private FaqsService fs;
	
	@RequestMapping(value="selectFaqs.win")
	public String selectFaqs(Model model,String title,Integer ClassId) {

		List<Faqs> list = this.fs.selectFaqs(null,2);
		
		model.addAttribute("list",list);
		return "index.jsp";
	}
	
	@RequestMapping(value="selectClasses.win")
	public String selectClasses(Model model,Integer ClassId) {

		List<Classes> list = this.fs.showCId(3);
		
		model.addAttribute("list",list);
		return "index.jsp";
	}

}
