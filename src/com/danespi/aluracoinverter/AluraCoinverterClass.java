package com.danespi.aluracoinverter;

public class AluraCoinverterClass {
    double totalBalance = 0;

    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * @param depositAmount
     * @return double totalBalance if depositAmount is greater than 0, otherwise return 0
     */
    public double depositAmount(double depositAmount) {
        if(depositAmount > 0) {
            this.totalBalance += depositAmount;
            return this.totalBalance;
        } else {
            return 0;
        }
    }

    public double withdrawAmount(double withdrawAmount) {
        if(withdrawAmount > 0) {
            this.totalBalance -= withdrawAmount;
            return this.totalBalance;
        } else {
            return 0;
        }
        
    }
}
