package com.example.sbcqrsexmple.repository;

import com.example.sbcqrsexmple.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
