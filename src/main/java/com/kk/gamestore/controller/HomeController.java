package com.kk.gamestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Witam na stronie sklepu Gamestore znajduj�cego si� w Wieluniu.");
		model.addAttribute("tagline", " Znajdziesz tu gry z naszej plac�wki. Zapraszamy do zakup�w.");
		return "welcome";
	}
}
