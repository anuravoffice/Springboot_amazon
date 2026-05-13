package com.amazon.QuizApp.Repositories;

import com.amazon.QuizApp.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
