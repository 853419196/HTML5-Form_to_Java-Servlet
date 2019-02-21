package my;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter iPrintWrite=response.getWriter();
        iPrintWrite.println("Get form:");
        for(Enumeration<String> e=request.getParameterNames(); e.hasMoreElements();)
        {
            String name=e.nextElement();
            List<String> value=Arrays.asList(request.getParameterValues(name));
            iPrintWrite.printf("%s: %s%n",name,value);
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter iPrintWrite=response.getWriter();
        iPrintWrite.println("Post form:");
        for(Enumeration<String> e=request.getParameterNames(); e.hasMoreElements();)
        {
            String name=e.nextElement();
            List<String> value=Arrays.asList(request.getParameterValues(name));
            iPrintWrite.printf("%s: %s%n",name,value);
        }
        iPrintWrite.println("Post files:");
        Collection<Part> iCollection=request.getParts();
        for(Part iPart:iCollection)
        {
            String name=iPart.getSubmittedFileName();
            iPrintWrite.printf("name: %s, size: %d%n",name,iPart.getSize());
            iPart.write("D:\\Temp\\"+name);
        }
    }
}
