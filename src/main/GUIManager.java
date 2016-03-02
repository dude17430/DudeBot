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

    public GUIManager(Primary pr){
        p=pr;

        construct();
    }

    private void construct(){
        JFrame frame = new JFrame("DudeBot v: 0.0.1");
        frame.setVisible(true);
        frame.setResizable(true);

        JTextField tf1 = new JTextField("Channel",15);
        JTextField tf2 = new JTextField("Bot OAuth",20);
        JTextField tf3 = new JTextField("Currency Name",20);
        JButton jb1 = new JButton("Set Channel");
        JButton jb2 = new JButton("Set OAuth");
        JButton jb3 = new JButton("Set Currency Name");

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
