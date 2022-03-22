package com.credit.card.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credit.card.entity.CCard;

@Repository
public interface CardRepository extends JpaRepository<CCard, String> {

}
