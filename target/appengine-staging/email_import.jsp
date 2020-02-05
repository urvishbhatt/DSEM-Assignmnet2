<%--
  Created by IntelliJ IDEA.
  User: ubhatt
  Date: 1/28/2020
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Import</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
    <div class="col-sm-3">
        <form id="upload_file_form_id"  action="email_import_data" method="post" enctype="multipart/form-data">
            <div class="custom-file">
                <input type="file" class="custom-file-input" id="file_id" name="myFile">
                <input type="submit" style="display:inline;" class="btn btn-primary" value="Upload">
                <small  class="form-text text-muted">
                    Upload a CSV file that contains email
                </small>
            </div>
        </form>
    </div>
</body>
</html>
