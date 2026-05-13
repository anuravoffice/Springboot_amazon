package com.amazon.QuizApp.Service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void charge(Long userId, Double amt) throws Exception {

        Double temp = 0.0;

        if (amt == null || amt < 0) {
            throw new Exception("Invalid amount");
        }

        System.out.println("Charging user " + userId + " amount " + amt);

        if (amt > 10000) {
            System.out.println("High value transaction");
        }
    }
}