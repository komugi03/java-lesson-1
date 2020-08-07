package jp.co.bhopari.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldControllers {

	@GetMapping("/")
	public String show(Model model) {

		model.addAttribute("message", "Hello from Controller!");

		return "helloworld";
	}

}
