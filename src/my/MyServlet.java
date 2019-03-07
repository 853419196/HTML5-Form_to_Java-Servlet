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
        request.getParameterMap().forEach((name,values)->iPrintWrite.printf("    %s: %s%n",name,Arrays.asList(values)));
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter iPrintWrite=response.getWriter();
        iPrintWrite.println("Post form:");
        request.getParameterMap().forEach((name,values)->iPrintWrite.printf("    %s: %s%n",name,Arrays.asList(values)));
        iPrintWrite.println("Post files:");
        Collection<Part> iCollection=request.getParts();
        for(Part iPart:iCollection)
        {
            String name=iPart.getName();
            String fileName=iPart.getSubmittedFileName();
            iPrintWrite.printf("    %s:%n        File Name: %s, Size: %d%n",name,fileName,iPart.getSize());
            iPart.write("D:\\Temp\\"+fileName);
        }
    }
}
