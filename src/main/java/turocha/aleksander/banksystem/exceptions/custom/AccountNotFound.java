package turocha.aleksander.banksystem.exceptions.custom;

import turocha.aleksander.banksystem.exceptions.NotFoundException;

public class AccountNotFound extends NotFoundException {
    public AccountNotFound(String message) {
        super(message);
    }
}
