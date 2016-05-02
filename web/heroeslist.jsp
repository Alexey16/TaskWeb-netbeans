<%-- 
    Document   : heroeslist
    Created on : 14.04.2016, 7:14:10
    Author     : Алексей
--%>

<%@page import="Entity.Heroes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.HeroesDAO"%>
<%@page import="java.net.URLDecoder"%>

<%!
    private HeroesDAO hdao = new HeroesDAO();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Heroes among us</title>
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        <h1>Heroes among us</h1>
        <h2>A list of heroes</h2>
        <table>
            <tr><th>Name</th><th>Gender</th><th>BodyType</th><th>Location</th><th>Actions</th></tr>
            <%
                List<Heroes> hl = hdao.findAll();
                for (Heroes h: hl)
                {
                    out.write("<tr>");
                    out.write("<td>" + h.getName().toString() + "</td>");
                    out.write("<td>" + h.getGender().toString() + "</td>");
                    out.write("<td>" + h.getBodyType().toString()+"</td>");
                    out.write("<td>"+ h.getLocation().toString()+ "</td>");
                    out.write("<td>");
                    out.write("<a href = 'heroes.jsp?editId="+h.getIdHero()+"'><img class = 'action' src = 'imgs/edit.png'></a>");
                    out.write("<a href = 'heroes.jsp?delId="+h.getIdHero()+"'><img class = 'action' src = 'imgs/delete.png'></a>");
                    out.write("</td>");
                    out.write("</tr>");
                    
                }
            %>
        </table>
        <div class ="foot">
        <a class = "home" href = "heroes.jsp">New Hero</a>
        <a class = "home" href = "abilities.jsp">The List of the characters</a>
        <a class = "home" href = "universies.jsp">The Universes</a>
        <a class = "home" href= "heroicabilities.jsp"> Abilities of Heroes</a> 
        </div>
    </body>
</html>
