package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.purchase;

public interface PurchaseRepository extends JpaRepository<purchase, Integer> {

}
