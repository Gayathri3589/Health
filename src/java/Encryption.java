   
import java.net.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
   import java.sql.*;
import java.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
   import javax.servlet.*;
   import javax.servlet.http.*;
   public class Encryption extends HttpServlet {
    String username="";
    String password="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
    
    HttpSession sn=null;
    PrintWriter out=null;
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        
         String s1=req.getParameter("sensor1");
          String s2=req.getParameter("sensor2");
           String s3=req.getParameter("sensor3");
         
        
        res.setContentType("text/html");
        out = res.getWriter();
        HttpSession sn = req.getSession(true);
       // username=sn.getAttribute("username").toString();
        RequestDispatcher rd;

                try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthmonitoringiot","root","password");
           
         String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn4pp9Iqmz/WZtd/nQJIocOsvMc0l4C+H7ex9bfyYN9pLjaXohgZub6meVawI8KNWVrRfx9psSF2V22DM88IBWO8Fw2BSxXSKcCGffuGhycY48p2lpKdBKNVp0EFZNIf2wZjS9sF9Jz0WfepcDTCoxkxl1p24vNHqIReEGJyVeo6i9bLjdnNgry7u7vMY+ogLeLhytdnO2lJP5aRRr8DzPvBLwf67oC3VcgE3KZ6EMYzaAcqR36Aytci/YVt9RnQEQ65Uo8GwzGYo2kAnAEmMHBEKX1iJwmMUuGFAMif9LdykOvhlKC808rkJgThLEHHcCtJLNWKWrJIUYsbtrYiFuQIDAQAB";
       String privateKey="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCfimn0iqbP9Zm13+dAkihw6y8xzSXgL4ft7H1t/Jg32kuNpeiGBm5vqZ5VrAjwo1ZWtF/H2mxIXZXbYMzzwgFY7wXDYFLFdIpwIZ9+4aHJxjjynaWkp0Eo1WnQQVk0h/bBmNL2wX0nPRZ96lwNMKjGTGXWnbi80eohF4QYnJV6jqL1suN2c2CvLu7u8xj6iAt4uHK12c7aUk/lpFGvwPM+8EvB/rugLdVyATcpnoQxjNoBypHfoDK1yL9hW31GdARDrlSjwbDMZijaQCcASYwcEQpfWInCYxS4YUAyJ/0t3KQ6+GUoLzTyuQmBOEsQcdwK0ks1YpaskhRixu2tiIW5AgMBAAECggEAEzobpdiAh7HPdKnyFTKSxB+xKt0l55GNiKtxEaxuQyuVjRHFvEKR1Ew1Tu7c5En9sZUAXAtjSbSu8ZGGHF8GSYuuKUsg/oyafdlXfvOTS3K4/JLqL7Xmdj+DW+acPmafuC+CRocFXbwQy1ukp1mfZXKMmA5JrBvXjbsR9ONeEmG7JOUAA5bzLE+wI9AmXFMEXM+AjRN2jvfjVWW6RrlSMKrD4it+OL/2AAsdHyTgF1kTjZJD3/HTc2IZ7Vglck7vFGmizOJI1pFE8N3Qfw3Qt28AiTorCe+7XoGzohYkZnMB6VSFAM8rwNgfpAqL8WePJE0zdvFKQyNiDgQKzCgPTwKBgQC+pRZbKoASdZ/oVOdoKCpyEOkOES0o/tA+OCCXZRzKNJsyHkrmg/K/NqbuXACUTkHOD6yRGpi+C8sWSEwqU6HygAPYK3axz+lG6ux+2ImIop0hbx6+G6gDzBDIzliecNskTZRLSZbRj4MA0UZ+dT1he6gW4lOsJVcO0/o2+I1iWwKBgQDWO6LGWQDH2vu3stvhxV9EkNUoAI7nrGXrdEAWetzUwztBP+9k49k9yS5ZY9w0bukLhme/sG4IvVLCsd3aXUc3rmQS4qAF9FJfiN4jgA8Qgy4l8TaP1JoaeMAXPUogtV1o/Wey59quRVuQEyBZgV9BpxRjMv50ZySNtGqut1oMewKBgDzyG8aDPLQqBDfKxLuIc6FJhKepmA1OAJaTbN/ZRC3kSWTpSDqPHhBA0XbL1KeUqPbODfXJUeEXdhImhKrXV6Nlh1UY9/X6KHIyce5PHRCgI6lnk6Vkw/6KwybeyHfGTlg5sNmsqdlOjqu5O1b79eZvGJpQOj2DJmSoIYpnRROXAoGAYYb2nEtqYpFbZI5lMUvUCffRQgu3Atrl7yGWB2XZYHacZCECD7D2df0/P2yJk8kmCJwgYRCllw7xPTcR41XxlPSsFDjdVriaQ2mgjxK+SOsfOCCukR3dJc3wzOOW+nr2UlSCP9zzHcDvZRB/+p89yTqRunM9iapm5qfKpU1NDj8CgYA405QJoHxFHrpMfqCZjtFHVs1ja3+VyqdXJi7DEMnuoJfa5CMk+7AxaS7ELzU9dxoSxDUcE3UzslX5MOa1FRUNeUaIjDJ4pKZ2j2hIKWwIXHvg7DyglXRTPMDl3+tvroOoPFlzD7tu7fDV+eU3UlqwSBdN4QjBBOQMs1sQ8JFIGQ==";


        // Original message
       // String originalMessage = "Hello, this is a secret message!";

       // System.out.println("Original message:"+originalMessage);
        // Encrypt using the public key
        String e1 = encrypt(s1, publicKey);
        String e2 = encrypt(s2, publicKey);
        String e3 = encrypt(s3, publicKey);
	
         sn.setAttribute("e1",e1);
            sn.setAttribute("e2",e2);
            sn.setAttribute("e3",e3);
      
            rd=req.getRequestDispatcher("mainpage1.jsp");
	           
	        rd.forward(req,res);
        } catch(Exception e2) {
            //System.out.println("Exception : "+e2.toString());
              out.println(e2);
        }
    }
    
    public static String encrypt(String message, String  publicKeyString) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey =  keyFactory.generatePublic(publicKeySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
    }
}