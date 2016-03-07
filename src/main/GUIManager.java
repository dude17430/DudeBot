package main;

import org.jibble.pircbot.IrcException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by dude1_000 on 3/2/2016.
 */
public class GUIManager {

    private Primary p;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JPanel jp4;
    private JPanel jp5;
    private JLabel jl1;
    private JLabel jl2;

    public GUIManager(Primary pr){
        p=pr;

        construct();
    }

    private void construct(){
        JFrame frame = new JFrame("DudeBot v: 0.0.5");
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));//row,col
        jp1 = new JPanel(new GridLayout(5,2));//row,col
        jp2 = new JPanel(new GridLayout(2,1));//row,col
        jp3 = new JPanel(new FlowLayout());
        jp4 = new JPanel(new GridLayout(2,1));//row,col
        jp5 = new JPanel(new GridLayout(2,3));//row,col

        jl1 = new JLabel("Point Update Freq. (min):");
        jl2 = new JLabel("Point Update amount:");

        tf1 = new JTextField(p.getChannelT(),15);
        tf2 = new JTextField(p.getUsername(),20);
        tf3 = new JTextField(p.getOauthT(),20);
        tf4 = new JTextField(p.getCurrencyNameT(),20);
        tf5 = new JTextField(String.valueOf(p.getTimerRewardsUpdateDelay()),3);
        tf6 = new JTextField(String.valueOf(p.getPointIncrememnet()),3);
        jb1 = new JButton("Set Channel");
        jb2 = new JButton("Set Bot's Username");
        jb3 = new JButton("Set OAuth");
        jb4 = new JButton("Set Currency Name");
        jb5 = new JButton("Connect");
        jb6 = new JButton("+");
        jb7 = new JButton("-");
        jb8 = new JButton("+");
        jb9 = new JButton("-");

        jb1.addActionListener(new AL1());
        jb2.addActionListener(new AL2());
        jb3.addActionListener(new AL3());
        jb4.addActionListener(new AL4());
        jb5.addActionListener(new AL5());
        jb6.addActionListener(new AL6());
        jb7.addActionListener(new AL7());
        jb8.addActionListener(new AL8());
        jb9.addActionListener(new AL9());

        frame.add(jp1);
        frame.add(jp2);
        jp1.add(tf1);
        jp1.add(jb1);
        jp1.add(tf2);
        jp1.add(jb2);
        jp1.add(tf3);
        jp1.add(jb3);
        jp1.add(tf4);
        jp1.add(jb4);

        jp2.add(jp3);
        jp3.add(jp4);
        jp3.add(jp5);

        jp4.add(jl1);
        jp4.add(jl2);

        jp5.add(jb6);
        jp5.add(tf5);
        jp5.add(jb7);

        jp5.add(jb8);
        jp5.add(tf6);
        jp5.add(jb9);

        jp2.add(jb5);

        frame.pack();
    }
    public class AL1 implements ActionListener {//channel
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setChannel(tf1.getText(), true);
        }
    }
    public class AL2 implements ActionListener {//OAuth
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setUsername(tf2.getText(), true);
        }
    }
    public class AL3 implements ActionListener {//Currency Name
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setOauth(tf3.getText(), true);
        }
    }
    public class AL4 implements ActionListener {//Currency Name
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setCurrencyName(tf4.getText(), true);
        }
    }
    public class AL5 implements ActionListener {//Connect
        @Override //TODO: Disconnect
        public void actionPerformed(ActionEvent e) {
            try {
                p.connect();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (IrcException e1) {
                e1.printStackTrace();
            }
        }
    }
    public class AL6 implements ActionListener {//+Points Update Freq.
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getTimerRewardsUpdateDelay();
            ++i;
            p.setTimerRewardsUpdateDelay(i,true);
            tf5.setText(String.valueOf(p.getTimerRewardsUpdateDelay()));
            p.resetTimers();
        }
    }
    public class AL7 implements ActionListener {//-Points Update Freq.
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getTimerRewardsUpdateDelay();
            if(i>1){
                --i;
                p.setTimerRewardsUpdateDelay(i,true);
                tf5.setText(String.valueOf(p.getTimerRewardsUpdateDelay()));
                p.resetTimers();
            }
        }
    }
    public class AL8 implements ActionListener {//+Points
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getPointIncrememnet();
            ++i;
            p.setPointIncrememnet(i,true);
            tf6.setText(String.valueOf(p.getTimerRewardsUpdateDelay()));
        }
    }
    public class AL9 implements ActionListener {//-Points
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getPointIncrememnet();
            if(i>1){
                --i;
                p.setPointIncrememnet(i,true);
                tf6.setText(String.valueOf(p.getTimerRewardsUpdateDelay()));
            }
        }
    }
}
