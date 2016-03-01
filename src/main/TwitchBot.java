package main;

import org.jibble.pircbot.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dude1_000 on 1/22/2016.
 */
public class TwitchBot extends PircBot {

    private ArrayList people;
    private Primary p;

    public TwitchBot(String nick) throws IOException, IrcException {
        System.out.println("Constructing Bot...");
        setName(nick);
        p = null;
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        if(channel.equalsIgnoreCase(Primary.channel)){
            if(message.equalsIgnoreCase("!game")){
                sendMessage(channel, "My Master the Great and Mighty Dude is playing Minecraft!");
            }
            else if(message.equalsIgnoreCase("!stats")){
                sendMessage(channel,"<Rank> "+sender+" is <int> Hours Loyal \n and <int> <currency> rich!");
                //return user hours/points/rank
            }
        }else{System.out.println(channel);}
    }

    @Override
    protected void onJoin(String channel, String sender, String login, String hostname) {
        super.onJoin(channel, sender, login, hostname);
        p.getFM().joined(sender);
    }

    @Override
    protected void onPart(String channel, String sender, String login, String hostname) {
        super.onPart(channel, sender, login, hostname);
    }

    public void sendP(Primary primary) {
        p = primary;
    }
}
