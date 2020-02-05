<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 1/28/2020
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add cadidate</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body class="bg-light" style="background-color:#DCECEC">
<div class="container">
    <div class="row row-content">
        <h2>
            <title>Candidate Creation</title>
        </h2>
        <div class="col-sm-3">
            <form role="form" action="/backend/adding_candidate_database" method="post">
                <div class="form-group">
                    <label>Candidate Name</label>
                    <input type="text" class="form-control .col-sm-*" name="candidate_name" required>
                </div>
                <div class="form-group">
                    <label>Candidate Surname</label>
                    <input type="text" class="form-control inputsm" name="candidate_surname" required>
                </div>
                <div class="form-group">
                    <label>Candidate Faculty</label>
                    <input type="text" class="form-control inputsm" name="candidate_faculty" required>
                </div>

                <button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>