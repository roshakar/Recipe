package com.rosh.akar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosh.akar.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
