package com.rosh.akar.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rosh.akar.commands.RecipeCommand;
import com.rosh.akar.converters.RecipeCommandToRecipe;
import com.rosh.akar.converters.RecipeToRecipeCommand;
import com.rosh.akar.model.Recipe;
import com.rosh.akar.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.debug("I'm in the service");
		Set<Recipe> recipeSet = new HashSet<Recipe>();

		recipeSet.addAll(recipeRepository.findAll());
		return recipeSet;
	}

	@Override
	public Recipe findById(long id) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(id);
		
		if (!recipeOptional.isPresent()) {
			throw new RuntimeException("Recipe not found!");
		}

		return recipeOptional.get();
	}

	@Override
	@Transactional
	public RecipeCommand saveRecipe(RecipeCommand recipeCommand) {
		Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);

		recipe = recipeRepository.save(recipe);
		log.debug("Saved recipe with Id: " + recipe.getId());
		return recipeToRecipeCommand.convert(recipe);
	}

	@Override
	@Transactional
	public RecipeCommand findCommandById(Long id) {
		return recipeToRecipeCommand.convert(findById(id));
	}

	@Override
	public void deleteById(Long id) {
		recipeRepository.deleteById(id);
	}

}
