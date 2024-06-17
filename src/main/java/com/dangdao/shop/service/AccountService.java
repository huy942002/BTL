package com.dangdao.shop.service;


import com.dangdao.shop.entities.Account;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public interface AccountService {
    public List<Account> findAll() ;
    public Optional<Account> findById(String username) ;
}
