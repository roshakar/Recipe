package com.rosh.akar.services;

import java.util.Set;

import com.rosh.akar.commands.RecipeCommand;
import com.rosh.akar.model.Recipe;

public interface RecipeService {

	public Set<Recipe> getRecipes();
	public Recipe findById(long id);
	public RecipeCommand saveRecipe(RecipeCommand recipeCommand);
}
