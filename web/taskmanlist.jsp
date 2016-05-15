<%-- 
    Document   : taskmanlist
    Created on : 15.05.2016, 7:54:17
    Author     : Алексей
--%>

<%@page import="com.sun.javafx.image.impl.IntArgb"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="entity.Taskmanager"%>
<%@page import="entity.Taskmanager"%>
<%@page import="dao.TaskmanagerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    TaskmanagerDAO tDao = new TaskmanagerDAO();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Manager for your plans</title>
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        <h1>Task Manager</h1>
        <h2>A list of Task</h2>
        <table>
            <tr><th>Name</th><th>Description</th><th>Lead time</th><th>Actions</th></tr>
            <%
                List<Taskmanager> tl = tDao.findAll();
                for (Taskmanager t: tl)
                {
                    out.write("<tr>");
                    out.write("<td>" + t.getName().toString() + "</td>");
                    out.write("<td>" + t.getDescription().toString() + "</td>");
                    out.write("<td>" + ((t.getLidetime()!= null) ? (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ROOT)).format(t.getLidetime()) : "") +"</td>");
                    out.write("<td>");
                    out.write("<a href = 'taskman.jsp?editId="+t.getIdTask()+"'><img class = 'action' src = 'imgs/edit.png'></a>");
                    out.write("<a href = 'taskman.jsp?delId="+t.getIdTask()+"'><img class = 'action' src = 'imgs/delete.png'></a>");
                    out.write("</td>");
                    out.write("</tr>");
                    
                }
            %>
        </table>
        <div class ="foot">
        <a class = "home" href = "taskman.jsp">New task for next day</a> 
        </div>
    </body>
</html>
