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
   public class ApplyHash extends HttpServlet {
    String username="";
    String password="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
    
    HttpSession sn=null;
    PrintWriter out=null;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        String sensor1 = req.getParameter("sensor1");
        String sensor2 = req.getParameter("sensor2");
        String sensor3 = req.getParameter("sensor3");
      
          res.setContentType("text/html");
        out = res.getWriter();
        HttpSession sn = req.getSession(true);
       // username=sn.getAttribute("username").toString();
        RequestDispatcher rd;

                try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthmonitoringiot","root","password");
           
           
	                 
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        keyGen.initialize(256, random);

        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey priv = pair.getPrivate();
        PublicKey pub = pair.getPublic();

        /*
         * Create a Signature object and initialize it with the private key
         */

        Signature dsa = Signature.getInstance("SHA1withECDSA");

        dsa.initSign(priv);

        String str = sensor1+sensor2+sensor3;
        byte[] strByte = str.getBytes("UTF-8");
        dsa.update(strByte);

        /*
         * Now that all the data to be signed has been read in, generate a
         * signature for it
         */

        byte[] realSig = dsa.sign();
        System.out.println("Signature: " + new BigInteger(1, realSig).toString(16));
        
        String keyval1 = ""+new BigInteger(1, realSig).toString(16);
        
        
         int id1=0;
            String prevdata="";
             st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select * from blockchain");
            while(rs1.next()) {
            id1=rs1.getInt(1)+1;
            prevdata=rs1.getString(2);
            }
              StringBuffer sb=new StringBuffer();
              
              sb.append(keyval1+prevdata);
        
         File file = new File("E://blockchain//block"+id1+".txt");
  
//Create the file
if (file.createNewFile())
{
    System.out.println("File is created!");
} else {
    System.out.println("File already exists.");
}
 
//Write Content
FileWriter writer = new FileWriter(file);
writer.write(sb.toString());
writer.close();        

  Statement st1 = con.createStatement();
          int add1=st1.executeUpdate("insert into blockchain values('"+id1+"','"+sb.toString()+"')");
            
        String shorthash=sb.toString();
        String shorthash1=shorthash.substring(0, 24)+".......";
         sn.setAttribute("hashvalue",shorthash1);
            
      
            rd=req.getRequestDispatcher("success.jsp");
	           
	        rd.forward(req,res);
        } catch(Exception e2) {
            //System.out.println("Exception : "+e2.toString());
              out.println(e2);
        }
    }
}