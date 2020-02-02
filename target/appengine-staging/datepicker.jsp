<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 1/21/2020
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date picker</title>
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
            <title>Date Picker</title>
        </h2>

        <form role="form" action="date_pick_form" method="post">
            <div class="form-group">
                <label >Begin Of Election</label>
                <input type="datetime-local" name="begin_date" min="1000-01-01"
                       max="3000-12-31" class="form-control" required>
            </div>
            <div class="form-group">
                <label >End Of Election</label>
                <input type="datetime-local" name="ending_date" min="1000-01-01"
                       max="3000-12-31" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
        </form>


    </div>
</div>
</body>
</html>
