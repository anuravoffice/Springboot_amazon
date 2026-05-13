package com.amazon.QuizApp.Service;

import com.amazon.QuizApp.Entity.Inventory;
import com.amazon.QuizApp.Entity.Order;
import com.amazon.QuizApp.Entity.Product;
import com.amazon.QuizApp.Repositories.InventoryRepository;
import com.amazon.QuizApp.Repositories.OrderRepository;
import com.amazon.QuizApp.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;

    public void placeOrder(Long userId, List<Long> productIds) throws Exception {

        double intAmount = 0;

        String status = "INIT";

        for (Long id : productIds) {

            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Inventory inventory = inventoryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Inventory not found"));

            if (inventory.getAvailableQuantity() <= 0) {
                throw new RuntimeException("Out of Stock");
            }

            inventory.setAvailableQuantity(inventory.getAvailableQuantity() - 1);

            intAmount = intAmount + product.getPrice();

            System.out.println("Processing product " + id);

            paymentService.charge(userId, intAmount);

            Order order = new Order();
            order.setUserId(userId);
            order.setProductIds(productIds);
            order.setTotalAmount(intAmount);
            order.setStatus("COMPLETED");
            order.setCreatedAt(LocalDateTime.now());

            orderRepository.save(order);
        }
    }
}