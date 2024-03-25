
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java.2
 */
public class PatientLogin extends HttpServlet {
    String username="";
    String password="";
    String type1="",key="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        username = req.getParameter("username");
        password = req.getParameter("password");
       
	String status="";
	HttpSession sn = req.getSession(true);
     sn.setAttribute("username",username);
      
		RequestDispatcher rd = null;
                
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthmonitoringiot","root","password");
            st = con.createStatement();
            rs = st.executeQuery("select * from patienttable where username='"+username+"' && password='"+password+"'");
            if(rs.next()) {
             
                
          /*      HttpsURLConnection conn = null;
             URL url = new URL("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v0");
             conn = (HttpsURLConnection) url.openConnection();
             SSLContext sc = SSLContext.getInstance("SSL");  
             sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());  
                    // Create all-trusting host name verifier
             HostnameVerifier allHostsValid = new HostnameVerifier() {
               public boolean verify(String hostname, SSLSession session) {
                return true;
              }
            };
            conn.setHostnameVerifier(allHostsValid);
         
              BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    conn.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);
        */
          String content="";     
          String content1=""; 
          String content2=""; 
         try {
            String parseLine; /* variable definition */
                        /* create objects */
            URL URL = new URL("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v0"); 
            BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

            while ((parseLine = br.readLine()) != null) {
                /* read each line */
                System.out.println(parseLine);
                content=parseLine;
            }
            br.close();

        } catch (MalformedURLException me) {
            System.out.println(me);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }       
                
          try {
            String parseLine; /* variable definition */
                        /* create objects */
            URL URL = new URL("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v1"); 
            BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

            while ((parseLine = br.readLine()) != null) {
                /* read each line */
                System.out.println(parseLine);
                content1=parseLine;
            }
            br.close();

        } catch (MalformedURLException me) {
            System.out.println(me);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }   
          
          
          
            try {
            String parseLine; /* variable definition */
                        /* create objects */
            URL URL = new URL("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v2"); 
            BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

            while ((parseLine = br.readLine()) != null) {
                /* read each line */
                System.out.println(parseLine);
                content2=parseLine;
            }
            br.close();

        } catch (MalformedURLException me) {
            System.out.println(me);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }   
               // String content = getText("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v0");
        System.out.println("Content : "+content);
               // String content1 = getText("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v1");
        //String content2 = getText("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v2");
          
	
         sn.setAttribute("content",content);
            sn.setAttribute("content1",content1);
            sn.setAttribute("content2",content2);
            rd=req.getRequestDispatcher("patientpage.jsp");
            }
           
            else {
  
               rd=req.getRequestDispatcher("failure.jsp");
	        }
	     rd.forward(req,res);
        }
        catch(Exception e2)
         {
            System.out.println("Exception : "+e2.toString());
        }
    }
    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
    }
}
