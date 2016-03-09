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
        if(channel.equalsIgnoreCase(p.getChannel())){
            System.out.println(channel+"\n"+sender+"\n"+login+"\n"+hostname+"\n"+message);
            if(message.equalsIgnoreCase("!game")){
                sendMessage(channel, "My Master the Great and Mighty Dude is playing Minecraft!");
            }
            else if(message.equalsIgnoreCase("!stats")){
                String msg = "<"+p.calcRank(sender)+"> "+sender+" is "+p.getFM().getHours(sender)+" Hours Loyal and "+p.getFM().getPoints(sender)+" "+p.getCurrencyNameT()+" rich!";
                sendMessage(channel,msg);
                //return user hours/points/rank
            }
        }else{System.out.println(channel);}
    }

    @Override
    protected void onPrivateMessage(String sender, String login, String hostname, String message) {
        super.onPrivateMessage(sender, login, hostname, message);
        System.out.println("PRIVATE MESSAGE"+sender+"\n"+login+"\n"+hostname+"\n"+message);
    }

    @Override
    protected void onJoin(String channel, String sender, String login, String hostname) {
        super.onJoin(channel, sender, login, hostname);
        if(sender == "dude17bot"){
            getUsers(p.getChannel());
        }
        p.getFM().joined(sender);
    }

    public void sendP(Primary primary) {
        p = primary;
    }

    @Override
    protected void onConnect() {
        super.onConnect();
        sendRawLine("CAP REQ :twitch.tv/membership ");
//        sendRawLine("CAP REQ :twitch.tv/tags ");
    }

}
