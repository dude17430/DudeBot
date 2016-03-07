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
    private FileManager fm;
    private GUIManager gm;
    private String username;
    private String oauth;
    private String channel;
    private String currencyName;
    private boolean connected;
    private Timer rewards;
    private Timer hours;

    public Primary(){
        username = "dude17bot";
        connected = false;
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
    //TODO: Rank config/setting
    public String calcRank(String user){
        double time = fm.getHours(user);
        String rank = "";
        if(time>0)
            rank = "pesant";
        if(time>5)
            rank = "farmer";
        if(time>10)
            rank = "squire";
        if(time>50)
            rank = "knight";
        if(time>100)
            rank = "lord";
        if(time>200)
            rank = "GODLY";
        return rank;
    }

    private void assignRewards(){
        System.out.print("assigning rewards to: ");
        for(User u : bot.getUsers(channel)){
            rewardUser(u.getNick());
            System.out.print(u.getNick()+" ");
        }
        System.out.println("");
//        System.out.println("awarding done");
    }

    private void assignHours(){
        System.out.print("assigning hours to: ");
        for(User u : bot.getUsers(channel)){
            hourUser(u.getNick());
            System.out.print(u.getNick()+" ");
        }
        System.out.println("");
//        System.out.println("hours'ing done");
    }

    private void rewardUser(String nick){
        try { fm.updateFile(nick, pointIncrememnet, true,"points");
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
        if(b == true)
            fm.writeConfig("username", s);
    }
    public void setOauth(String s, boolean b){
        oauth = s;
        if(b == true)
            fm.writeConfig("oauth", s);
    }
    public void setChannel(String s, boolean b){
        channel = s;
        if(b == true)
            fm.writeConfig("channel", s);
    }
    public void setCurrencyName(String s, boolean b){
        currencyName = s;
        if(b == true)
            fm.writeConfig("currencyname", s);
    }

    public void setPointIncrememnet(int pointIncrememnet, boolean b) {
        this.pointIncrememnet = pointIncrememnet;
        if(b == true)
            fm.writeConfig("pointIncrememnet", String.valueOf(pointIncrememnet));
    }

    public int getPointIncrememnet() {
        return pointIncrememnet;
    }

    public void setTimerRewardsUpdateDelay(int timerRewardsUpdateDelay, boolean b) {
        this.timerRewardsUpdateDelay = timerRewardsUpdateDelay;
        if(b == true)
            fm.writeConfig("timerRewardsUpdateDelay", String.valueOf(timerRewardsUpdateDelay));
    }

    public void setTimerHoursUpdateDelay(int timerHoursUpdateDelay, boolean b) {
        this.timerHoursUpdateDelay = timerHoursUpdateDelay;
        if(b == true)
            fm.writeConfig("timerHoursUpdateDelay", String.valueOf(timerHoursUpdateDelay));
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

    public String getChannelT() {
        return channel;
    }

    public String getCurrencyNameT() {
        return currencyName;
    }

    public void  connect() throws IOException, IrcException {
        connected = false;
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
}
