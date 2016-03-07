package main;

import org.jibble.pircbot.IrcException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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

    private JTextField tf19;

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

    private JButton jb16; //mod incre points
    private JButton jb17; //mod incre points

    private JPanel jpContainer;//holds containerTop and BottomSplit
    private JPanel jpContainerLeft;//holds topSetters and topSetters 2
    private JPanel jpLeftTop;
    private JPanel jpLeftBottom;
    private JPanel jpContainerRight;
    private JPanel jpRightTop;// holds 4 and 5
    private JPanel jpRightTopLabels;//holds labels so avoid awkward sized stuff
    private JPanel jpRightTopIncrementers;//holds incrementers for points updating
    private JLabel jl1;
    private JLabel jl2;
    private JLabel jl3;
    private JLabel jl4;
    private JLabel jl5;
    private JLabel jl6;

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
        jpContainer.setLayout(new BoxLayout(jpContainer,BoxLayout.X_AXIS));
        jpContainerLeft = new JPanel(new GridLayout(2,1));

        jpLeftTop = new JPanel(new GridLayout(4,2));//row,col
        TitledBorder channelconfig = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Channel Settings");
        channelconfig.setTitlePosition(TitledBorder.CENTER);
        jpLeftTop.setBorder(channelconfig);

        jpLeftBottom = new JPanel(new GridLayout(7,3));//row,col
        TitledBorder rankTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Ranks");
        rankTitle.setTitlePosition(TitledBorder.CENTER);
        jpLeftBottom.setBorder(rankTitle);

        jpContainerRight = new JPanel(new GridLayout(2,1));//row,col
        jpRightTop = new JPanel(new FlowLayout());
        jpRightTopLabels = new JPanel(new GridLayout(2,1));//row,col
        jpRightTopIncrementers = new JPanel(new GridLayout(2,3));//row,col

        jl1 = new JLabel("Point Update Freq. (min):");
        jl2 = new JLabel("Point Update amount:");
        jl6 = new JLabel("Mod Bonus Points:");

        tf1 = new JTextField(p.getChannel(),15);
        tf2 = new JTextField(p.getUsername(),20);
        tf3 = new JTextField(p.getOauthT(),20);
        tf4 = new JTextField(p.getCurrencyNameT(),20);
        tf5 = new JTextField(String.valueOf(p.getTimerRewardsUpdateDelay()),3);
        tf5.setEditable(false);
        tf6 = new JTextField(String.valueOf(p.getPointIncrememnet()),3);
        tf6.setEditable(false);
        jb1 = new JButton("Set Channel");
        jb2 = new JButton("Set Bot's Username");
        jb3 = new JButton("Set OAuth");
        jb4 = new JButton("Set Currency Name");
        jb5 = new JButton("Connect");
        jb6 = new JButton("+");
        jb7 = new JButton("-");
        jb8 = new JButton("+");
        jb9 = new JButton("-");

        tf19 = new JTextField(" ",3);
        tf19.setEditable(false);
        jb16 = new JButton("+");//mod bonus
        jb17 = new JButton("-");//mod bonus

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
        jl5 = new JLabel("keep rank req's ascending");

        tf7 = new JTextField(p.getRankOneName(),20);
        tf8 = new JTextField(p.getRankTwoName(),20);
        tf9 = new JTextField(p.getRankThreeName(),20);
        tf10 = new JTextField(p.getRankFourName(),20);
        tf11 = new JTextField(p.getRankFiveName(),20);
        tf12 = new JTextField(p.getRankSixName(),20);

        tf13 = new JTextField(String.valueOf(p.getRankOneReq()),20);
        tf14 = new JTextField(String.valueOf(p.getRankTwoReq()),20);
        tf15 = new JTextField(String.valueOf(p.getRankThreeReq()),20);
        tf16 = new JTextField(String.valueOf(p.getRankFourReq()),20);
        tf17 = new JTextField(String.valueOf(p.getRankFiveReq()),20);
        tf18 = new JTextField(String.valueOf(p.getRankSixReq()),20);

        jb10 = new JButton("Set Rank 1");
        jb10.addActionListener(new ALSetRankOne());
        jb11 = new JButton("Set Rank 2");
        jb11.addActionListener(new ALSetRankTwo());
        jb12 = new JButton("Set Rank 3");
        jb12.addActionListener(new ALSetRankThree());
        jb13 = new JButton("Set Rank 4");
        jb13.addActionListener(new ALSetRankFour());
        jb14 = new JButton("Set Rank 5");
        jb14.addActionListener(new ALSetRankFive());
        jb15 = new JButton("Set Rank 6");
        jb15.addActionListener(new ALSetRankSix());

        frame.add(jpContainer);
        jpContainer.add(jpContainerLeft);
        jpContainer.add(jpContainerRight);
        jpContainerLeft.add(jpLeftTop);
        jpContainerLeft.add(jpLeftBottom);
        jpLeftTop.add(tf1);
        jpLeftTop.add(jb1);
        jpLeftTop.add(tf2);
        jpLeftTop.add(jb2);
        jpLeftTop.add(tf3);
        jpLeftTop.add(jb3);
        jpLeftTop.add(tf4);
        jpLeftTop.add(jb4);

        jpLeftBottom.add(jl3);
        jpLeftBottom.add(jl4);
        jpLeftBottom.add(jl5);

        jpLeftBottom.add(tf7);
        jpLeftBottom.add(tf13);
        jpLeftBottom.add(jb10);
        jpLeftBottom.add(tf8);
        jpLeftBottom.add(tf14);
        jpLeftBottom.add(jb11);
        jpLeftBottom.add(tf9);
        jpLeftBottom.add(tf15);
        jpLeftBottom.add(jb12);
        jpLeftBottom.add(tf10);
        jpLeftBottom.add(tf16);
        jpLeftBottom.add(jb13);
        jpLeftBottom.add(tf11);
        jpLeftBottom.add(tf17);
        jpLeftBottom.add(jb14);
        jpLeftBottom.add(tf12);
        jpLeftBottom.add(tf18);
        jpLeftBottom.add(jb15);

        jpContainerRight.add(jpRightTop);//add top half of bottom
        jpRightTop.add(jpRightTopLabels);
        jpRightTop.add(jpRightTopIncrementers);

        jpRightTopLabels.add(jl1);
        jpRightTopLabels.add(jl2);

        jpRightTopIncrementers.add(jb6);
        jpRightTopIncrementers.add(tf5);
        jpRightTopIncrementers.add(jb7);

        jpRightTopIncrementers.add(jb8);
        jpRightTopIncrementers.add(tf6);
        jpRightTopIncrementers.add(jb9);

        jpContainerRight.add(jb5); //adds connect

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
            tf6.setText(String.valueOf(p.getPointIncrememnet()));
        }
    }
    public class ALPointsMinus implements ActionListener {//-Points
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = p.getPointIncrememnet();
            if(i>1){
                --i;
                p.setPointIncrememnet(i,true);
                tf6.setText(String.valueOf(p.getPointIncrememnet()));
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
            p.setRankThreeReq(Double.parseDouble(tf15.getText()),true);
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
