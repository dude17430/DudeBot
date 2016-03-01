package main;

import java.io.*;
import java.util.Scanner;

/**
 * Created by dude1_000 on 1/22/2016.
 */
public class FileManager {

    public void updateFile(String name, int pointAdgustmnet, boolean adding) throws IOException {
        int newPoints = 0;
        File originalFile = new File("file.txt");

        if(!originalFile.exists()){
            createFile();
        }
//        System.out.println("file location"+originalFile.getAbsoluteFile());

        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original filename.
        File tempFile = new File("tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
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
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");
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
        BufferedReader br = null;
        if(originalFile.exists()){
            try {

                br = new BufferedReader(new FileReader(originalFile));
                PrintWriter pw = new PrintWriter(new FileWriter(originalFile));
                String line = null;
                boolean exists = false;
                while ((line = br.readLine()) != null) {
                    if (line.contains(sender)) {
                        exists = true;
                        break;
                    }
                    pw.println(line);
                    pw.flush();
                }
                if(!exists){
                    pw.write(System.lineSeparator()+sender+" 1");
                }
                pw.close();
                br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
