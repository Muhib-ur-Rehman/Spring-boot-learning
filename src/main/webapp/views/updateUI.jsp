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
                        Boolean resultOfUpdate = (Boolean)request.getAttribute("resultOfUpdate");
                        if (resultOfUpdate != null && resultOfUpdate){
                    %>
                    <p style="background-color:lightgreen;">Record updated successfully...</p>
                    <%} else if(resultOfUpdate!= null && !resultOfUpdate) {%>
                    <p style="background-color:tomato;">Unable to update, please try again...</p>
                    <% } %>

                    <%
                        Boolean resultOfSearch = (Boolean)request.getAttribute("resultOfSearch");
                        if (resultOfSearch != null && !resultOfSearch){%>
                    <p style="background-color:tomato;">Invalid Roll Number, Try again...</p>
                    <%}%>
                    <div class="form center-align">
                        <form action="searchForUpdate" method="post">
                            <input type="text" placeholder="Enter Roll Number" name="rollNum">

                            <button type="submit" class="btn" style="margin-top: 20px; width: 300px;">Search</button>
                        </form>
                        <a href="home">
                            <button type="button" class="btn" style="margin-top: 20px; width: 300px;">Back</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>



</body>
</html>
