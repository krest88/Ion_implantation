package com.example.coursach;

import com.sun.deploy.uitoolkit.ui.ConsoleWindow;

import java.io.Console;
import java.util.logging.ConsoleHandler;

public class IonImplantation {

    private double K = 1;
    private double Rp = 0;
    private double dRp = 0;
    private double dose = 0;
    private double energy = 0;
    //these variables named like this because of book`s explanation
    private double A = 0;
    private double a0 = 0;
    private double b0 = 0;
    private double b1 = 0;
    private double b2 = 0;
    private double _r = 0;
    private double _v = 0;
    private double _a = 0;


    private void _r(double gamma, double beta){
        this._r = (6*(beta-gamma*gamma-1))/(2*beta-3*gamma*gamma-6);
    }
    private void _v(double gamma){
        this._v = -(this._r*(this._r-2)*gamma)/(Math.sqrt(16*(this._r-1)-gamma*gamma*Math.pow(this._r - 2, 2)));
    }
    private void _a(double gamma){
        this._a = Math.sqrt((dRp*dRp/16)*(16*(this._r-1)-gamma*gamma*Math.pow(this._r - 2, 2)));
    }

    public double ConcentrationProfile(double x){
        double answer = this.K*(Math.pow(1+Math.pow(x/this._a,2), -(this._r+2)/2)*Math.exp(-this._v*Math.atan(x/this._a)));

        return answer;
    }


    private void A(double gamma, double beta){
        this.A = 10*beta-12*gamma*gamma-18;
    }
    private void a0(double gamma, double beta, double dRp){
        this.a0 = -(dRp*gamma*(beta+3)/this.A);
    }
    private void b0(double gamma, double beta, double dRp){
        this.b0 = -(dRp*(4*beta-3*gamma*gamma)/this.A);
    }
    private void b1(){
        this.b1 = a0;
    }
    private void b2(double gamma, double beta, double dRp){
        this.b2 = -(2*beta-3*gamma*gamma-dRp)/this.A;
    }

    private void SetData(double gamma, double beta, double dRp, double Rp, double dose, double energy){
        this.A(gamma, beta);
        this.a0(gamma, beta, dRp);
        this.b0(gamma, beta, dRp);
        this.b1();
        this.b2(gamma, beta, dRp);
        this.Rp = Rp;
        this.dRp = dRp;
        this.dose = dose;
        this.energy = energy;

        this._r(gamma, beta);
        this._v(gamma);
        this._a(gamma);
    }

    public IonImplantation(String ion, double dose, double energy){
        IonInformation ionInf = new IonInformation(ion);
        SetData(ionInf.gamma, ionInf.beta, ionInf.dRp, ionInf.Rp, dose, energy);
    }

    public void ChangeData(String ion, double dose, double energy){
        IonInformation ionInf = new IonInformation(ion);
        SetData(ionInf.gamma, ionInf.beta, ionInf.dRp, ionInf.Rp, dose, energy);
    }

    public double getRp(){
        return this.Rp;
    }


//    public double ConcentrationProfile(double x){
//        double answer = this.dose*
//                        (this.K*Math.pow(this.b2*Math.pow(x-this.Rp, 2)+
//                        this.b1*(x-this.Rp)+this.b0, 1/(2*this.b2))
//                        *Math.exp(-(this.b1/this.b2+2*this.a0)/Math.pow(4*this.b2*this.b0-this.b1*this.b1, 0.5)
//                        *Math.atan((2*this.b2*(x-this.Rp)+this.b1)/Math.sqrt(4*this.b2*this.b0-this.b1*this.b1)))
//                );
//
//        return answer;
//    }
}
