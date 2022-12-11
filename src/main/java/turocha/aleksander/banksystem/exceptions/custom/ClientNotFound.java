package turocha.aleksander.banksystem.exceptions.custom;

import turocha.aleksander.banksystem.exceptions.NotFoundException;

public class ClientNotFound extends NotFoundException {
    public ClientNotFound(String message) {
        super(message);
    }
}
