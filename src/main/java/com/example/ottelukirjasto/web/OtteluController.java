package com.example.ottelukirjasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstorefall2020.model.BookRepository;
import com.example.ottelukirjasto.model.OtteluRepository;

@Controller
public class OtteluController {
	
	@Autowired
	private OtteluRepository orepository;

	@RequestMapping(value = "/kotisivu")
	public String kotisivu() {
		return "kotisivu";
	}
	
	@RequestMapping(value = "/ottelulista")
	public String ottelulista(Model model) {
		model.addAttribute("ottelut", orepository.findAll());
		return "ottelulista";
	}

}
