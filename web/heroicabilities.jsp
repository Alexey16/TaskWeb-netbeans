<%-- 
    Document   : heroicabilities
    Created on : 24.04.2016, 15:08:53
    Author     : Алексей
--%>


<%@page import="Entity.HeroicAbilities"%>
<%@page import="java.util.List"%>
<%@page import="DAO.HeroicAbilitiesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private HeroicAbilitiesDAO hadao = new HeroicAbilitiesDAO();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Heroic Abilities</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Heroic Abilities</h1>
        <h2>A list of heroic abilities</h2>
        <table>
            <tr><th>Name Hero</th><th>Ability</th><th>Specific features</th><th>Action</th></tr>
            <%
                List<HeroicAbilities> hal = hadao.findAll();
                for (HeroicAbilities h : hal)
                {
                    out.write("<tr>");
                    out.write("<td>" + h.getHeroes().getName().toString() + "</td>");
                    out.write("<td>" + h.getAbilities().getName().toString() + "</td>");
                    out.write("<td>" + h.getSpecificFeatures().toString()+"</td>");
                    out.write("<td>");
                    out.write("<a href = 'heroicability.jsp?editId="+h.getIdHab() +"'><img class = 'action' src = 'imgs/edit.png'></a>");
                    out.write("<a href = 'heroicability.jsp?delId="+h.getIdHab() +"'><img class = 'action' src = 'imgs/delete.png'></a>");
                    out.write("</td>");
                    out.write("</tr>");  
                }
            %>
        </table>
        <div class="foot">
            <a class ="home" href="heroicability.jsp"> New Heroic Ability </a>
            <a class ="home" href="heroeslist.jsp"> List of Hero </a>
            <a class ="home" href="abilities.jsp"> List of abilities </a>
        </div>
    </body>
</html>
