package turocha.aleksander.banksystem.entity.dto.insurance;

import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.entity.Insurance;

@Service
public class InsuranceMapper {
    public Insurance mapInputInsuranceToInsurance(InputInsuranceDto inputInsuranceDto) {
        Insurance insurance = new Insurance();
        insurance.setTotalWorth(inputInsuranceDto.getTotalWorth());
        insurance.setFee(inputInsuranceDto.getFee());
        insurance.setInsuranceType(inputInsuranceDto.getInsuranceType());
        insurance.setClient(inputInsuranceDto.getClient());
        return insurance;
    }

    public OutputInsuranceDto mapInputInsuranceToInsurance(Insurance insurance) {
        OutputInsuranceDto outputInsuranceDto = new OutputInsuranceDto();
        outputInsuranceDto.setTotalWorth(insurance.getTotalWorth());
        outputInsuranceDto.setFee(insurance.getFee());
        outputInsuranceDto.setInsuranceType(insurance.getInsuranceType());
        outputInsuranceDto.setClient(insurance.getClient());
        return outputInsuranceDto;
    }
}
