<%@ page import="com.example.SpringBootExample1.model.StudentSB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>
    <div class="container">
        <div class="row ">
            <div class="col m8 offset-m1">
                <a href="home" style="horiz-align: right">
                    <button type="button" class="btn" style="margin-top: 20px; width: 200px; horiz-align: right";>Back</button>
                </a>
                <h1>Displaying Students</h1>
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
                              ArrayList<StudentSB> listOfStudent = (ArrayList<StudentSB>) request.getAttribute("listOfStudents");
                              if (listOfStudent!=null){
                              for (StudentSB s : listOfStudent){
                                  String courses="";
                                for(int i = 0;i<s.listOfCourses.size();i++){
                                    courses+=s.listOfCourses.get(i).getCourseName()+" , ";
                                }
                                courses=courses.substring(0,courses.length()-2);
                                  %>
                    <tr>
                        <td><%=s.getStudentId() %></td>
                        <td><%=s.getName()%></td>
                        <td><%=s.getGender() %></td>
                        <td><%=s.getRollNum() %></td>
                        <td><%=s.getAge() %></td>
                        <td><%=courses%></td>
                    </tr>
                        <% }
          }
        %>
            </div>
        </div>
    </div>
</body>
</html>