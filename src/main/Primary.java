package main;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by dude1_000 on 1/22/2016.
 */
public class Primary {

//    public static final String channel = "";//#dude17430
//    private static final String oauth = "";//oauth:r34jjki08jh8xwpimdnp596xcoaqrm
//    public static final String currencyName = "";//Dude Points

    private TwitchBot bot;
    private int timerRewardsUpdateDelay = 5;
    private int timerHoursUpdateDelay = 1;
    private int pointIncrememnet = 5;
    private int modBonusPoints = 5;
    private FileManager fm;
    private GUIManager gm;
    private String username;
    private String oauth;
    private String channel;
    private String currencyName;
    private Timer rewards;
    private Timer hours;

    private String rankOneName;
    private String rankTwoName;
    private String rankThreeName;
    private String rankFourName;
    private String rankFiveName;
    private String rankSixName;

    private double rankOneReq;
    private double rankTwoReq;
    private double rankThreeReq;
    private double rankFourReq;
    private double rankFiveReq;
    private double rankSixReq;

    public Primary(){
        username = "dude17bot";
        try {
            this.bot = new TwitchBot(username);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IrcException e) {
            e.printStackTrace();
        }
        bot.sendP(this);

    }

    public void startup() throws IOException, IrcException {

        fm = new FileManager(this);
        gm = new GUIManager(this);

        //----------------

        bot.setVerbose(true);  //debugging, extra bot-side prints and shit (if remember correctly)

    }
    public String calcRank(String user){
        double time = fm.getHours(user);
        String rank = "";
        if(time>rankOneReq)
            rank = rankOneName;
        if(time>rankTwoReq)
            rank = rankTwoName;
        if(time>rankThreeReq)
            rank = rankThreeName;
        if(time>rankFourReq)
            rank = rankFourName;
        if(time>rankFiveReq)
            rank = rankFiveName;
        if(time>rankSixReq)
            rank = rankSixName;
        return rank;
    }

    private void assignRewards(){
        System.out.print("assigning rewards to: ");
        for(User u : bot.getUsers(channel)){
            rewardUser(u);
            System.out.print(u.getNick()+" ");
        }
        System.out.println("");
    }

    private void assignHours(){
        System.out.print("assigning hours to: ");
        for(User u : bot.getUsers(channel)){
            hourUser(u.getNick());
            System.out.print("["+u.getPrefix()+"]");
            System.out.print(u.getNick()+" ");
        }
        System.out.println("");
    }

    private void rewardUser(User u){
        try {
            if(u.isOp()){
                fm.updateFile(u.getNick(), pointIncrememnet+modBonusPoints, true,"points");
            } else {
                fm.updateFile(u.getNick(), pointIncrememnet, true,"points");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
    private void hourUser(String nick){
        try { fm.updateFile(nick, 1, true,"hours");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public FileManager getFM() {
        return fm;
    }

    public void setUsername(String s, boolean b){
        username = s;
        if(b)
            fm.writeConfig("username", s);
    }

    public void setOauth(String s, boolean b){
        oauth = s;
        if(b)
            fm.writeConfig("oauth", s);
    }

    public void setChannel(String s, boolean b){
        channel = s;
        if(b)
            fm.writeConfig("channel", s);
    }

    public void setCurrencyName(String s, boolean b){
        currencyName = s;
        if(b)
            fm.writeConfig("currencyname", s);
    }

    public void setPointIncrememnet(int pointIncrememnet, boolean b) {
        this.pointIncrememnet = pointIncrememnet;
        if(b)
            fm.writeConfig("pointIncrememnet", String.valueOf(pointIncrememnet));
    }

    public int getPointIncrememnet() {
        return pointIncrememnet;
    }

    public void setTimerRewardsUpdateDelay(int timerRewardsUpdateDelay, boolean b) {
        this.timerRewardsUpdateDelay = timerRewardsUpdateDelay;
        if(b)
            fm.writeConfig("timerRewardsUpdateDelay", String.valueOf(timerRewardsUpdateDelay));
    }

    public void setTimerHoursUpdateDelay(int timerHoursUpdateDelay, boolean b) {
        this.timerHoursUpdateDelay = timerHoursUpdateDelay;
        if(b)
            fm.writeConfig("timerHoursUpdateDelay", String.valueOf(timerHoursUpdateDelay));
    }

    public void setRankOneName(String s, Boolean b) {
        rankOneName = s;
        if(b)
            fm.writeConfig("rankOneName", rankOneName);
    }
    public void setRankTwoName(String s, Boolean b) {
        rankTwoName = s;
        if(b)
            fm.writeConfig("rankTwoName", rankTwoName);
    }
    public void setRankThreeName(String s, Boolean b) {
        rankThreeName = s;
        if(b)
            fm.writeConfig("rankThreeName", rankThreeName);
    }
    public void setRankFourName(String s, Boolean b) {
        rankFourName = s;
        if(b)
            fm.writeConfig("rankFourName", rankFourName);
    }
    public void setRankFiveName(String s, Boolean b) {
        rankFiveName = s;
        if(b)
            fm.writeConfig("rankFiveName", rankFiveName);
    }
    public void setRankSixName(String s, Boolean b) {
        rankSixName = s;
        if(b)
            fm.writeConfig("rankSixName", rankSixName);
    }

    public void setRankOneReq(double s, Boolean b) {
        this.rankOneReq = s;
        if(b)
            fm.writeConfig("rankOneReq", String.valueOf(rankOneReq));
    }

    public void setRankTwoReq(double s, Boolean b) {
        this.rankTwoReq = s;
        if(b)
            fm.writeConfig("rankTwoReq", String.valueOf(rankTwoReq));
    }

    public void setRankThreeReq(double s, Boolean b) {
        this.rankThreeReq = s;
        if(b)
            fm.writeConfig("rankThreeReq", String.valueOf(rankThreeReq));
    }

    public void setRankFourReq(double s, Boolean b) {
        this.rankFourReq = s;
        if(b)
            fm.writeConfig("rankFourReq", String.valueOf(rankFourReq));
    }

    public void setRankFiveReq(double s, Boolean b) {
        this.rankFiveReq = s;
        if(b)
            fm.writeConfig("rankFiveReq", String.valueOf(rankFiveReq));
    }

    public void setRankSixReq(double s, Boolean b) {
        this.rankSixReq = s;
        if(b)
            fm.writeConfig("rankSixReq", String.valueOf(rankSixReq));
    }

    public void setModBonusPoints(int i, boolean b) {
        this.modBonusPoints = i;
        if(b)
            fm.writeConfig("modBonusPoints", String.valueOf(modBonusPoints));
    }

    public int getTimerRewardsUpdateDelay() {
        return timerRewardsUpdateDelay;
    }

    public String getUsername() {
        return username;
    }

    public String getOauthT() {
        return oauth;
    }

    public String getChannel() {
        return channel;
    }

    public String getCurrencyNameT() {
        return currencyName;
    }

    public void  connect() throws IOException, IrcException {
        bot.connect("irc.twitch.tv",6667,oauth);

        if(!bot.isConnected())
            System.out.println("FAILED TO CONNECT");

        bot.joinChannel(channel);

        rewards = new Timer(timerRewardsUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignRewards();
            }
        });
        hours = new Timer(timerHoursUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignHours();
            }
        });
        rewards.start();
        hours.start();
    }

    public void resetTimers(){
        rewards.stop();
        hours.stop();
        rewards = new Timer(timerRewardsUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignRewards();
            }
        });
        hours = new Timer(timerHoursUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignHours();
            }
        });
        rewards.start();
        hours.start();
    }

    public String getRankOneName() {
        return rankOneName;
    }

    public String getRankTwoName() {
        return rankTwoName;
    }

    public String getRankThreeName() {
        return rankThreeName;
    }

    public String getRankFourName() {
        return rankFourName;
    }

    public String getRankFiveName() {
        return rankFiveName;
    }

    public String getRankSixName() {
        return rankSixName;
    }

    public double getRankOneReq() {
        return rankOneReq;
    }

    public double getRankTwoReq() {
        return rankTwoReq;
    }

    public double getRankThreeReq() {
        return rankThreeReq;
    }

    public double getRankFourReq() {
        return rankFourReq;
    }

    public double getRankFiveReq() {
        return rankFiveReq;
    }

    public double getRankSixReq() {
        return rankSixReq;
    }

    public int getModBonusPoints() {
        return modBonusPoints;
    }

}
