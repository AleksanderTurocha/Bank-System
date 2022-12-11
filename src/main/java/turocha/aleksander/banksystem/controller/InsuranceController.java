package turocha.aleksander.banksystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import turocha.aleksander.banksystem.entity.Insurance;
import turocha.aleksander.banksystem.service.InsuranceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping("/get-all")
    public List<Insurance> getInsurances() {
        return insuranceService.getInsurances();
    }

    @GetMapping("/get-by-Id/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@RequestParam Long id) {
        return insuranceService.getInsuranceById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
