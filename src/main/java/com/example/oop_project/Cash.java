package com.example.oop_project;

public class Cash implements PaymentMethod{
    private Double AmountToBePaid;

    public Cash(Double amountToBePaid) {
        AmountToBePaid = amountToBePaid;
    }

    @Override
    public String pay() {
        return "A Total Of "+AmountToBePaid+" is to Be Paid By Cash On Delivery";
        // Cash On Delivery Payment Implementation is to be added here in future updates
    }
}
