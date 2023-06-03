package com.example.oop_project;

public class Credit implements PaymentMethod{
    private Double AmountToBePaid;

    public Credit(Double amountToBePaid) {
        AmountToBePaid = amountToBePaid;
    }

    @Override
    public String pay() {
        return "A Total Of "+AmountToBePaid+" is to Be Paid By Credit Please Provide Your Credit Card Number";
        // Credit Card Payment Implementation is to be added here in future updates
    }
}
