package turocha.aleksander.banksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turocha.aleksander.banksystem.entity.Insurance;

@Repository
public interface InsuranceDao extends JpaRepository<Insurance, Long> {
}
