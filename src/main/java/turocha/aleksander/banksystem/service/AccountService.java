package turocha.aleksander.banksystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.dao.AccountDao;
import turocha.aleksander.banksystem.dao.ClientDao;
import turocha.aleksander.banksystem.entity.Account;
import turocha.aleksander.banksystem.entity.Client;
import turocha.aleksander.banksystem.entity.dto.TransferDto;
import turocha.aleksander.banksystem.entity.dto.account.AccountMapper;
import turocha.aleksander.banksystem.entity.dto.account.InputAccountDto;
import turocha.aleksander.banksystem.entity.dto.account.OutputAccountDto;
import turocha.aleksander.banksystem.exceptions.NotFoundException;
import turocha.aleksander.banksystem.exceptions.custom.ClientNotFound;
import turocha.aleksander.banksystem.exceptions.custom.NotEnoughFundsException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;
    private final ClientDao clientDao;
    private final AccountMapper accountMapper;

    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountDao.findById(id);
    }

    @Transactional
    public void transferMoney(TransferDto transferDto) {
        Optional<Account> optionalSender = accountDao.findById(transferDto.getSenderId());
        Optional<Account> optionalReceiver = accountDao.findById(transferDto.getReceiverId());
        if (optionalSender.isPresent() && optionalReceiver.isPresent()) {
            Account sender = optionalSender.get();
            Account receiver = optionalReceiver.get();
            if (sender.getBalance().subtract(transferDto.getAmount()).compareTo(BigDecimal.ZERO) > 0) {
                sender.setBalance(sender.getBalance().subtract(transferDto.getAmount()));
                receiver.setBalance(receiver.getBalance().add(transferDto.getAmount()));
            } else {
                throw new NotEnoughFundsException("Funds insufficient");
            }
        } else {
            throw new NotFoundException("Sender or receiver does not exist");
        }
    }

    @Transactional
    public OutputAccountDto addAccount(InputAccountDto inputAccountDto) {
        Optional<Client> optionalClient = clientDao.findById(inputAccountDto.getClientId());
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            Account account = accountMapper.mapInputAccountToAccount(inputAccountDto);
            account.setClient(client);
            Account savedAccount = accountDao.save(account);
            return accountMapper.mapAccountToOutputAccount(savedAccount);
        } else {
            throw new ClientNotFound("Client not found");
        }
    }
}
