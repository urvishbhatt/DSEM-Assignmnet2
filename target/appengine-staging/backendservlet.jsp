<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 1/21/2020
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Backend Servlet</title>
</head>
<body>
    <table class="row container">
        <thead>
            <tr>
                <th>Backend Servlet</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><a href="/backend/datepicker" class="btn btn-info" role="button">Start and End Date</a></td>
            </tr>
            <tr>
                <td><a href="/backend/add_candidate" type="button" class="btn btn-primary">Candidate Adding</a></td>
            </tr>
            <tr>
                <td><a href="/backend/email_import" type="button" class="btn btn-primary">Email Adding</a></td>
            </tr>
        </tbody>
    </table>

    <div class="col-sm-3">
        <form role="form" action="/backend/send_mail" method="post">
            <button type="submit" class="btn btn-success">Email Reminder</button>
        </form>
    </div>
</body>
</html>
