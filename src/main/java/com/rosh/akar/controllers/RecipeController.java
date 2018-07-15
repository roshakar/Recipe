package com.rosh.akar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rosh.akar.services.RecipeService;

@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value = "/recipe/show/{id}")
	public String showById(@PathVariable Long id, Model model) {

		model.addAttribute("recipe", recipeService.findById(id));
		
		return "recipe/show";
	}

}
