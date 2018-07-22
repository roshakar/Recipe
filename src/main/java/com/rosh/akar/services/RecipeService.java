package com.rosh.akar.services;

import java.util.Set;

import com.rosh.akar.commands.RecipeCommand;
import com.rosh.akar.model.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(long id);

	RecipeCommand saveRecipe(RecipeCommand recipeCommand);

	RecipeCommand findCommandById(Long id);

	void deleteById(Long id);
}
