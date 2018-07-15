package com.rosh.akar.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rosh.akar.model.Category;
import com.rosh.akar.model.Difficulty;
import com.rosh.akar.model.Ingredient;
import com.rosh.akar.model.Notes;
import com.rosh.akar.model.Recipe;
import com.rosh.akar.model.UnitOfMeasure;
import com.rosh.akar.repositories.CategoryRepository;
import com.rosh.akar.repositories.RecipeRepository;
import com.rosh.akar.repositories.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.debug("ContextRefreshedEvent received... saving recipes to database.");
		recipeRepository.saveAll(getRecipes());
	}

	private List<Recipe> getRecipes() {
		log.debug("Inside of bootstrap getRecipes()");

		List<Recipe> recipes = new ArrayList<Recipe>(2);

		// Get Units of Measure
		log.debug("Getting units of measure optionals.");
		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

		if (!eachUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

		if (!tablespoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		if (!teaspoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

		if (!dashUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

		if (!pintUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

		if (!cupsUomOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		log.debug("Getting units of measure from optionals");
		// Get Optionals
		UnitOfMeasure eachUom = eachUomOptional.get();
		UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
		UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
		UnitOfMeasure dashUom = dashUomOptional.get();
		UnitOfMeasure pintUom = pintUomOptional.get();
		UnitOfMeasure cupsUom = cupsUomOptional.get();

		log.debug("Getting category optionals.");
		// Get Categories
		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

		if (!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

		if (!mexicanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}

		log.debug("Getting categories from optionals.");
		// Get Optionals
		Category americanCategory = americanCategoryOptional.get();
		Category mexicanCategory = mexicanCategoryOptional.get();

		log.debug("Initializing recipes and related notes.");
		// Guac
		Recipe guacRecipe = new Recipe();
		guacRecipe.setDescription("Perfect Guacamole");
		guacRecipe.setPrepTime(10);
		guacRecipe.setCookTime(0);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections(
				"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\r\n"
						+ "\r\n"
						+ "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\r\n"
						+ "\r\n"
						+ "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n"
						+ "\r\n"
						+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n"
						+ "\r\n"
						+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\r\n"
						+ "\r\n"
						+ "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\r\n"
						+ "\r\n"
						+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\r\n"
						+ "Read more: https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		
		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes(
				"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\r\n"
						+ "\r\n"
						+ "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\r\n"
						+ "\r\n"
						+ "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\r\n"
						+ "\r\n"
						+ "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\r\n"
						+ "Read more: https://www.simplyrecipes.com/recipes/perfect_guacamole/");

		guacRecipe.setNotes(guacNotes);

		guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
		guacRecipe.addIngredient(new Ingredient("Kosher Salt", new BigDecimal(.5), teaspoonUom));
		guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUom));
		guacRecipe.addIngredient(
				new Ingredient("minced red onion or thinly slice green onion", new BigDecimal(2), tablespoonUom));
		guacRecipe.addIngredient(
				new Ingredient("serrano chiles, stems and seeds remove, minced", new BigDecimal(2), eachUom));
		guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoonUom));
		guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
		guacRecipe.addIngredient(
				new Ingredient("ripe tomatoc, seeds and pulp removed, chopped", new BigDecimal(.5), eachUom));

		guacRecipe.getCategories().add(americanCategory);
		guacRecipe.getCategories().add(mexicanCategory);

		guacRecipe.setServings(4);
		guacRecipe.setSource("Simply Recipes");
		guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

		recipes.add(guacRecipe);

		// Tacos
		Recipe tacoRecipe = new Recipe();
		tacoRecipe.setDescription("Spicy Grilled Chicken Taco");
		tacoRecipe.setCookTime(9);
		tacoRecipe.setPrepTime(20);
		tacoRecipe.setDifficulty(Difficulty.MODERATE);

		tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\r\n" + "\r\n"
				+ "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\r\n"
				+ "\r\n" + "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\r\n"
				+ "\r\n"
				+ "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\r\n"
				+ "\r\n"
				+ "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\r\n"
				+ "\r\n" + "Wrap warmed tortillas in a tea towel to keep them warm until serving.\r\n" + "\r\n"
				+ "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\r\n"
				+ " Read more: https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

		Notes tacoNotes = new Notes();
		tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\r\n"
				+ "\r\n"
				+ "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\r\n"
				+ "\r\n"
				+ "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\r\n"
				+ "\r\n"
				+ "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\r\n"
				+ "\r\n"
				+ "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");

		tacoRecipe.setNotes(tacoNotes);

		tacoRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoonUom));
		tacoRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoonUom));
		tacoRecipe.addIngredient(new Ingredient("Dried cumin", new BigDecimal(1), teaspoonUom));
		tacoRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoonUom));
		tacoRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(.5), teaspoonUom));
		tacoRecipe.addIngredient(new Ingredient("Clove of Garlic, chopped", new BigDecimal(1), eachUom));
		tacoRecipe.addIngredient(new Ingredient("Finely grated Orange zest", new BigDecimal(1), tablespoonUom));
		tacoRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUom));
		tacoRecipe.addIngredient(new Ingredient("Olive oil", new BigDecimal(2), tablespoonUom));
		tacoRecipe.addIngredient(new Ingredient("Boneless chicken thighs", new BigDecimal(4), eachUom));
		tacoRecipe.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom));
		tacoRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupsUom));
		tacoRecipe.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), eachUom));
		tacoRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
		tacoRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(.5), pintUom));
		tacoRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(.25), eachUom));
		tacoRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom));
		tacoRecipe
				.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupsUom));
		tacoRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom));

		tacoRecipe.getCategories().add(americanCategory);
		tacoRecipe.getCategories().add(mexicanCategory);

		tacoRecipe.setServings(5);
		tacoRecipe.setSource("Simply Recipes");
		tacoRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

		recipes.add(tacoRecipe);

		log.debug("bootstrap getRecipes() method complete.");
		return recipes;
	}

}
