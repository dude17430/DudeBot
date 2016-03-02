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

    public static final String channel = "#dude17430";
    private static final String oauth = "oauth:r34jjki08jh8xwpimdnp596xcoaqrm";
    public static final String currencyName = "Dude Points";
    private static final int pointIncrememnet = 5;

    private TwitchBot bot;
    private int timerRewardsUpdateDelay = 5;
    private int timerHoursUpdateDelay = 1;
    private FileManager fm;
    private GUIManager gm;
    private String nick;

    public Primary(){
        nick = "dude17bot";
        try {
            this.bot = new TwitchBot(nick);
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

        bot.setVerbose(true);
        bot.connect("irc.twitch.tv",6667,oauth);

        if(!bot.isConnected())
            System.out.println("FAILED TO CONNECT");

        bot.joinChannel(channel);

        Timer rewards = new Timer(timerRewardsUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignRewards();
            }
        });
        Timer hours = new Timer(timerHoursUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignHours();
            }
        });
        rewards.start();
        hours.start();
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
        System.out.println("awarding done");
    }

    private void assignHours(){
        System.out.print("assigning hours to: ");
        for(User u : bot.getUsers(channel)){
            hourUser(u.getNick());
            System.out.print(u.getNick()+" ");
        }
        System.out.println("");
        System.out.println("hours'ing done");
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

    public String getNick() {
        return nick;
    }
}
