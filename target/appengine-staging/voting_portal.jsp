<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 1/28/2020
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.appengine.java8.Entity.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Voting Portal</title>
    <meta charset=com.example.appengine.java8.Entity.Candidate"utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Voting Portal</h1>

    <div class="col-sm-3">
        <form role="form" action="/user/adding_vote_database" method="post">

            <% List<Candidate> candidateList = (List<Candidate>) request.getAttribute("CandidateList");
                for(Candidate candidate: candidateList) {
            %>
            <div class="radio">
                <label><input type="radio" name="candidate_name_vote" value="<%= candidate.getKey() %>" checked><%= candidate.name %></label>
            </div>
            <% } %>

            <% String voterKey = (String)request.getAttribute("VoterKey"); %>
            <div class="form-group">
                <label>Your One Time Token for Election</label>
                <input type="text" class="form-control .col-sm-*" name="student_key" value="<%= voterKey %>" readonly>
            </div>


            <button type="submit" class="btn btn-success">Submit</button>
        </form>
    </div>
</body>
</html>
