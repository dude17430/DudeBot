# DudeBot
My custom Java Bot for Twitch IRC implementing PircBot 1.5 Library <br>

1. **Done:**
    * connects to server
    * commands:
        - !game
        - !stats (reads from file)
    * writes and reads to file
    * keeps list of people who have joined channel
    * keeps track of minutes spent in channel
    * keeps track of points
    * Keep track of settings between sessions(config)
    * GUI
        - setting channel
        - setting OAuth
        - setting currency name
        - setting rank names
        - setting rank requirements (hours)

2. **Working On:**
    * Disconnect (without closing)
    * announcement of rank ups
    * GUI
        - setting !game
        - bonus point(s) configuration for mods
3. **To Do:**
    * mini-games
    * pay-able sounds
    * intro (text+sound)
    * dynamic addition/subtraction of purchasable "things"
        - i.e. server access (will most likely keep record in a file and let streamer handle)
