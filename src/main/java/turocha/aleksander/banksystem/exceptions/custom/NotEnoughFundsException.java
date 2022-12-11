package turocha.aleksander.banksystem.exceptions.custom;

public class NotEnoughFundsException extends RuntimeException {
    public NotEnoughFundsException(String message) {
        super(message);
    }
}
