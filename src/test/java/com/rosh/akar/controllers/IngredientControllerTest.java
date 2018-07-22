package com.rosh.akar.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rosh.akar.commands.RecipeCommand;
import com.rosh.akar.services.RecipeService;

public class IngredientControllerTest {

	@Mock
	RecipeService recipeService;

	IngredientController controller;

	MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);

		controller = new IngredientController(recipeService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testListIngredients() throws Exception{
		RecipeCommand recipeCommand = new RecipeCommand();
		
		when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);
		
		mockMvc.perform(get("/recipe/1/ingredients")).andExpect(status().isOk()).andExpect(view().name("/recipe/ingredients/list")).andExpect(model().attributeExists("recipe"));

		verify(recipeService, times(1)).findCommandById(anyLong());
	}

}
