package com.rosh.akar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosh.akar.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Optional<Category> findByDescription(String description);
}
