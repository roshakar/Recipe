package com.rosh.akar.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.rosh.akar.commands.CategoryCommand;
import com.rosh.akar.model.Category;

import lombok.Synchronized;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {
		if (source == null) {
			return null;
		}

		final CategoryCommand categoryCommand = new CategoryCommand();

		categoryCommand.setId(source.getId());
		categoryCommand.setDescription(source.getDescription());

		return categoryCommand;
	}
}
