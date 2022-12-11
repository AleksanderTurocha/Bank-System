package turocha.aleksander.banksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turocha.aleksander.banksystem.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
}
