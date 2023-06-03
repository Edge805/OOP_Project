package com.example.oop_project;

import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<GeneralGroceries> generalGroceries;
    public void AddToCart(GeneralGroceries gg){
        generalGroceries.add(gg);
    }
    public void RemoveFromCart(GeneralGroceries gg){
        generalGroceries.remove(gg);
    }

    public ShoppingCart() {
        this.generalGroceries = new ArrayList<GeneralGroceries>();
    }

    public ArrayList<GeneralGroceries> getGeneralGroceries() {
        return generalGroceries;
    }

    public void setGeneralGroceries(ArrayList<GeneralGroceries> generalGroceries) {
        this.generalGroceries = generalGroceries;
    }
    @Override
    public String toString()
    {
        String OurRecipt ="";
        for(GeneralGroceries grocery : generalGroceries)
        {
            OurRecipt += " " + "You Bought " + grocery.getName() + "Of Price " + grocery.getPrice() + "Of Quantity " +grocery.getQuantity() + "\n";
        }
        OurRecipt += " Thank you for using our program :)";
        return OurRecipt;
    }
    public Double TotalToBePaid()
    {
        Double OurReciptTotal = 0.0;
        for(GeneralGroceries grocery : generalGroceries)
        {
            OurReciptTotal += (grocery.getPrice()) * (grocery.getQuantity());
        }
        return OurReciptTotal;
    }

}
