package turocha.aleksander.banksystem;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.dao.AccountDao;
import turocha.aleksander.banksystem.dao.ClientDao;
import turocha.aleksander.banksystem.dao.InsuranceDao;
import turocha.aleksander.banksystem.entity.Account;
import turocha.aleksander.banksystem.entity.AccountType;
import turocha.aleksander.banksystem.entity.Client;
import turocha.aleksander.banksystem.entity.Currency;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class TestData {
    private final ClientDao clientDao;
    private final AccountDao accountDao;
    private final InsuranceDao insuranceDao;

    public void createTestData() {
        Client client = new Client(1L, "John", "Snow", 30);
        Account account = new Account(1L, "Ac", new BigDecimal("2000"), Currency.PLN, client, AccountType.REGULAR);
        clientDao.save(client);
        accountDao.save(account);

        Client client2 = new Client(2L, "Rob", "Spar", 20);
        Account account2 = new Account(2L, "Co", new BigDecimal("1000"), Currency.PLN, client2, AccountType.REGULAR);
        clientDao.save(client2);
        accountDao.save(account2);
    }
}
