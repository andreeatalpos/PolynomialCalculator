package ro.tuc.tp.Model;

public class Monom extends Polinom implements Comparable<Monom>{
    private boolean adaugat;
    private int exponent;
    private Number coeficient;

    public Monom(int exp, Number coef) {
        exponent = exp;
        coeficient = coef;
    }

    public int getExponent() {
        return exponent;
    }

    public void setCoeficient(Number coeficient) {
        this.coeficient = coeficient;
    }

    public Number getCoeficient() {
        return coeficient;
    }
    public void setAdaugat(boolean adaugat){
        this.adaugat = adaugat;
    }
    public boolean getAdaugat(){
        return adaugat;
    }
    public int compareTo(Monom m){
        if(m.getExponent()>exponent)
            return 1;
        if(m.getExponent() == exponent)
            return 0;
        else return -1;
    }

    public String toString() {
        if (exponent > 0){
            if(coeficient.intValue() >0){
                return "+"+ coeficient.intValue()+ "*X^" + exponent;}
            else if(coeficient.intValue() <0)
                return coeficient.intValue() + "*X^"+ exponent;
        }
        else {
            if(exponent == 0){
                if(coeficient.intValue()>=1)
                    return "+" + coeficient.intValue();
                else if (coeficient.intValue() <0) return ""+coeficient.intValue();
            }
        }
        return "";
    }
    public String toStringReal() {
        //String s = String.format("%.1f", coeficient);
        if (exponent > 0){
            if(coeficient.floatValue() >0){
                return "+"+ coeficient.floatValue()+ "*X^" + exponent;}
            else if(coeficient.floatValue() <0)
                return coeficient.floatValue() + "*X^"+ exponent;
        }
        else {
            if(exponent == 0){
                if(coeficient.floatValue()>=1)
                    return "+" + coeficient.floatValue()+"";
                else if (coeficient.floatValue() <0) return "" +coeficient.floatValue();
            }
        }
        return "";
    }
}
