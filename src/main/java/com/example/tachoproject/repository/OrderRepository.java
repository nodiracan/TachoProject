package com.example.tachoproject.repository;

import com.example.tachoproject.domains.TacoOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
