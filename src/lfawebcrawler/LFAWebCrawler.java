package lfawebcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LFAWebCrawler {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.leapfrog.academy/course");

            URLConnection conn = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder content = new StringBuilder();

            String line = "";

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");//jasta ko testai
            }
            reader.close();

            String regEx = "<a href=\"(.*?)\" class=\"track\" (.*?)>\\n(.*?)<span class=\"right\"></span>\\n(.*?)<h5>(.*?)</h5>";

            Pattern pattern = Pattern.compile(regEx);
            
            Matcher matcher = pattern.matcher(content.toString());
            
            while(matcher.find()){
                
                 System.out.println("TITLE: "+matcher.group(5));
                System.out.println("LINK: "+matcher.group(1));
               
            }
            
        } catch (IOException ioe) {
            System.out.println("Exception Catch: " + ioe.getMessage());
        }

    }
