<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.SpringBootExample1.model.StudentSB" %>
<%@ page import="com.example.SpringBootExample1.model.CourseSB" %><%--
  Created by IntelliJ IDEA.
  User: mrehman
  Date: 31/08/2021
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <title>Title</title>
</head>
<body>
    <%
        List<StudentSB> listOfStudent = (List<StudentSB>)request.getAttribute("listOfStudents");
        List<CourseSB> listOfCourses = (List<CourseSB>) request.getAttribute("listOfCourse");
    %>

    <div class="container">
        <div class="row ">
            <div class="col m6 offset-m3">
                <div class="card">
                    <div class="card-content">
                        <h3 class="center-align">Update Student Record</h3>
                        <div class="form center-align">
                            <form action="updateStd" method="post">
                                <%
                                    Object resultOfAdd =request.getAttribute("resultOfAdd");
                                    if (resultOfAdd != null){
                                        if (!resultOfAdd.toString().equals("0")){ %>
                                <p style="background-color:lightgreen;">Records added successfully...</p>
                                <% }
                                    if (resultOfAdd.toString().equals("0")) { %>
                                <p style="background-color:tomato;">Unable to add record...</p>
                                <%}
                                }%>
                                <input type="text" placeholder="Enter Student Name" name="name" value="<%= listOfStudent.get(0).getName() %>">
                                <input type="text" placeholder="Enter Roll Number" name="rollNum" value="<%= listOfStudent.get(0).getRollNum() %>">
                                <input type="text" placeholder="Enter Age" name="age" value="<%= listOfStudent.get(0).getAge() %>">
                                <input type="hidden" name="studentId" value="<%= listOfStudent.get(0).getStudentId() %>">
                                <div class="input-field col s12">
                                    <select name="listOfCourses" multiple>
                                        <option value="" disabled selected>Choose your option</option>
                                        <% for (int i = 0; i<listOfCourses.size();i++){ boolean flag=false;
                                            for (int j = 0 ; j<listOfStudent.get(0).listOfCourses.size();j++){
                                                if (listOfCourses.get(i).getCourseId()==listOfStudent.get(0).listOfCourses.get(j).getCourseId()){
                                                    flag=true; break; } }
                                            if (flag){ %>
                                        <option selected value="<%= listOfCourses.get(i).getCourseId() %>"><%= listOfCourses.get(i).getCourseName()%></option>
                                        <% }else { %>
                                            <option value="<%= listOfCourses.get(i).getCourseId() %>"><%= listOfCourses.get(i).getCourseName()%></option>
                                        <%} } %>
                                    </select>
                                </div>

                                <p> <span>Gender</span>  &nbsp;  &nbsp;
                                    <% if (listOfStudent.get(0).getGender().equals("Male")) { %>
                                    <label>
                                        <input name="gender" type="radio" value="Male" checked />
                                        <span>Boy</span>  &nbsp;  &nbsp;
                                    </label>
                                    <label>
                                        <input name="gender" type="radio" value="Female" />
                                        <span>Girl</span>
                                    </label>
                                    <% } else{%>
                                    <label>
                                        <input name="gender" type="radio" value="Male" />
                                        <span>Boy</span>  &nbsp;  &nbsp;
                                    </label>
                                    <label>
                                        <input name="gender" type="radio" value="Female" checked />
                                        <span>Girl</span>
                                    </label>
                                    <% } %>
                                </p>
                                <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">Update</button>
                            </form>
                            <a href="home">
                                <button type="button" class="btn" style="margin-top: 20px; width: 300px;">Back</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>
<style>
    select {
        display: block;
    }
</style>