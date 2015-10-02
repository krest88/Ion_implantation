package com.example.coursach;

/**
 * Created by ashab_000 on 9/29/2015.
 */
public class IonImplantation {
//    public static void _main(String args[]){
//        System.out.println("asd");
//    }

    public int siAtomNumber = 14;
    public double siConcentration = 5.04e22;
    public double siAtomMass = 28;

    public double R = 0;

    public double Sn(int implAtomNumber, double implAtomMass){
        return 0.278 * implAtomNumber * this.siAtomNumber * implAtomMass * this.siConcentration /
                (Math.sqrt(Math.pow(implAtomNumber, 2/3) + Math.pow(this.siAtomNumber, 2/3)) * (implAtomMass + this.siAtomMass));
    }

    public double Se(double sqrtE, int implAtomNumber, double implAtomMass){
        return 3.28 * 0.001 * (implAtomNumber + this.siAtomNumber) * this.siConcentration * sqrtE / Math.sqrt(implAtomMass);
    }

    public double R(int _energy, int implAtomNumber, double implAtomMass){
        double R = 0;
        double sqrtE = Math.sqrt(_energy);

        for(int e = 0; e < _energy; e+=0.01){
            R = 1/( Sn(implAtomNumber, implAtomMass) + Se(sqrtE, implAtomNumber, implAtomMass));
        }

        this.R = R;
        return R;
    }

    public double Rp(double implAtomMass){
        return this.R/(1+1/(3*(implAtomMass/this.siAtomMass)));
    }

    public double dRp(double implAtomMass){
        return Math.sqrt(2/3 * implAtomMass * this.siAtomMass) * Rp(implAtomMass) / (implAtomMass + this.siAtomMass);
    }

    //public double N(double dose, )

}
