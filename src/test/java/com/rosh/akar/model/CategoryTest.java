package com.rosh.akar.model;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() {
		Long idValue = 4l;

		category.setId(idValue);
		
		assertEquals(idValue, category.getId());
	}

	@Test
	public void testGetDescription() {
		String descriptionValue = "American";

		category.setDescription(descriptionValue);

		assertEquals(descriptionValue, category.getDescription());
	}

	@Test
	public void testGetRecipes() {
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipes.add(new Recipe());

		category.setRecipes(recipes);

		assertEquals(recipes, category.getRecipes());
	}

}
