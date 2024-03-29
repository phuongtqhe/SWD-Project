<%-- 
    Document   : Home
    Created on : Mar 13, 2024, 11:25:59 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container" style="background-color: #d7d7d7; height: 100vh">
            <div><h1>Agency site</h1></div>
            <div class="row" style="background-color: #d7d7d7; height: 100%">
                <div class="col-md-7">
                    <div class="m-2 p-3 d-flex flex-column" style="background: #FFFFFF; height: 90%;  border-radius: 20px" >
                        <div class="d-flex align-items-start justify-content-between">
                            <h3>Id: ${requestScope.displayRequestData.id}</h3>
                            <div class="d-flex align-items-center" style="gap: 10px">
                                <form action="/SDWProject/UpdateRequestStatus" method="get">
                                    <input style="display: none" name="id" value="${requestScope.displayRequestData.id}"/>
                                    <select class="form-select" name="statusId" style="width: 300px" aria-label="Update status">
                                        <c:forEach items="${requestScope.requestStatus}" var="rs">
                                            <c:if test="${rs.id != requestScope.displayRequestData.requestStatusId}">
                                                <option value="${rs.id}">${rs.name}</option>
                                            </c:if>
                                            <c:if test="${rs.id == requestScope.displayRequestData.requestStatusId}">
                                                <option selected value="${rs.id}">${rs.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="commitCheckbox" required>
                                        <label class="form-check-label" for="commitCheckbox">
                                            I commit this change
                                        </label>
                                    </div>
                                    <button class="btn btn-primary" onclick="validateCommit()">Save</button>
                                </form>
                                    
                                <script>
                                    function validateCommit() {
                                        const commitCheckbox = document.getElementById('commitCheckbox');
                                        if (!commitCheckbox.checked) {
                                            alert('Please check the "I commit this change" box.');
                                            return false; // Prevent form submission
                                        } else{
                                            alert('Up date status successful');
                                            return false; // Prevent form submission
                                        }
                                        // If checkbox is checked, allow form submission
                                        showSuccessMessage();
                                        return true;
                                    }
                                </script>
                                
                            </div>
                        </div>
                        <div style="background: antiquewhite" class="p-3 col-md-6">
                            <b>User information :</b>
                            <p>User name : ${requestScope.account.username}</p>
                            <p>User phone : ${requestScope.account.phone}</p>
                            <button class="btn btn-primary">View account detail</button>
                        </div>
                        <div>
                            <p><b>Time:</b> ${requestScope.displayRequestData.timestamp}</p>
                            <p><b>Service type:</b> ${requestScope.publicService.type}</p>
                            <p><b>Service:</b> ${requestScope.publicService.name} </p>
                            <p><b>Request content:</b> ${requestScope.displayRequestData.description}</p>
                            <a href="${requestScope.displayRequestData.fileUrl}" ><b>Attached files</b></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="m-2" style="background: #FFFFFF;height: 90%;  border-radius: 20px">
                        <table class="table" style=" border-radius: 20px">
                            <tbody style=" border-radius: 20px">
                            <thead style=" border-radius: 20px">
                                <tr style=" border-radius: 20px">
                                    <th style=" border-radius: 20px" scope="col">id</th>
                                    <th scope="col">Time</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Status</th>
                                    <th  style=" border-radius: 20px" scope="col">Handle</th>
                                </tr>
                            </thead>
                            <c:forEach items="${requestScope.data}" var="r">
                                <tr style=" border-radius: 20px">
                                    <th style=" border-radius: 20px" scope="row">${r.id}</th>
                                    <td>${r.timestamp}</td>
                                    <td>${r.description}</td>
                                    <td style=" border-radius: 20px">${r.requestStatusId}</td>
                                    <td><a href="/SDWProject/Home?id=${r.id}" class="btn btn-primary">View</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
