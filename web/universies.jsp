<%-- 
    Document   : universies
    Created on : 24.04.2016, 15:07:10
    Author     : Алексей
--%>

<%@page import="Entity.Universes"%>
<%@page import="java.util.List"%>
<%@page import="DAO.UniversesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! 
    UniversesDAO udao = new UniversesDAO();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Uniniverses</title>
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
         <h1>The Universes</h1>
        <h2>A list of universes</h2>
    <table>
        <tr><th>Title</th><th>Foundation_year</th><th>Type</th><th>Actions</th></tr>
            <%
                List<Universes> ul = udao.findAll();
                for (Universes u: ul)
                {
                    out.write("<tr>");
                    out.write("<td>" + u.getTitle().toString() + "</td>");
                    out.write("<td>" + u.getFoundationYear().toString() + "</td>");
                    out.write("<td>" + u.getType().toString()+"</td>");
                    out.write("<td>");
                    out.write("<a href = 'univers.jsp?editId="+u.getIdUniverse()+"'><img class = 'action' src = 'imgs/edit.png'></a>");
                    out.write("<a href = 'univers.jsp?delId="+u.getIdUniverse()+"'><img class = 'action' src = 'imgs/delete.png'></a>");
                    out.write("</td>");
                    out.write("</tr>");
                    
                }
            %>
        </table>
        <div class ="foot">
        <a class ="home" href = "univers.jsp">New Univers</a>
        <a class ="home" href = "heroeslist.jsp">A list of Hero</a>
        </div>
    </body>
</html>
