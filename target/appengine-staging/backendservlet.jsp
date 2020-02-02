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
                <td><a href="/datepicker" class="btn btn-info" role="button">Start and End Date</a></td>
            </tr>
            <tr>
                <td><a href="/add_candidate" type="button" class="btn btn-primary">Candidate Adding</a></td>
            </tr>
            <tr>
                <td><a href="/email_import" type="button" class="btn btn-primary">Email Adding</a></td>
            </tr>
            <tr>
                <td>
                    <form id="send_mail"  action="/send_mail" method="post">
                        <button type="button" class="btn btn-primary">Email Reminder</button></td>
                    </form>
            </tr>
        </tbody>
    </table>
</body>
</html>
