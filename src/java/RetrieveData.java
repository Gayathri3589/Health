   
import java.net.*;
import java.io.*;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
   import java.sql.*;
import java.util.Random;
   import javax.servlet.*;
   import javax.servlet.http.*;
   public class RetrieveData extends HttpServlet {
    String username="";
    String password="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
    
    HttpSession sn=null;
    PrintWriter out=null;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        
          res.setContentType("text/html");
        out = res.getWriter();
        HttpSession sn = req.getSession(true);
       // username=sn.getAttribute("username").toString();
        RequestDispatcher rd;

                try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthmonitoringiot","root","password");
           
           String content = getText("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v0");
        String content1 = getText("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v1");
        String content2 = getText("https://blynk.cloud/external/api/get?token=ToeqcxkSQoEBioQqQaCfCAzH9bjvHeiz&v2");
        
	
         sn.setAttribute("content",content);
            sn.setAttribute("content1",content1);
            sn.setAttribute("content2",content2);
      
            rd=req.getRequestDispatcher("mainpage.jsp");
	           
	        rd.forward(req,res);
        } catch(Exception e2) {
            //System.out.println("Exception : "+e2.toString());
              out.println(e2);
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