import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
* Servlet implementation class Registration
*/
public class Registration extends HttpServlet {
private static final long serialVersionUID = 1L;
 
 /**
 * @see HttpServlet#HttpServlet()
 */
 public Registration() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
String name=request.getParameter("name");
String phone=request.getParameter("phone");
String email=request.getParameter("email");
String attendeesno=request.getParameter("attendeesno");
Connection con=null;
Statement s=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3303/realdb","root","1");
s=con.createStatement();
int result=s.executeUpdate("insert into event values('"+name+"','"+phone+"','"+email+"','"+attendeesno+"')");
out.println("<html><body bgcolor='wheat'><center><h1>");
if(result!=0)
out.println(name+"you are sucessfully registered");
else
out.println(name+"you are unable to register,please fill form correctly");
out.println("</h1></center></body></html>");
s.close();
con.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}