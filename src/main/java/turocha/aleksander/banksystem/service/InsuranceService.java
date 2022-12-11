package turocha.aleksander.banksystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.dao.InsuranceDao;
import turocha.aleksander.banksystem.entity.Insurance;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceDao insuranceDao;

    public List<Insurance> getInsurances() {
        return insuranceDao.findAll();
    }

    public Optional<Insurance> getInsuranceById(Long id) {
        return insuranceDao.findById(id);
    }
}
