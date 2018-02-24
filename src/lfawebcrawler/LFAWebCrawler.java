package lfawebcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class LFAWebCrawler {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.leapfrog.academy/course");

            URLConnection conn = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder content = new StringBuilder();

            String line = "";
            
            
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();

        } catch (IOException ioe) {
            System.out.println("Exception Catch: " + ioe.getMessage());
        }

    }
