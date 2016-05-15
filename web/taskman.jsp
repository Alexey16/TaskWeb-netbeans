<%-- 
    Document   : taskman
    Created on : 15.05.2016, 7:53:58
    Author     : Алексей
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="entity.Taskmanager"%>
<%@page import="dao.TaskmanagerDAO"%>
<%@page import="com.sun.javafx.image.impl.IntArgb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    private TaskmanagerDAO tDao = new TaskmanagerDAO();
%>

<%
    String delId = request.getParameter("delId");
    if(delId != null) {
        Taskmanager delTask = tDao.getById(Integer.parseInt(delId));
        try{
            tDao.delete(delTask);;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        response.sendRedirect("");
        return;
    }
%>

<%
    Taskmanager task = null;
    String idStr = request.getParameter("editId");
    if(idStr != null){
        try {
            int id = Integer.parseInt(idStr);
            task = tDao.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Task manager</title>
         <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        <h1>Task Management System</h1>
        <h2><%
            if(task!=null)
            out.write("Job change");
            else
            out.write("Create job");
            %>
        </h2>
        
        <p>
            <%
                //сохранение задачи при подтверждении формы
                if(request.getParameter("save") != null)
                {
                    if(task==null)
                        task = new Taskmanager();
                    
                    String paramName,paramDesc,paramTime;
                    
                    paramName = request.getParameter("name");
                    if(!paramName.isEmpty())
                        task.setName(new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8"));
                    
                    paramDesc = request.getParameter("description");
                    if(!paramDesc.isEmpty())
                        task.setDescription(new String(request.getParameter("description").getBytes("iso-8859-1"),"UTF-8"));

                    paramTime = request.getParameter("lidetime");
                    if(!paramTime.isEmpty())
                        task.setLidetime((new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ROOT)).parse(paramTime));
                    
                    tDao.save(task, new String(request.getParameter("description").getBytes("iso-8859-1"),"UTF-8"), new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ROOT).parse(paramTime));
                    response.sendRedirect("");
                    return;
                }
            %>
        </p>
        
        <form method = "post">
            Name task<br>
            <input type="text" name ="name" value ="<%=(task!=null) ? task.getName(): ""%>" pattern=".*\S+.*" title ="field must be filled" required/><br>
            Task description<br>
            <input type="text" name ="description" value ="<%=(task!=null) ? task.getDescription(): ""%>" pattern=".*\S+.*" title ="field must be filled" required/><br>
            Lead Time<br>
            <input type="datetime-local" name ="lidetime" value ="<%=(task!=null && task.getLidetime()!= null) ? (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ROOT)).format(task.getLidetime()): ""%>"/><br>
              
              <input type="submit" value="Save" name="save" />
        </form>
        <div class ="foot">
            <a class="home" href = "taskmanlist.jsp">A list of Task</a>
        </div>
    </body>
</html>
