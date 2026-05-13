package com.amazon.QuizApp.Repositories;

import com.amazon.QuizApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
