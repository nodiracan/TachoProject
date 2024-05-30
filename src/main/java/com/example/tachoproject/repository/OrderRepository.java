package com.example.tachoproject.repository;

import com.example.tachoproject.domains.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder , Long > {

}
