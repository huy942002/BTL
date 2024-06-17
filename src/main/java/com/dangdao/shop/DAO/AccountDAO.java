package com.dangdao.shop.DAO;

import com.dangdao.shop.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.util.List;
@Repository
public interface AccountDAO extends JpaRepository<Account, String> {
    @Query("SELECT a FROM Account a WHERE a.username =:user")
    Account FindByUserName(@Param("user") String user);
   
}
