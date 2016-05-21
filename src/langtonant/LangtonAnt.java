/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package langtonant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *
 * @author Aleksandra Wyszecka
 * @author Damian Winczewski
 */


public class LangtonAnt {
    //INICJALIZACJA CONTROLOWANIA
        JButton Start, Stop, AddingAnt, GoTo;
        JTextField Counter, AddingSteps;
        JLabel StepLabel;
        DrawArea drawArea;

    public static void main(String[] args) {
           new LangtonAnt().show();
    }

    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            long aSteps;
            long aStepsToJump;
            
            if(e.getSource() == Start){ //Start wyrysowywania
                //
            }else if(e.getSource() == Stop){ //Zatrzymanie wyrysowywania
                //
            }else if(e.getSource() == AddingAnt){ //Dodawanie mrówki
                //
            }else if(e.getSource() == GoTo){ //Przeskok o ilość kroków - do wyrysowania na raz jakiejś liczby kroków
                aSteps = Long.parseLong(Counter.getText());    
                aStepsToJump = Long.parseLong(AddingSteps.getText());
                Counter.setText(String.valueOf(aSteps += aStepsToJump));
            }
        }
    };
    
    public void show(){
        JFrame frame = new JFrame("LangtonAnt");       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //FULLSCREEN
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        final int screenWidth = screenSize.width;       
        final int screenHeight = screenSize.height;                
        frame.setSize(screenWidth, screenHeight);
        
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
    // create draw area
        drawArea = new DrawArea(content);
 
    // add to content pane
        content.add(drawArea, BorderLayout.CENTER);
 
    // create controls to apply colors and call clear feature
    JPanel controls = new JPanel();
    GridBagLayout layout = new GridBagLayout();
 //   controls.setLocation(0, 0);
 //   controls.setSize(120, 900);
        
    Start = new JButton("START");
        Start.addActionListener(actionListener);
    Stop = new JButton("STOP");
        Stop.addActionListener(actionListener);
    AddingAnt = new JButton("ADD ANT");
        AddingAnt.addActionListener(actionListener);
    GoTo = new JButton("DO STEPS");
        GoTo.addActionListener(actionListener);

    Counter = new JTextField(10); 
        Counter.setText(String.valueOf(0));
    AddingSteps = new JTextField(10);

    StepLabel = new JLabel("STEPS: ");    

    //Przyciski
        Start.setBounds(10, 10, 100, 40);
        Stop.setBounds(10, 60, 100, 40);
    //Licznik kroków
        StepLabel.setBounds(40, 100, 50, 30);                     
        Counter.setBounds(10, 130, 100, 30);
    //Dodawanie mrówki    
        AddingAnt.setBounds(10, 170, 100, 40);
            
    //przeskok o liczbę kroków
        AddingSteps.setBounds(10, 220, 100, 30);           
        GoTo.setBounds(10, 260, 100, 40);
    
    controls.add(Start);
    controls.add(Stop);
    controls.add(AddingAnt);
    controls.add(GoTo);
    controls.add(Counter);
    controls.add(AddingSteps);
    controls.add(StepLabel);
    
    content.add(controls, BorderLayout.EAST);    
    frame.setVisible(true);
    }
}

class DrawArea extends JComponent{
    DrawArea(Container content){
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(100,100,100,100);
        panel.setVisible(true);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        content.add(panel);
    }
}

