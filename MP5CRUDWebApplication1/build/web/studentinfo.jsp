<%-- 
    Document   : index
    Created on : 02-Nov-2018, 04:21:06
    Author     : ckumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <table border="1">
            <td><a href="studentinfo.jsp">Student Info</a></td>
             <td><a href="./AllStudents">All Students</a></td>

        </table>
        <br/>
        <form action="./StudentServlet" method="POST">
            <table> 
                <tr>
                    <td>Student ID:</td>
                    <td><input type="text" name="name" value="${student.studentID}"/></td> 
                </tr>
                <tr>
                    
                    
               <td>Name:</td>
                    <td><input type="text" name="name" value="${student.Name}"/></td> 
                </tr>
                <tr>
                     <td>Address:</td>
                    <td><input type="text" name="name" value="${student.Address}"/></td> 
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="operation" value="Add" />
                        <input type="submit" name="operation" value="Edit" />
                        <input type="Submit" name="operation" value="Delete" />
                </tr>
            </table>
            
        </form>
        
    </body>
</html>
