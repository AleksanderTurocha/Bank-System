package turocha.aleksander.banksystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import turocha.aleksander.banksystem.entity.Account;
import turocha.aleksander.banksystem.entity.dto.TransferDto;
import turocha.aleksander.banksystem.entity.dto.account.InputAccountDto;
import turocha.aleksander.banksystem.entity.dto.account.OutputAccountDto;
import turocha.aleksander.banksystem.service.AccountService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/get-all")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/get-by-Id/{id}")
    public ResponseEntity<Account> getAccountById(@RequestParam Long id) {
        return accountService.getAccountById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transferMoney(@RequestBody TransferDto transferDto) {
        accountService.transferMoney(transferDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-account")
    public ResponseEntity<OutputAccountDto> addAccount(@RequestBody InputAccountDto inputAccountDto) {
        OutputAccountDto savedAccount = accountService.addAccount(inputAccountDto);
        URI savedAccountUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAccount.getId())
                .toUri();
        return ResponseEntity.created(savedAccountUri).body(savedAccount);
    }

}
