<%-- 
    Document   : univers
    Created on : 24.04.2016, 15:15:42
    Author     : Алексей
--%>
<%@page import="com.sun.javafx.image.impl.IntArgb"%>
<%@page import="Entity.Universes"%>
<%@page import="DAO.UniversesDAO"%>
<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    private UniversesDAO udao = new UniversesDAO();
%>

<%
   //удаление
   String delId = request.getParameter("delId");
   if(delId != null)
   {
       Universes deleteUnivers = udao.getById(Integer.parseInt(delId));
       try {
           udao.delete(deleteUnivers);
       } catch (Exception e) {
           System.err.print(e); 
       }
       
       response.sendRedirect("universies.jsp");
       return;
   }
%>

<%
    //получение сссылки на редактируемый объект
    Universes univer = null;
    String idStr = request.getParameter("editId");
    
    if(idStr != null){
        try {
            int id = Integer.parseInt(idStr);
            univer = udao.getById(id);
        } catch (Exception e){
            System.err.print(e);
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="=text/html; charset = UTF-8">
        <title>Universes</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Universes</h1>
        <h2><%
            if(univer != null)
                out.write("Change Universes");
            else
                out.write("Creation Universes");
            %>
        </h2>
        
        <p>
            <% 
               //сохранение героя при подтверждении формы
               if(request.getParameter("save") != null)
               {
                   if (univer == null)
                       univer = new Universes();
                   
                   String param;
                   
                   param = request.getParameter("title");
                   if (!param.isEmpty()){
                       univer.setTitle(new String(request.getParameter("title").getBytes("iso-8859-1"),"UTF-8"));
                   }else {
                       univer.setTitle("");
                       out.write("<p class = 'err'>Is not given a title</p>");
                   }
                   
                   param = request.getParameter("foundation_year");
                   if (!param.isEmpty()){
                       univer.setFoundationYear(Short.parseShort(param));
                   }
                   
                   param = request.getParameter("type");
                   if (!param.isEmpty()){
                       univer.setType(new String(request.getParameter("type").getBytes("iso-8859-1"),"UTF-8"));
                   } else {
                       univer.setType("");
                       out.write("<p class = 'err'>Is not given a type</p>");
                   }
                   
                   
                    udao.save(univer);
                    response.sendRedirect("universies.jsp");
                    return;
                   
                   
                }
               
            %>
        </p> 
        
        <form method = "post">
            Title<br>
            <input type="text" name="title" value="<%=(univer != null) ? univer.getTitle(): ""%>"/><br>
            
            Foundation Year<br>
            <input type="number" name="foundation_year" value="<%=(univer != null) ? univer.getFoundationYear(): ""%>"/><br>
            
            Type<br>
            <input type="text" name="type" value="<%=(univer != null) ? univer.getType(): ""%>"/><br>
            
             <input type="submit" value="Save" name="save" />
             
        </form>
            <div class="foot">
                <a class="home" href ="universies.jsp">Back to the list of Universes</a>
            </div>
        </body>
</html>
