package ro.tuc.tp.Model;


import javax.swing.*;
import java.util.Collections;


public class Operatii {

    public Polinom adunare(Polinom p, Polinom q){

        Polinom rezAdd = new Polinom();
        Collections.sort(p.getPolynom());
        Collections.sort(q.getPolynom());
        if(p.getPolynom().isEmpty()) rezAdd = q;
        else if (q.getPolynom().isEmpty()) rezAdd = p;
        else {
            for (Monom m1 : p.getPolynom()) {
                for (Monom m2 : q.getPolynom()) {
                    if (m1.getExponent() == m2.getExponent() && !m1.getAdaugat() && !m2.getAdaugat()) {
                        m1.setAdaugat(true);
                        m2.setAdaugat(true);
                        rezAdd.adaugaMonom(new Monom(m1.getExponent(), m1.getCoeficient().intValue() + m2.getCoeficient().intValue()));
                    }
                }
            }
            for(Monom m: p.getPolynom())
                if(!m.getAdaugat())
                    rezAdd.adaugaMonom(new Monom (m.getExponent(), m.getCoeficient()));
            for(Monom m: q.getPolynom())
                if(!m.getAdaugat()){
                    rezAdd.adaugaMonom(new Monom (m.getExponent(), m.getCoeficient()));
                }
        }
        return rezAdd;
    }

    public Polinom scadere(Polinom p, Polinom q){
        Polinom rezSub = new Polinom();
        Collections.sort(p.getPolynom());
        Collections.sort(q.getPolynom());
        for(Monom m : p.getPolynom())
            m.setAdaugat(false);
        for(Monom m : q.getPolynom())
            m.setAdaugat(false);
        for(Monom m1 : p.getPolynom()) {
            for (Monom m2 : q.getPolynom()) {
                if (m1.getExponent() == m2.getExponent() && !m1.getAdaugat() && !m2.getAdaugat()) {
                    m1.setAdaugat(true);
                    m2.setAdaugat(true);
                    rezSub.adaugaMonom(new Monom(m1.getExponent(), (m1.getCoeficient().intValue() - m2.getCoeficient().intValue())));
                }
            }
        }
        for(Monom m: p.getPolynom())
            if(!m.getAdaugat())
                rezSub.adaugaMonom(new Monom (m.getExponent(), m.getCoeficient()));
        for(Monom m: q.getPolynom())
            if(!m.getAdaugat()){

                rezSub.adaugaMonom(new Monom (m.getExponent(), 0-m.getCoeficient().intValue()));
            }

        return rezSub;
    }
    public Polinom inmultire(Polinom p, Polinom q){
        Collections.sort(p.getPolynom());
        Collections.sort(q.getPolynom());
        Monom degreeSearch;
        Polinom rezMul = new Polinom();
        for(Monom m1 : p.getPolynom()) {
            for (Monom m2 : q.getPolynom()) {
                degreeSearch = rezMul.findPower(m1.getExponent() + m2.getExponent(), rezMul.getPolynom());
                if(degreeSearch == null){
                rezMul.adaugaMonom(new Monom(m1.getExponent() + m2.getExponent(), m1.getCoeficient().intValue() * m2.getCoeficient().intValue()));
               }
                else {
                    rezMul.adaugaMonom(new Monom(degreeSearch.getExponent(), degreeSearch.getCoeficient().intValue() + m1.getCoeficient().intValue() * m2.getCoeficient().intValue()));
                    rezMul.getPolynom().remove(degreeSearch);
                }
            }
        }
        return rezMul;
    }
    public Polinom[] impartire(Polinom p, Polinom q){

        Polinom[] rezultat = new Polinom[2];
        Polinom rezQuotient = new Polinom();
        Polinom rezRemainder = p;
        Collections.sort(p.getPolynom());
        Collections.sort(q.getPolynom());
        for(Monom m : p.getPolynom())
            m.setAdaugat(false);
        for(Monom m : q.getPolynom())
            m.setAdaugat(false);
        int i=p.getGrad();
        int poz=0;
        int max = p.getPolynom().size();
        int j = q.getGrad();
        if(p.getPolynom().get(0).getExponent()< q.getPolynom().get(0).getExponent()) {
            JOptionPane.showMessageDialog(null, "Eroare: nu se poate realiza impartirea => Grad(p) < Grad(q)!!!");
            return null;
        }
        if(q.getPolynom().get(0).getCoeficient().intValue()==0){
            JOptionPane.showMessageDialog(null, "Al doilea polinom nu poate fi zero!");
            return null;
        }
        if(j==0){
            rezQuotient = p;
            for(int k=0; k< rezQuotient.getPolynom().size(); k++)
                rezQuotient.getPolynom().get(k).setCoeficient(p.getPolynom().get(k).getCoeficient().floatValue()/q.getPolynom().get(0).getCoeficient().floatValue());
            rezRemainder= new Monom(0,0);
        }
        else {
            while (i >= j) {
                Monom tmp = new Monom(i - j, rezRemainder.getPolynom().get(poz).getCoeficient().floatValue() / q.getPolynom().get(0).getCoeficient().floatValue());
                rezQuotient.adaugaMonom(tmp);
                poz++;
                Polinom inter = new Polinom();
                inter.adaugaMonom(tmp);
                Polinom rezMul = inmultire(q, inter);
                Polinom tmp2;
                tmp2 = scadere(rezRemainder, rezMul);
                rezRemainder=tmp2;
                i = i - j;
            }
        }
        rezultat[0] = rezQuotient;
        rezultat[1] = rezRemainder;
        return rezultat;
    }
    public Polinom derivare(Polinom p) {
        Polinom rezDerivare = new Polinom();
        for (Monom m : p.getPolynom()) {
            if (m.getExponent() > 0)
                rezDerivare.adaugaMonom(new Monom(m.getExponent() - 1, m.getCoeficient().intValue() * m.getExponent()));
        }
        return rezDerivare;
    }

    public Polinom integrare(Polinom p){
        Polinom rezIntegrare = new Polinom();

        for(Monom m: p.getPolynom()){
            rezIntegrare.adaugaMonom(new Monom(m.getExponent()+1,m.getCoeficient().floatValue()/(m.getExponent()+1)));
        }
        return rezIntegrare;
    }
}
