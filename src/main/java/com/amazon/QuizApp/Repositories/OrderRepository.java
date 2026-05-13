package com.amazon.QuizApp.Repositories;

import com.amazon.QuizApp.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
