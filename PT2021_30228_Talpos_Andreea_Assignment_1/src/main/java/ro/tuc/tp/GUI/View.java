package ro.tuc.tp.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends Controller{
        private JLabel operations;
        private JButton adunare;
        private JButton scadere;
        private JButton inmultire;
        private JButton impartire;
        private JButton derivare;
        private JButton integrare;
        private JButton okFactor1;
        private JButton okFactor2;

        private JLabel title;
        private JLabel factor1;
        private JTextField factor1TextField;

        private JLabel factor2;
        private JTextField factor2TextField;

        private JLabel resultInteger;
        private JLabel integerResult;
        private JLabel doubleResult;
        private JLabel resultDouble;

        private JLabel observatii1;
        private JLabel observatii2;
        public View(){
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.getContentPane().setLayout(null);
                this.getContentPane().setBackground(new Color(216,145,130));
                this.setBounds(300,300,500,400);
                Font fontMare = new Font("Book Antiqua",Font.BOLD,22);
                Font fontMic = new Font("Book Antiqua",Font.BOLD,18);
                Font fontOk = new Font("Book Antiqua",Font.PLAIN,16);
                title = new JLabel("Calculator Polinomial");
                title.setFont(fontMare);
                title.setBounds(120,10, 300,30);
                getContentPane().add(title);

                factor1 = new JLabel("Polinom 1:");
                factor1.setFont(fontMic);
                factor1.setBounds(20,45,100,30);
                getContentPane().add(factor1);
                factor1TextField = new JFormattedTextField();
                factor1TextField.setFont(fontMic);
                factor1TextField.setBounds(120, 45, 200, 30);
                getContentPane().add(factor1TextField);

                okFactor1 = new JButton("ok");
                okFactor1.setFont(fontOk);
                okFactor1.setBounds(350,45, 55, 30);
                getContentPane().add(okFactor1);
                okFactor1.setForeground(Color.green);
                okFactor1.setBackground(Color.black);


                factor2 = new JLabel("Polinom 2:");
                factor2.setFont(fontMic);
                factor2.setBounds(20,75,100,30);
                getContentPane().add(factor2);
                factor2TextField = new JFormattedTextField();
                factor2TextField.setFont(fontMic);
                factor2TextField.setBounds(120, 75, 200, 30);
                getContentPane().add(factor2TextField);
                okFactor2 = new JButton("ok");
                okFactor2.setFont(fontOk);
                okFactor2.setBounds(350,75, 55, 30);
                getContentPane().add(okFactor2);
                okFactor2.setForeground(Color.green);
                okFactor2.setBackground(Color.black);

                resultInteger = new JLabel("Rezultat intreg:");
                resultInteger.setFont(fontMic);
                resultInteger.setBounds(20, 120, 350, 30);
                getContentPane().add(resultInteger);
                integerResult= new JLabel();
                integerResult.setFont(fontMic);
                integerResult.setBounds(150,120,350,30);
                getContentPane().add(integerResult);

                resultDouble = new JLabel("Rezultat real:");
                resultDouble.setFont(fontMic);
                resultDouble.setBounds(20, 150, 250, 30);
                getContentPane().add(resultDouble);
                doubleResult= new JLabel();
                doubleResult.setFont(fontMic);
                doubleResult.setBounds(150,150,350,30);
                getContentPane().add(doubleResult);

                operations = new JLabel("Operatii: ");
                operations.setFont(fontMic);
                operations.setBounds(20, 200, 200, 30);
                getContentPane().add(operations);
                observatii1 = new JLabel("Atentie!! Polinoamele se introduc sub forma: ");
                observatii1.setFont(fontMic);
                observatii1.setBounds(10, 285, 600, 30);
                getContentPane().add(observatii1);
                observatii2 = new JLabel("c0X^e0+/-c1X^e1+/-... , unde c0,c1.. e0, e1..sunt nr intregi");
                observatii2.setFont(fontMic);
                observatii2.setBounds(10, 310, 600, 30);
                getContentPane().add(observatii2);
                ///Butoanee
                adunare = new JButton("+");
                adunare.setFont(fontMare);
                adunare.setBounds(20,240, 50, 50);
                getContentPane().add(adunare);
                adunare.setForeground(Color.white);
                adunare.setBackground(Color.black);

                scadere = new JButton("-");
                scadere.setFont(fontMare);
                scadere.setBounds(80,240, 50, 50);
                getContentPane().add(scadere);
                scadere.setForeground(Color.white);
                scadere.setBackground(Color.black);

                inmultire = new JButton("•");
                inmultire.setFont(fontMare);
                inmultire.setBounds(140,240, 50, 50);
                getContentPane().add(inmultire);
                inmultire.setForeground(Color.white);
                inmultire.setBackground(Color.black);

                impartire = new JButton("/");
                impartire.setFont(fontMare);
                impartire.setBounds(200,240, 50, 50);
                getContentPane().add(impartire);
                impartire.setForeground(Color.white);
                impartire.setBackground(Color.black);

                integrare = new JButton("\u222B");
                integrare.setFont(fontMare);
                integrare.setBounds(260,240, 50, 50);
                getContentPane().add(integrare);
                integrare.setForeground(Color.white);
                integrare.setBackground(Color.black);

                derivare = new JButton("( )'");
                derivare.setFont(fontMare);
                derivare.setBounds(320,240, 60, 50);
                getContentPane().add(derivare);
                derivare.setForeground(Color.white);
                derivare.setBackground(Color.black);

        }
        //Polinoame get
        public String getFactor1(){
                return factor1TextField.getText();
        }
        public String getFactor2(){
                return factor2TextField.getText();
        }

        //butoane
        public void addOkFactor1ActionListener(final ActionListener listener){
                okFactor1.addActionListener(listener);
        }
        public void addOkFactor2ActionListener(final ActionListener listener){
                okFactor2.addActionListener(listener);
        }
        public void adunareActionListener(final ActionListener listener){
                adunare.addActionListener(listener);
        }
        public void scadereActionListener(final ActionListener listener){
                scadere.addActionListener(listener);
        }
        public void inmultireActionListener(final ActionListener listener){
                inmultire.addActionListener(listener);
        }
        public void impartireActionListener(final ActionListener listener){
                impartire.addActionListener(listener);
        }
        public void integrareActionListener(final ActionListener listener){
                integrare.addActionListener(listener);
        }
        public void derivareActionListener(final ActionListener listener){
                derivare.addActionListener(listener);
        }
        // rezultat set

        public void setRezultatIntreg(String rezultat){
                integerResult.setText(rezultat);
        }
        public void setRezultatReal(String rezultat){
                doubleResult.setText(rezultat);
        }

}
