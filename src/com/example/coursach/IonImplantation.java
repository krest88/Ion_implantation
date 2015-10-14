package com.example.coursach;

public class IonImplantation {

    public double K = 1;
    //these variables named like this because of book`s explanation
    public double A = 0;
    public double a0 = 0;
    public double b0 = 0;
    public double b1 = 0;
    public double b2 = 0;
    public void A(double gamma, double beta){
        this.A = 10*beta-12*gamma*gamma-18;
    }
    public void a0(double gamma, double beta, double dRp){
        this.a0 = -(dRp*gamma*(beta+3)/this.A);
    }
    public void b0(double gamma, double beta, double dRp){
        this.b0 = -(dRp*(4*beta-3*gamma*gamma)/this.A);
    }
    public void b1(){
        this.b1 = a0;
    }
    public void b2(double gamma, double beta, double dRp){
        this.b2 = -(2*beta-3*gamma*gamma-dRp)/this.A;
    }

    public void setData(double gamma, double beta, double dRp){
        this.A(gamma, beta);
        this.a0(gamma, beta, dRp);
        this.b0(gamma, beta, dRp);
        this.b1();
        this.b2(gamma, beta, dRp);
    }

    public IonImplantation(String ion, double dose, double energy){
        IonInformation ionInf = new IonInformation(ion);
        setData(ionInf.gamma, ionInf.beta, ionInf.dRp);
        double answer;
    }
}
