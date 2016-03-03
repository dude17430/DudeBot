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
    private JTextField tf4;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;

    public GUIManager(Primary pr){
        p=pr;

        construct();
    }

    private void construct(){
        JFrame frame = new JFrame("DudeBot v: 0.0.1");
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf1 = new JTextField(p.getChannelT(),15);
        tf2 = new JTextField(p.getUsername(),20);
        tf3 = new JTextField(p.getOauthT(),20);
        tf4 = new JTextField(p.getCurrencyNameT(),20);
        jb1 = new JButton("Set Channel");
        jb2 = new JButton("Set Bot's Username");
        jb3 = new JButton("Set OAuth");
        jb4 = new JButton("Set Currency Name");
        jb5 = new JButton("Connect");

        jb1.addActionListener(new AL1());
        jb2.addActionListener(new AL2());
        jb3.addActionListener(new AL3());
        jb4.addActionListener(new AL4());
        jb5.addActionListener(new AL5());

        frame.setLayout(new GridLayout(5,2));//row,col
        frame.add(tf1);
        frame.add(jb1);
        frame.add(tf2);
        frame.add(jb2);
        frame.add(tf3);
        frame.add(jb3);
        frame.add(tf4);
        frame.add(jb4);
        frame.add(jb5);

        frame.pack();
    }
    public class AL1 implements ActionListener {//channel

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setChannel(tf1.getText(), true);
            //TODO: Channel setting, config
        }
    }
    public class AL2 implements ActionListener {//OAuth

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setUsername(tf2.getText(), true);
            //TODO: OAuth setting, config
        }
    }
    public class AL3 implements ActionListener {//Currency Name

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setOauth(tf3.getText(), true);
            //TODO: Currency Name setting, config
        }
    }
    public class AL4 implements ActionListener {//Currency Name

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setCurrencyName(tf4.getText(), true);
            //TODO: Currency Name setting, config
        }
    }
    public class AL5 implements ActionListener {//Connect

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: implement connect
        }
    }
}
