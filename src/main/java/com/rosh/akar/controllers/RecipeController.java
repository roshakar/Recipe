package com.rosh.akar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rosh.akar.commands.RecipeCommand;
import com.rosh.akar.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value = "/recipe/{id}/show", method = RequestMethod.GET)
	public String showById(@PathVariable Long id, Model model) {

		model.addAttribute("recipe", recipeService.findById(id));
		
		return "recipe/show";
	}

	@RequestMapping(value = "/recipe/new", method = RequestMethod.GET)
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand) {
		RecipeCommand savedCommand = recipeService.saveRecipe(recipeCommand);

		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}

	@RequestMapping(value = "/recipe/{id}/update", method = RequestMethod.GET)
	public String updateRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
		return "recipe/recipeform";
	}

	@RequestMapping(value = "/recipe/{id}/delete", method = RequestMethod.GET)
	public String deleteRecipe(@PathVariable Long id) {
		log.debug("Deleting Id: " + id);

		recipeService.deleteById(id);
		return "redirect:/";
	}

}
