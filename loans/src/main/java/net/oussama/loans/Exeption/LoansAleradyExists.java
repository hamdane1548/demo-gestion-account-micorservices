package net.oussama.loans.Exeption;

public class LoansAleradyExists extends RuntimeException {
    public LoansAleradyExists(String message) {
        super(message);
    }
}
