package ro.tuc.tp.GUI;

import ro.tuc.tp.Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller extends JFrame{

    private View view;
    private Operatii op = new Operatii();
    private Polinom p1;
    private Polinom p2;

    public void start(){
        view = new View();
        view.setVisible(true);
        initButtons();
    }
    public Polinom patternMatching(String input){
        Pattern p =Pattern.compile("(-?\\d+)[xX]\\^(\\-?\\d+)");
        Matcher m = p.matcher(input);
        Polinom poly = new Polinom();
        Monom monom;
        int  exponent;
        Number coeficient;
        while(m.find()){
            int xPos = m.group(0).indexOf("X");
            coeficient = Double.parseDouble(m.group(1).substring(0,xPos));
            exponent = Integer.parseInt(m.group(2).substring(0));
            monom = new Monom(exponent, coeficient);
            poly.adaugaMonom(monom);
        }
        return poly;
    }
    public void initButtons(){
        view.addOkFactor1ActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                p1 = new Polinom();
                try{
                    p1 = patternMatching(view.getFactor1());
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Probleeem at pattern matching!!!");
               }
            }

        });

        view.addOkFactor2ActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                p2 = new Polinom();
                try{
                    p2 = patternMatching(view.getFactor2());
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Probleeem at pattern matching!!!");
                }
            }

        });
        view.adunareActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom suma = new Polinom();
               try{
                    suma = op.adunare(p1,p2);
                    view.setRezultatIntreg(suma.afisare());
                    view.setRezultatReal(suma.afisareReal());
               } catch(Exception ex){
                   JOptionPane.showMessageDialog(null, "Probleeem at addition!!!");
                }
            }
        });
        view.scadereActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom diferenta = new Polinom();
              try{
                    diferenta = op.scadere(p1,p2);
                    view.setRezultatIntreg(diferenta.afisare());
                    view.setRezultatReal(diferenta.afisareReal());
                } catch(Exception ex){
                  JOptionPane.showMessageDialog(null, "Probleeem at subtraction!!!");
                }
            }
        });

        view.inmultireActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom produs = new Polinom();
                try{
                    produs = op.inmultire(p1,p2);
                    view.setRezultatReal(produs.afisareReal());
                    view.setRezultatIntreg(produs.afisare());
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Probleeem at multiplication!!!");
                }
            }
        });

        view.impartireActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom cat = new Polinom();
                Polinom rest = new Polinom();
                Polinom[] rezultat = new Polinom[2];
               try{
                    rezultat = op.impartire(p1,p2);
                    cat = rezultat[0];
                    rest = rezultat[1];
                    if(!rest.afisare().equals("")) {
                        view.setRezultatIntreg(cat.afisare() + " Rest: " + rest.afisare());
                        view.setRezultatReal(cat.afisareReal() + " Rest: " + rest.afisareReal());
                        }
                    else {view.setRezultatIntreg(cat.afisare());
                        view.setRezultatReal(cat.afisareReal());}
               } catch(Exception ex) {
                   JOptionPane.showMessageDialog(null, "Probleeem at division!!!");
                }
            }
        });
        view.derivareActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom rez = new Polinom();
                try{
                    rez = op.derivare(p1);
                    view.setRezultatIntreg(rez.afisare());
                    view.setRezultatReal(rez.afisareReal());
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Probleeem at derivative!!!");
                }
            }
        });

        view.integrareActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom rez = new Polinom();
                try{
                    rez = op.integrare(p1);
                    view.setRezultatReal(rez.afisareReal());
                    view.setRezultatIntreg(rez.afisare());
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Probleeem at integration!!!");
                }
            }
        });

    }
}
