<%-- 
    Document   : ability
    Created on : 14.04.2016, 12:26:05
    Author     : Алексей
--%>

<%@page import="com.sun.javafx.image.impl.IntArgb"%>
<%@page import="Entity.Abilities"%>
<%@page import="DAO.AbilitiesDAO"%>
<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<%!
    private AbilitiesDAO adao = new AbilitiesDAO();
%>

<%
   //удаление
   String delId = request.getParameter("delId");
   if(delId != null)
   {
       Abilities delAbil = adao.getById(Integer.parseInt(delId));
       try {
           adao.delete(delAbil);
       } catch (NullPointerException e) {
           System.err.print(e); 
       }
       
       response.sendRedirect("abilities.jsp");
       return;
   }
%>

<%
    //получение сссылки на редактируемый объект
    Abilities ability = null;
    String idStr = request.getParameter("editId");
    
    if(idStr != null){
        try {
            int id = Integer.parseInt(idStr);
            ability = adao.getById(id);
        } catch (NullPointerException e){
            System.err.print(e);
        }
    }

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="=text/html; charset = UTF-8">
        <title>Ability Heroes</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Ability</h1>
        <h2><%
            if(ability != null)
                out.write("Change Ability");
            else
                out.write("Creation Ability");
            %>
        </h2>
        
        <p>
            <% 
               
               if(request.getParameter("save") != null)
               {
                   if (ability == null)
                       ability = new Abilities();
                   
                   String param;
                   
                   param = request.getParameter("name");
                   if (!param.isEmpty()){
                       ability.setName(new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8"));
                   } else {
                       ability.setName("");
                       out.write("<p class = 'err'>Is not given a name</p>");
                   } 
                   param = request.getParameter("restrictions");
                   if (!param.isEmpty()){
                       ability.setRestrictions(new String(request.getParameter("restrictions").getBytes("iso-8859-1"),"UTF-8"));
                   } else {
                       ability.setRestrictions("");
                       out.write("<p class = 'err'>Is not given a restrictions</p>");
                   }  

                   adao.save(ability);
                   response.sendRedirect("abilities.jsp");
                   return;

                }
               
               %>
        </p> 
        
        <form method = "post">
            
            Name ability<br>
            <input type="text" name="name" value="<%=(ability != null) ? ability.getName(): ""%>"/><br>
            
            Ability restrictions<br>
            <input type="text" name="restrictions" value="<%=(ability != null) ? ability.getRestrictions() : ""%>"/><br>
        <br>
        
        <input type="submit" value="Save" name="save" />
         
        </form>
            <div class="foot">
                <a class="home" href ="abilities.jsp">Back to the list of abilities</a>
            </div>
        </body>
</html>
