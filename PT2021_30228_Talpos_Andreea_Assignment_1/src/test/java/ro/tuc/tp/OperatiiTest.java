package ro.tuc.tp;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import ro.tuc.tp.Model.*;

public class OperatiiTest {
    @Test
    public void Test(){
        Operatii op = new Operatii();
        Monom m1 = new Monom(4,1);
        Monom m2 = new Monom(2,2);
        Monom m3 = new Monom(0,5);
        Monom m4 = new Monom(2,1);
        Monom m5 = new Monom(0,1);

        Polinom p = new Polinom();
        Polinom q = new Polinom();
        p.adaugaMonom(m1);
        p.adaugaMonom(m2);
        p.adaugaMonom(m3);
        q.adaugaMonom(m4);
        q.adaugaMonom(m5);

        Monom mm1 = new Monom(5,-2);
        Monom mm2 = new Monom(2,-1);
        Monom mm3 = new Monom(0,7);
        Monom mm4 = new Monom(4,1);
        Monom mm5 = new Monom(1,-3);

        Polinom p1 = new Polinom();
        Polinom q1 = new Polinom();
        p1.adaugaMonom(mm1);
        p1.adaugaMonom(mm2);
        p1.adaugaMonom(mm3);
        q1.adaugaMonom(mm4);
        q1.adaugaMonom(mm5);

        ///p=+1*X^4+2*X^2+5
        ///q=+1*X^2+1
        ///p1=-2*X^5-1*X^2+7
        ///q1=X^4-3*X^1

        //ADUNARE:
        Polinom suma;
        suma = op.adunare(p,q);
        assertTrue(suma.afisare().equals("+1*X^4+3*X^2+6"));
        suma = op.adunare(p1,q1);
        assertTrue(suma.afisare().equals("-2*X^5+1*X^4-1*X^2-3*X^1+7"));

        //SCADERE:
        Polinom diferenta;
        diferenta = op.scadere(p,q);
        assertTrue(diferenta.afisare().equals("+1*X^4+1*X^2+4"));
        diferenta = op.scadere(p1,q1);
        assertTrue(diferenta.afisare().equals("-2*X^5-1*X^4-1*X^2+3*X^1+7"));

        //INMULTIRE:
        Polinom produs;
        produs = op.inmultire(p,q);
        assertTrue(produs.afisare().equals("+1*X^6+3*X^4+7*X^2+5"));
        produs = op.inmultire(p1,q1);
        assertTrue(produs.afisare().equals("-2*X^9+5*X^6+7*X^4+3*X^3-21*X^1"));

        //IMPARTIRE:
        Polinom[] impartire = new Polinom[2];
        Polinom cat;
        Polinom rest;
        impartire = op.impartire(p,q);
        cat = impartire[0];
        rest = impartire[1];
        assertTrue(cat.afisare().equals("+1*X^2+1"));
        assertTrue(rest.afisare().equals("+4"));
        impartire = op.impartire(p1,q1);
        cat = impartire[0];
        rest = impartire[1];
        assertTrue(cat.afisare().equals("-2*X^1"));
        assertTrue(rest.afisare().equals("-7*X^2+7"));

        p.getPolynom().clear();
        q.getPolynom().clear();
        p.adaugaMonom(m1);
        p.adaugaMonom(m2);
        p.adaugaMonom(m3);
        q.adaugaMonom(m4);
        q.adaugaMonom(m5);
        p1.getPolynom().clear();
        q1.getPolynom().clear();
        p1.adaugaMonom(mm1);
        p1.adaugaMonom(mm2);
        p1.adaugaMonom(mm3);
        q1.adaugaMonom(mm4);
        q1.adaugaMonom(mm5);

        //DERIVARE:
        Polinom derivare;
        derivare = op.derivare(p);
        assertTrue(derivare.afisare().equals("+4*X^3+4*X^1"));
        derivare = op.derivare(p1);
        assertTrue(derivare.afisare().equals("-10*X^4-2*X^1"));

        //INTEGRARE:
        Polinom integrare;
        integrare = op.integrare(p);
        assertTrue(integrare.afisareReal().equals("+0.2*X^5+0.6666667*X^3+5.0*X^1"));
        integrare = op.integrare(p1);
        assertTrue(integrare.afisareReal().equals("-0.33333334*X^6-0.33333334*X^3+7.0*X^1"));

}
}
