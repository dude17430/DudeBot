package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dude1_000 on 3/2/2016.
 */
public class GUIManager {

    private Primary p;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;

    public GUIManager(Primary pr){
        p=pr;

        construct();
    }

    private void construct(){
        JFrame frame = new JFrame("DudeBot v: 0.0.1");
        frame.setVisible(true);
        frame.setResizable(true);

        tf1 = new JTextField("Channel",15);
        tf2 = new JTextField("Bot OAuth",20);
        tf3 = new JTextField("Currency Name",20);
        jb1 = new JButton("Set Channel");
        jb2 = new JButton("Set OAuth");
        jb3 = new JButton("Set Currency Name");

        jb1.addActionListener(new AL1());
        jb2.addActionListener(new AL2());
        jb3.addActionListener(new AL3());

        frame.setLayout(new GridLayout(3,2));//row,col
        frame.add(tf1);
        frame.add(jb1);
        frame.add(tf2);
        frame.add(jb2);
        frame.add(tf3);
        frame.add(jb3);

        frame.pack();
    }
    public class AL1 implements ActionListener {//channel

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = tf1.getText();
            System.out.println(text);
        }
    }
    public class AL2 implements ActionListener {//OAuth

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class AL3 implements ActionListener {//Currency Name

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
