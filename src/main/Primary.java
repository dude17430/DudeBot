package main;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by dude1_000 on 1/22/2016.
 */
public class Primary {

    public static final String channel = "#dude17430";
    private static final String oauth = "oauth:r34jjki08jh8xwpimdnp596xcoaqrm";
    private static final String currencyName = "Dude Points";
    private static final int pointIncrememnet = 5;

    private TwitchBot bot;
    private int timerUpdateDelay = 1;
    private FileManager fm;

    public Primary(TwitchBot bot){
        this.bot = bot;
        bot.sendP(this);
    }

    public void startup() throws IOException, IrcException {

        fm = new FileManager();

        bot.setVerbose(true);
        bot.connect("irc.twitch.tv",6667,oauth);

        if(!bot.isConnected())
            System.out.println("FAILED TO CONNECT");

        bot.joinChannel(channel);

        Timer rewards = new Timer(timerUpdateDelay*60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignRewards();
            }
        });
        rewards.start();
    }

    public void calcRank(){

    }

    private void assignRewards(){
        String users = "";
        System.out.print("assigning rewards to: ");
        for(User u : bot.getUsers(channel)){
            rewardUser(u.getNick());
            System.out.print(u.getNick()+" ");
        }
        System.out.println("");
        System.out.println("awarding done");
    }

    private void rewardUser(String nick){
        try { fm.updateFile(nick, pointIncrememnet, true);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public FileManager getFM() {
        return fm;
    }
}
