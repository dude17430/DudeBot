package main;

import org.jibble.pircbot.IrcException;

import java.io.IOException;

/**
 * Created by dude1_000 on 1/22/2016.
 */
public class Launcher {

    public static void main(String args[]) throws IOException, IrcException {
        System.out.println("Launched");
        TwitchBot bot = new TwitchBot("dude17Bot");

        Primary p = new Primary(bot);
        p.startup();
    }
}
