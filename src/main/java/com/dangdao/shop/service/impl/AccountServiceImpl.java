package com.dangdao.shop.service.impl;



import com.dangdao.shop.DAO.AccountDAO;
import com.dangdao.shop.entities.Account;
import com.dangdao.shop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Optional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO dao;

    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Account> findById(String username) {

        return dao.findById(username);
    }

}
