package com.bankapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.AccountTranscation;
@Repository
public interface AccountTranscationRepository extends JpaRepository<AccountTranscation, Long>{

}
