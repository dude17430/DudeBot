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

    private JTextField tf7;
    private JTextField tf8;
    private JTextField tf9;
    private JTextField tf10;
    private JTextField tf11;
    private JTextField tf12;

    private JTextField tf13;
    private JTextField tf14;
    private JTextField tf15;
    private JTextField tf16;
    private JTextField tf17;
    private JTextField tf18;

    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;

    private JButton jb10;
    private JButton jb11;
    private JButton jb12;
    private JButton jb13;
    private JButton jb14;
    private JButton jb15;

    private JPanel jpContainer;//holds containerTop and BottomSplit
    private JPanel jpContainerTop;//holds topSetters and topSetters 2
    private JPanel jpTopSetters;
    private JPanel jpTopSetters2;
    private JPanel jpBottomSplit;
    private JPanel jp3;// holds 4 and 5
    private JPanel jp4;//holds labels so avoid awkward sized stuff
    private JPanel jp5;//holds incrementers for points updating
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;

    public GUIManager(Primary pr){
        p=pr;

        construct();
    }

    private void construct(){
        JFrame frame = new JFrame("DudeBot v: 0.0.6a");
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());//row,col
        jpContainer = new JPanel();
        jpContainer.setLayout(new BoxLayout(jpContainer,BoxLayout.Y_AXIS));
        jpContainerTop = new JPanel(new GridLayout(1,2));
        jpTopSetters = new JPanel(new GridLayout(5,2));//row,col
        jpTopSetters2 = new JPanel(new GridLayout(7,3));//row,col
        jpBottomSplit = new JPanel(new GridLayout(2,1));//row,col
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

        jb1.addActionListener(new ALSetChannel());
        jb2.addActionListener(new ALSetUsername());
        jb3.addActionListener(new ALSetOAuth());
        jb4.addActionListener(new ALSetCurrencyName());
        jb5.addActionListener(new ALConnect());
        jb6.addActionListener(new ALPointFreqAdd());
        jb7.addActionListener(new ALPointFreqMinus());
        jb8.addActionListener(new ALPointsAdd());
        jb9.addActionListener(new ALPointsMinus());


        jl3 = new JLabel("Rank Name");
        jl4 = new JLabel("Required Hours (decimal allowed)");
        jl5 = new JLabel("");

        tf7 = new JTextField("r1 name",20);
        tf8 = new JTextField("r2 name",20);
        tf9 = new JTextField("r3 name",20);
        tf10 = new JTextField("r4 name",20);
        tf11 = new JTextField("r5 name",20);
        tf12 = new JTextField("r6 name",20);

        tf13 = new JTextField("r1 requirement",20);
        tf14 = new JTextField("r2 requirement",20);
        tf15 = new JTextField("r3 requirement",20);
        tf16 = new JTextField("r4 requirement",20);
        tf17 = new JTextField("r5 requirement",20);
        tf18 = new JTextField("r6 requirement",20);

        jb10 = new JButton("Set Rank 1");
        jb11 = new JButton("Set Rank 2");
        jb12 = new JButton("Set Rank 3");
        jb13 = new JButton("Set Rank 4");
        jb14 = new JButton("Set Rank 5");
        jb15 = new JButton("Set Rank 6");

        frame.add(jpContainer);
        jpContainer.add(jpContainerTop);
        jpContainer.add(jpBottomSplit);
        jpContainerTop.add(jpTopSetters);
        jpContainerTop.add(jpTopSetters2);
        jpTopSetters.add(tf1);
        jpTopSetters.add(jb1);
        jpTopSetters.add(tf2);
        jpTopSetters.add(jb2);
        jpTopSetters.add(tf3);
        jpTopSetters.add(jb3);
        jpTopSetters.add(tf4);
        jpTopSetters.add(jb4);

        jpTopSetters2.add(jl3);
        jpTopSetters2.add(jl4);
        jpTopSetters2.add(jl5);

        jpTopSetters2.add(tf7);
        jpTopSetters2.add(tf13);
        jpTopSetters2.add(jb10);
        jpTopSetters2.add(tf8);
        jpTopSetters2.add(tf14);
        jpTopSetters2.add(jb11);
        jpTopSetters2.add(tf9);
        jpTopSetters2.add(tf15);
        jpTopSetters2.add(jb12);
        jpTopSetters2.add(tf10);
        jpTopSetters2.add(tf16);
        jpTopSetters2.add(jb13);
        jpTopSetters2.add(tf11);
        jpTopSetters2.add(tf17);
        jpTopSetters2.add(jb14);
        jpTopSetters2.add(tf12);
        jpTopSetters2.add(tf18);
        jpTopSetters2.add(jb15);

        jpBottomSplit.add(jp3);//add top half of bottom
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

        jpBottomSplit.add(jb5); //adds connect

        frame.pack();
    }
    public class ALSetChannel implements ActionListener {//channel
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setChannel(tf1.getText(), true);
        }
    }
    public class ALSetUsername implements ActionListener {//Username
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setUsername(tf2.getText(), true);
        }
    }
    public class ALSetOAuth implements ActionListener {//OAuth
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setOauth(tf3.getText(), true);
        }
    }
    public class ALSetCurrencyName implements ActionListener {//Currency Name
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setCurrencyName(tf4.getText(), true);
        }
    }
    public class ALConnect implements ActionListener {//Connect
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
    public class ALPointFreqAdd implements ActionListener {//+Points Update Freq.
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getTimerRewardsUpdateDelay();
            ++i;
            p.setTimerRewardsUpdateDelay(i,true);
            tf5.setText(String.valueOf(p.getTimerRewardsUpdateDelay()));
            p.resetTimers();
        }
    }
    public class ALPointFreqMinus implements ActionListener {//-Points Update Freq.
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
    public class ALPointsAdd implements ActionListener {//+Points
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getPointIncrememnet();
            ++i;
            p.setPointIncrememnet(i,true);
            tf6.setText(String.valueOf(p.getTimerRewardsUpdateDelay()));
        }
    }
    public class ALPointsMinus implements ActionListener {//-Points
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
    public class ALSetRankOne implements ActionListener {//r1set
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setRankOneName(tf7.getText(),true);
            p.setRankOneReq(Double.parseDouble(tf13.getText()),true);
        }
    }
    public class ALSetRankTwo implements ActionListener {//r1set
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setRankTwoName(tf8.getText(),true);
            p.setRankTwoReq(Double.parseDouble(tf14.getText()),true);
        }
    }
    public class ALSetRankThree implements ActionListener {//r1set
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setRankThreeName(tf9.getText(),true);
            p.setRankThreeReq(Double.parseDouble(tf13.getText()),true);
        }
    }
    public class ALSetRankFour implements ActionListener {//r1set
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setRankFourName(tf10.getText(),true);
            p.setRankFourReq(Double.parseDouble(tf15.getText()),true);
        }
    }
    public class ALSetRankFive implements ActionListener {//r1set
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setRankFiveName(tf11.getText(),true);
            p.setRankFiveReq(Double.parseDouble(tf16.getText()),true);
        }
    }
    public class ALSetRankSix implements ActionListener {//r1set
        @Override
        public void actionPerformed(ActionEvent e) {
            p.setRankSixName(tf12.getText(),true);
            p.setRankSixReq(Double.parseDouble(tf17.getText()),true);
        }
    }
}
