package turocha.aleksander.banksystem.entity.dto.account;

import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.entity.Account;

@Service
public class AccountMapper {
    public Account mapInputAccountToAccount(InputAccountDto inputAccountDto) {
        Account account = new Account();
        account.setAccountName(inputAccountDto.getAccountName());
        account.setBalance(inputAccountDto.getBalance());
        account.setCurrency(inputAccountDto.getCurrency());
        account.setAccountType(inputAccountDto.getAccountType());
        return account;
    }

    public OutputAccountDto mapAccountToOutputAccount(Account account) {
        OutputAccountDto outputAccountDto = new OutputAccountDto();
        outputAccountDto.setId(account.getId());
        outputAccountDto.setAccountName(account.getAccountName());
        outputAccountDto.setBalance(account.getBalance());
        outputAccountDto.setCurrency(account.getCurrency());
        outputAccountDto.setAccountType(account.getAccountType());
        return outputAccountDto;
    }
}