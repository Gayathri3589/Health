 
   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   import java.lang.*;
import java.text.DecimalFormat;
 
public class PatientRegister extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
     
	   String fullname= req.getParameter("fullname");
            String username= req.getParameter("username");
          String password= req.getParameter("password");
           
        	
               
             
        	
		String mobile1= req.getParameter("mobile");
		String emailid1= req.getParameter("emailid");
               
              
        	RequestDispatcher rd;

	try {
		
		
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthmonitoringiot","root","password");
            st1 = con.createStatement();
            int add=st1.executeUpdate("insert into patienttable values('"+username+"','"+password+"','"+fullname+"','"+mobile1+"','"+emailid1+"')");
            rd=req.getRequestDispatcher("regsuccess.jsp");
            rd.forward(req,res);
        } catch(Exception e2) {
            System.out.println(e2);
             rd=req.getRequestDispatcher("failure.jsp");
        }
    }
}