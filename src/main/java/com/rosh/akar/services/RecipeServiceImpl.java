package com.rosh.akar.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.rosh.akar.model.Recipe;
import com.rosh.akar.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
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

}
