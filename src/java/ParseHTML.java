/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ParseHTML {
 public static void main(String[] args) {
        try {
            String parseLine; /* variable definition */
                        /* create objects */
            URL URL = new URL("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v0"); 
            BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

            while ((parseLine = br.readLine()) != null) {
                /* read each line */
                System.out.println(parseLine);
            }
            br.close();

        } catch (MalformedURLException me) {
            System.out.println(me);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//class end
}