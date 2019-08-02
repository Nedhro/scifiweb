<%-- 
    Document   : index
    Created on : Jul 19, 2019, 12:13:20 PM
    Author     : nidhro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SciFiSoft</title>
    </head>
    <body>

        <h1 align="center">Welcome to SciFiSoft!!!</h1>
        <form action="login" method="post">
            <table border="0" cellspacing="1">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="userName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" name="submit" /></td>
                        <td><input type="reset" value="Reset" name="reset" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
