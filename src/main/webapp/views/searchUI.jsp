<%@ page import="jdk.dynalink.linker.LinkerServices" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.SpringBootExample1.model.StudentSB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>
<div class="container">
    <div class="row ">
        <div class="col m6 offset-m3">
            <div class="card">
                <div class="card-content">
                    <h3 class="center-align">Search Student Record</h3>

                    <%
                        Boolean resultOfSearch = (Boolean)request.getAttribute("resultOfSearch");
                        if (resultOfSearch != null && !resultOfSearch){%>
                            <p style="background-color:tomato;">Invalid Roll Number, Try again...</p>
                    <% } %>
                    <div class="form center-align">
                        <form action="searchStudent" method="post">
                            <input type="text" placeholder="Enter Roll Number" name="rollNum">

                            <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">Search</button>
                        </form>
                        <a href="home">
                            <button type="button" class="btn" style="margin-top: 20px; width: 300px;">Back</button>
                        </a>
                    </div>
                </div>
                <%
                    List<StudentSB> listOfStudent = (List<StudentSB>) request.getAttribute("listOfStudent");
                    if (listOfStudent != null) {%>
                <table border ="1" width="500" align="center">
                    <tr bgcolor="00FF7F">
                        <th><b>Id</b></th>
                        <th><b>Name</b></th>
                        <th><b>Gender</b></th>
                        <th><b>Roll Number</b></th>
                        <th><b>Age</b></th>
                        <th><b>Courses</b></th>
                    </tr>

                        <%
                              if (listOfStudent!=null){
                              for (StudentSB s : listOfStudent){
                                  String courses="";
                                for(int i = 0;i<s.listOfCourses.size();i++){
                                    courses+=s.listOfCourses.get(i).getCourseName()+" , ";
                                }
                                courses=courses.substring(0,courses.length()-2);%>
                    <tr>
                        <td><%=s.getStudentId() %></td>
                        <td><%=s.getName() %></td>
                        <td><%=s.getGender() %></td>
                        <td><%=s.getRollNum() %></td>
                        <td><%=s.getAge() %></td>
                        <td><%=courses %></td>
                    </tr>
                        <% }
          }
        %>

                    <%}%>
            </div>
        </div>
    </div>




</div>
</body>
</html>
