<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.BestSeller"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jdbc.BestSellerDao"%>
<!DOCTYPE HTML>
<html>
<head>
    
   
<script type="text/javascript">
window.onload = function () {
    var lbl = [
        <c:forEach items="${data}" var="bb"> 
                 
                <c:out value="{label: ${bb.getName()} , y: ${bb.getTotal()}},"/>
        </c:forEach>
    ];
    console.log(lbl);

}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"> </script>
</body>
</html>