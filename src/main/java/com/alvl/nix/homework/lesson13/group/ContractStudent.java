package com.alvl.nix.homework.lesson13.group;

public class ContractStudent extends Student {
    private double contractCost;

    ContractStudent(int age, String name, double contractCost) {
        super(age, name);
        this.contractCost = contractCost;
    }

    public void setContractCost(double contractCost) {
        if (contractCost < 0.0) {
            throw new IllegalArgumentException("Contract cost is negative!");
        }
        this.contractCost = contractCost;
    }
    public double getContractCost()
    {
        return contractCost;
    }
    @Override
    public String toString()
    {
        return "Student - "+getName()+". Age - "+getAge()+". Contract Cost - "+getContractCost()+".";
    }

}
