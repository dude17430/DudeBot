package main;

import java.io.*;


/**
 * Created by dude1_000 on 1/22/2016.
 */
public class FileManager {

    private Primary p;
    private static final double configversion = 6.3;

    public FileManager(Primary primary) {
        p = primary;
        loadConfig();
    }

    private void loadConfig() {
        File configFile = new File("BotConfig.txt");
        if(!configFile.exists()) {
            System.out.println("config !exists");
            createConfig();
        }else {
            System.out.println("config exists");
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(configFile));
            String line;
            double d;
            boolean create = false;
            while((line = br.readLine()) != null){
                if(line.contains("Config_Version=")){
                    d = Double.parseDouble(line.substring(line.indexOf(" "),line.length()).trim());
                    if (d != configversion){
                        create = true;
                    }
                }
            }
            br.close();
            if (create)
                createConfig();
            BufferedReader br2 = new BufferedReader(new FileReader(configFile));
            while((line = br2.readLine()) != null){
                if(line.contains("username=")){
                    System.out.println("LOADED - Username: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setUsername(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("oauth=")){
                    System.out.println("LOADED - OAuth: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setOauth(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("channel=")){
                    System.out.println("LOADED - Channel: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setChannel(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("currencyname=")){
                    System.out.println("LOADED - Currency Name: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setCurrencyName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("timerRewardsUpdateDelay=")){
                    System.out.println("LOADED - timerRewardsUpdateDelay Name: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setTimerRewardsUpdateDelay(Integer.parseInt(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("timerHoursUpdateDelay=")){
                    System.out.println("LOADED - timerHoursUpdateDelay Name: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setTimerHoursUpdateDelay(Integer.parseInt(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("pointIncrememnet=")){
                    System.out.println("LOADED - timerHoursUpdateDelay Name: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setPointIncrememnet(Integer.parseInt(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                //------------------------------------------------
                if(line.contains("rankOneName=")){
                    System.out.println("LOADED - rankOneName: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankOneName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("rankTwoName=")){
                    System.out.println("LOADED - rankTwoName: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankTwoName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("rankThreeName=")){
                    System.out.println("LOADED - rankThreeName: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankThreeName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("rankFourName=")){
                    System.out.println("LOADED - rankFourName: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankFourName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("rankFiveName=")){
                    System.out.println("LOADED - rankFiveName: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankFiveName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                if(line.contains("rankSixName=")){
                    System.out.println("LOADED - rankSixName: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankSixName(line.substring(line.indexOf(" ")+1,line.length()), false);
                }
                //------------------------------------------------
                if(line.contains("rankOneReq=")){
                    System.out.println("LOADED - rankOneReq: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankOneReq(Double.parseDouble(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("rankTwoReq=")){
                    System.out.println("LOADED - rankTwoReq: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankTwoReq(Double.parseDouble(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("rankThreeReq=")){
                    System.out.println("LOADED - rankThreeReq: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankThreeReq(Double.parseDouble(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("rankFourReq=")){
                    System.out.println("LOADED - rankFourReq: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankFourReq(Double.parseDouble(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("rankFiveReq=")){
                    System.out.println("LOADED - rankFiveReq: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankFiveReq(Double.parseDouble(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("rankSixReq=")){
                    System.out.println("LOADED - rankSixReq: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setRankSixReq(Double.parseDouble(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
                if(line.contains("modBonusPoints=")){
                    System.out.println("LOADED - modBonusPoints: "+line.substring(line.indexOf(" ")+1,line.length()));
                    p.setModBonusPoints(Integer.parseInt(line.substring(line.indexOf(" ")+1,line.length())), false);
                }
            }
            br.close();
            br2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createConfig(){
        System.out.println("creating config");

        File configFile = new File("BotConfig.txt");


        try {
            PrintWriter pw = new PrintWriter(new FileWriter(configFile));

            pw.println("~~~Config System Database~~~");
            pw.println("Config_Version= "+configversion);
            pw.println("messing with the structure of this file may break the program ONLY change VALUES");
            pw.println("if it breaks rename THIS file, to generate a new one, then transfer your values");
            pw.println("REALLY, everything should be changed through the program interface");
            pw.println("WARNING: new version of program may reset your config's, rename config before updates");
            pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            pw.println("username= Username");
            pw.println("oauth= OAuth");
            pw.println("channel= Channel");
            pw.println("currencyname= Currency");
            pw.println("timerHoursUpdateDelay= 1");
            pw.println("timerRewardsUpdateDelay= 5");
            pw.println("pointIncrememnet= 5");
            pw.println("rankOneName= Peasant");
            pw.println("rankTwoName= Farmer");
            pw.println("rankThreeName= Squire");
            pw.println("rankFourName= Knight");
            pw.println("rankFiveName= Lord");
            pw.println("rankSixName= GODLY");
            pw.println("rankOneReq= 0");
            pw.println("rankTwoReq= 5");
            pw.println("rankThreeReq= 10");
            pw.println("rankFourReq= 50");
            pw.println("rankFiveReq= 100");
            pw.println("rankSixReq= 200");
            pw.println("modBonusPoints= 2");
            pw.println("");

            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFile(String name, int pointAdgustmnet, boolean adding, String mode) throws IOException {
        if(mode.equals("points")){
            int newPoints;
            File originalFile = new File("file.txt");

            if(!originalFile.exists()){
                createPointsFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line;
//-------------------------------------------------------------------------
            // read + modify data
            while ((line = br.readLine()) != null) {
                if (line.contains(name)) {
                    String strPoints = line.substring(line.lastIndexOf(" "), line.length());
                    newPoints = Integer.parseInt(strPoints.trim()) + pointAdgustmnet;
                    if (strPoints != null || !strPoints.trim().isEmpty()) {
                        line = line.substring(0,line.lastIndexOf(" ")) + " "+newPoints;
                    }

                }
                //write data
                pw.println(line);
                pw.flush();
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!originalFile.delete()) {
                System.out.println("Could not delete file");
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(originalFile))
                System.out.println("Could not rename file");
//------------------------------------------------------------------------
        }
        else if (mode.equals("hours")){
            int newHours;
            File originalFile = new File("file.txt");

            if(!originalFile.exists()){
                createPointsFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line;
//-------------------------------------------------------------------------
            // read + modify data
            while ((line = br.readLine()) != null) {
                if (line.contains(name)) {
                    String strHours = line.substring(line.indexOf(" "), line.lastIndexOf(" "));
                    newHours = Integer.parseInt(strHours.trim()) + pointAdgustmnet;
                    if (strHours != null || !strHours.trim().isEmpty()) {
                        line = line.substring(0,line.indexOf(" ")) + " "+newHours+" "+line.substring(line.lastIndexOf(" "),line.length());
                    }

                }
                //write data
                pw.println(line);
                pw.flush();
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!originalFile.delete()) {
                System.out.println("Could not delete file");
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(originalFile))
                System.out.println("Could not rename file");
//------------------------------------------------------------------------
        }
    }

    private void createPointsFile() {
        try {

            FileWriter fw = new FileWriter("file.txt");
            fw.write(
                    "~~~Currency System Database~~~"+System.lineSeparator()+
                            "dude17430 69 69"+System.lineSeparator()+
                            ""+p.getUsername()+" 1 1");
            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joined(String sender) {
        File originalFile = new File("file.txt");
        File tempFile = new File("tempfilejoined.txt");
        BufferedReader br = null;
        boolean exists = false;
        System.out.println(sender+" joined");
        if(originalFile.exists()){
            try {
                br = new BufferedReader(new FileReader(originalFile));
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(sender)) {
                        exists = true;
                        break;
                    }
                    pw.println(line);
                    pw.flush();
                }
                if(!exists){
                    pw.write(System.lineSeparator()+sender+" 1 1");
                    pw.close();
                    br.close();
                    // Delete the original file
                    if (!originalFile.delete()) {
                        System.out.println("Could not delete file");
                    }
                    // Rename the new file to the filename the original file had.
                    if (!tempFile.renameTo(originalFile))
                        System.out.println("Could not rename file");
                }else{
                    pw.close();
                    br.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sender+" -exists: "+exists);
            if(exists){
                tempFile.delete();
            }
        }
    }

    public int getPoints(String user){
        File originalFile = new File("file.txt");
        BufferedReader br = null;
        String strPoints = "ERROR";
        try {
            br = new BufferedReader(new FileReader(originalFile));

            String line;
            // read + modify data
            while ((line = br.readLine()) != null) {

                if (line.contains(user)) {
                    strPoints = line.substring(line.lastIndexOf(" "), line.length());
                    break;
                }
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(strPoints.trim());
    }

    public double getHours(String user){
        File originalFile = new File("file.txt");
        BufferedReader br = null;
        String strHours = "ERROR";
        double time=0;
        try {
            br = new BufferedReader(new FileReader(originalFile));

            String line;
            // read + modify data
            while ((line = br.readLine()) != null) {

                if (line.contains(user)) {
                    strHours = line.substring(line.indexOf(" "), line.lastIndexOf(" "));
                    time = Double.parseDouble(strHours.trim());
                    time = (double) Math.round((time/60)*100)/100;
                    break;
                }
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return time;
    }

    public void writeConfig(String key, String value) {
        File configFile = new File("BotConfig.txt");
        File tempFile = new File("tempfileconfig.txt");
        try {
            BufferedReader br_config = new BufferedReader(new FileReader(configFile));
            PrintWriter pw_config = new PrintWriter(new FileWriter(tempFile));
            String line;
            while((line = br_config.readLine()) != null){
                if(line.contains(key)){
                    pw_config.println(key+"= "+value);
                    pw_config.flush();
                } else {
                    pw_config.println(line);
                }
            }
//            System.gc();//bad practice but makes it be able to delete/rename file... dunno why....
            pw_config.close();
            br_config.close();

            // Delete the original file
            if (!configFile.delete()) {
                System.out.println("Could not delete file");
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(configFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeNewMod(String nameToAdd){
        File originalFile = new File("modsList.txt");
        File tempFile = new File("tempModList.txt");
        boolean exists = false;
        String line;

        if(!originalFile.exists()){
            createModsFile();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            while((line = br.readLine()) != null){
                if(line.contains(nameToAdd)){
                    exists = true;
                    break;
                }
                pw.println(line);
                pw.flush();
            }
            System.out.println(nameToAdd+" modlist "+exists);
            if(!exists){
                pw.println(nameToAdd);
                pw.flush();

                pw.close();
                br.close();
                // Delete the original file
                if (!originalFile.delete()) {
                    System.out.println("Could not delete file");
                }

                // Rename the new file to the filename the original file had.
                if (!tempFile.renameTo(originalFile))
                    System.out.println("Could not rename file");
            }
            else {
                pw.close();
                br.close();
                tempFile.delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createModsFile() {
        try {

            FileWriter fw = new FileWriter("modsList.txt");
            fw.write(
                    "~~~Channel Mods Database~~~"+System.lineSeparator()+
                            "dude17430");
            fw.flush();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}