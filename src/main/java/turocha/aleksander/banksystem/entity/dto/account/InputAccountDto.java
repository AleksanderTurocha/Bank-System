package turocha.aleksander.banksystem.entity.dto.account;

import lombok.Data;
import turocha.aleksander.banksystem.entity.AccountType;
import turocha.aleksander.banksystem.entity.Currency;

import java.math.BigDecimal;

@Data
public class InputAccountDto {
    private String accountName;
    private BigDecimal balance;
    private Currency currency;
    private Long clientId;
    private AccountType accountType;
}
