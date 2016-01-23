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
    private static final String currencyName = "Dude Points";

    private TwitchBot bot;
    private int timerUpdateDelay = 1;

    public Primary(TwitchBot bot){
        this.bot = bot;
    }

    public void startup() throws IOException, IrcException {
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
        for(User u : bot.getUsers(channel)){
            if(!users.equals("")){users = users+", "+u.getNick();}
            else{users = u.getNick();}
        }
        System.out.println("assigning rewards to: "+users);
    }

    private void rewardUser(String nick){
        //inc time+points
    }
}
