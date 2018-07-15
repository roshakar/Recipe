package com.rosh.akar.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.rosh.akar.commands.UnitOfMeasureCommand;
import com.rosh.akar.model.UnitOfMeasure;

import lombok.Synchronized;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure source) {
		if (source == null) {
			return null;
		}

		final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
		uomc.setId(source.getId());
		uomc.setDescription(source.getDescription());
		return uomc;
	}

}
