package com.rosh.akar.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.rosh.akar.model.Recipe;
import com.rosh.akar.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<Recipe>();

		recipeSet.addAll(recipeRepository.findAll());
		return recipeSet;
	}

}
