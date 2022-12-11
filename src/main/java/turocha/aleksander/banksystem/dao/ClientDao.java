package turocha.aleksander.banksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turocha.aleksander.banksystem.entity.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
}
