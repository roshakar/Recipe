package com.rosh.akar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosh.akar.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {
	public Optional<UnitOfMeasure> findByDescription(String description);
}
