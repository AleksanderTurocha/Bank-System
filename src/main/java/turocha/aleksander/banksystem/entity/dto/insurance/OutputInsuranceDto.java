package turocha.aleksander.banksystem.entity.dto.insurance;

import lombok.Data;
import turocha.aleksander.banksystem.entity.Client;
import turocha.aleksander.banksystem.entity.InsuranceType;

import java.math.BigDecimal;

@Data
public class OutputInsuranceDto {
    private Long id;
    private BigDecimal totalWorth;
    private BigDecimal fee;
    private InsuranceType insuranceType;
    private Client client;
}
