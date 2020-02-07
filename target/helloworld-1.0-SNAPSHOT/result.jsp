<%@ page import="java.util.List" %>
<%@ page import="com.example.appengine.java8.Entity.Candidate" %>
<%@ page import="com.example.appengine.java8.Entity.VotingResult" %><%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 2/5/2020
  Time: 7:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row row-content">
        <h2>
            <title>Election Result</title>
        </h2>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ELIGIBLE VOTERS</th>
                    <th scope="col">CASTED VOTES</th>
                    <th scope="col">VOTER PARTICIPATION</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int ELIGIBLE_VOTERS = (int) request.getAttribute("ELIGIBLE_Voter");
                    int CASTED_Votes = (int)request.getAttribute("CASTED_Votes");
                    long Percentage = (long)request.getAttribute("Percentage");
                %>

                <tr>
                    <td><%= ELIGIBLE_VOTERS %></td>
                    <td><%= CASTED_Votes %></td>
                    <td><%= Percentage %>%</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Candidate Name</th>
                    <th scope="col">Candidate Faculty </th>
                    <th scope="col">Number of Votes</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<VotingResult> votingResultList = (List<VotingResult>) request.getAttribute("votingResultList");
                    for (VotingResult votingResult : votingResultList){
                %>

                <tr>
                    <td><%= votingResult.getName() %></td>
                    <td><%= votingResult.getFaculty() %></td>
                    <td><%= votingResult.getVotes() %></td>
                </tr>

                <%
                    }
                %>
                </tbody>
            </table>
        </div>

        <div class="container">
            <% String Winner = (String)request.getAttribute("winner"); %>
            <h3>Winner Of Election = <%= Winner %></h3>
        </div>
    </div>
</div>


</body>
</html>


