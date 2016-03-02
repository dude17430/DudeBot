package main;

import java.io.*;

/**
 * Created by dude1_000 on 1/22/2016.
 */
public class FileManager {

    public void updateFile(String name, int pointAdgustmnet, boolean adding,String mode) throws IOException {
        if(mode.equals("points")){
            int newPoints = 0;
            File originalFile = new File("file.txt");

            if(!originalFile.exists()){
                createFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
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
                createFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
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

    private void createFile() {
        try {

            FileWriter fw = new FileWriter("file.txt");
            fw.write(
                    "~~~Currency System Database~~~"+System.lineSeparator()+
                            "dude17430 69");
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

                String line = null;
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
}
