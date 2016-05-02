<%-- 
    Document   : heroicability
    Created on : 24.04.2016, 15:16:01
    Author     : Алексей
--%>

<%@page import="Entity.Abilities"%>
<%@page import="Entity.Heroes"%>
<%@page import="java.util.List"%>
<%@page import="Entity.HeroicAbilities"%>
<%@page import="DAO.AbilitiesDAO"%>
<%@page import="DAO.HeroesDAO"%>
<%@page import="DAO.HeroicAbilitiesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.sun.javafx.image.impl.IntArgb"%>

<%!
    HeroicAbilitiesDAO haDAO = new HeroicAbilitiesDAO();
    HeroesDAO hdao = new HeroesDAO();
    AbilitiesDAO adao = new AbilitiesDAO();
%>

<%
   //удаление
   String delId = request.getParameter("delId");
   if(delId != null)
   {
       HeroicAbilities delHA = haDAO.getById(Integer.parseInt(delId));
       try {
           haDAO.delete(delHA);
       } catch (Exception e) {
           System.err.print(e);
       }
       
       response.sendRedirect("heroicabilities.jsp");
       return;
   }
%>

<%
    //получение сссылки на редактируемый объект
    HeroicAbilities hab = null;
    String idStr = request.getParameter("editId");
    
    if(idStr != null){
        try {
            int id = Integer.parseInt(idStr);
            hab = haDAO.getById(id);
        } catch (Exception e){
            System.err.print(e);
        }
    }

%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abilities of Hero</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>abilities of heroes</h1>
        <h2>
            <%
                if(hab != null)
                    out.write("Change ability of hero");
                else
                    out.write("Creation Ability of Hero");
            %>
        </h2>
        
            <p>
            <% 

               if(request.getParameter("save") != null)
               {
                   if (hab == null)
                       hab = new HeroicAbilities();
                   
                   String param;
                   
                   param = request.getParameter("specific_features");
                   if (!param.isEmpty()){
                       hab.setSpecificFeatures(new String(request.getParameter("specific_features").getBytes("iso-8859-1"),"UTF-8"));
                   } else {
                       hab.setSpecificFeatures("");
                       out.write("<p class = 'err'>Is not given a location</p>");
                   }
                   
                   param = request.getParameter("id_hero");
                   if (!param.isEmpty()){
                       hab.setHeroes(hdao.getById(Integer.parseInt(param)));
                   }
                   
                   param = request.getParameter("id_ability");
                   if (!param.isEmpty()){
                       hab.setAbilities(adao.getById(Integer.parseInt(param)));
                   }
                   
                   haDAO.save(hab);
                   response.sendRedirect("heroicabilities.jsp");
                   return;
                   

               }
            %>
        </p>
        
        <form method = "post">
            Specific Features<br>
            <input type="text" name="specific_features" value="<%=(hab != null) ? hab.getSpecificFeatures(): ""%>"/><br>
            
            Hero<br>
            <select name="id_hero">
                <%
                    List<Heroes> hl = hdao.findAll();
                    for(Heroes h: hl)
                    {
                        out.write("<option ");
                        if (hab != null && hab.getHeroes().getIdHero()== h.getIdHero())
                        {
                            out.write("selected ");
                        }
                        
                        out.write("value =" + h.getIdHero()+ ">" + h.getName() + "\n");
                    }
                %>
            </select><br>
            
            Ability<br>
            <select name="id_ability">
                <%
                    List<Abilities> al = adao.findAll();
                    for(Abilities a: al)
                    {
                        out.write("<option ");
                        if (hab != null && hab.getAbilities().getIdAbility()== a.getIdAbility())
                        {
                            out.write("selected ");
                        }
                        
                        out.write("value =" + a.getIdAbility()+ ">" + a.getName() + "\n");
                    }
                %>
            </select><br>
            
             <input type="submit" value="Save" name="save" />
             
        </form>
            <div class="foot">
                <a class="home" href ="heroicabilities.jsp">Back to the list Abilities of Heroes</a>
            </div>
    </body>
</html>
