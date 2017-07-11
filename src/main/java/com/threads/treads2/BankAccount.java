package com.threads.treads2;

/**
 * Created by agra on 7/11/2017.
 */
public class BankAccount {
    private  String accountId;
    private  int initAmount;

    public BankAccount(String accountId, int initAmmount) {
        this.accountId = accountId;
        this.initAmount = initAmmount;
    }

    public int getInitAmmount() {
        return initAmount;
    }

    public void deposit(int amount){
      if (amount<=0){
          System.out.println("The amount of deposit must to be > 0, Please correct your amount");
      }else{
          this.initAmount+=amount;
          System.out.println("added "+amount);
      }
    }

    public int withdraw(int ammount){
        if (ammount>this.initAmount){
            System.out.println("Error: Not enought cash");
        }else{
            this.initAmount+=(-ammount);
            System.out.println("withdrawed "+ammount);
        }
        System.out.println("Cash on account is: "+getInitAmmount()) ;
        return getInitAmmount();
    }
}
