package ro.tuc.tp.Model;

import java.util.*;

public class Polinom {
    private List<Monom> polynom = new ArrayList<Monom>();

    public void adaugaMonom (Monom m) {

        polynom.add(m);
    }
    public List<Monom> getPolynom() {
        return polynom;
    }
    public String afisare()
    {
        String result = new String();
        Collections.sort(polynom);
        {
            for(Monom m : polynom){
                 result = result + m.toString();
            }
        }
        return result;

    }
    public String afisareReal()
    {
        String result = new String();
        Collections.sort(polynom);
        {
            for(Monom m : polynom){
                result = result + m.toStringReal();
            }
        }
        return result;

    }
    public int getGrad(){
        int gradMax=0;
        for(Monom m: polynom){
            if(m.getExponent()>gradMax && m.getCoeficient().floatValue()!=0)
                gradMax = m.getExponent();
        }
        return gradMax;

    }
    public Monom findPower(int degree, List<Monom> poly)
    {
        Monom result = null;
        for(Monom m : poly) {
            if (m.getExponent() == degree)
                result = m;
        }
        return result;
    }
}

