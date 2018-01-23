package com.kk.gamestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Witam na stronie sklepu Gamestore znajduj¹cego siê w Wieluniu.");
		model.addAttribute("tagline", " Znajdziesz tu gry z naszej placówki. Zapraszamy do zakupów.");
		return "welcome";
	}
}
