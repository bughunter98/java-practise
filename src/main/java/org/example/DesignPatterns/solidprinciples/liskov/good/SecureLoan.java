package org.example.DesignPatterns.solidprinciples.liskov.good;

public interface SecureLoan extends LoanPayment{
    public void foreCloseLoan();
}
