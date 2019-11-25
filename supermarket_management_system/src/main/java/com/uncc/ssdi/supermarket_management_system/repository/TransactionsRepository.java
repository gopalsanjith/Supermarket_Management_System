package com.uncc.ssdi.supermarket_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uncc.ssdi.supermarket_management_system.entity.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

}
