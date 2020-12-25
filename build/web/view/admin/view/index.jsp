<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- BOOTSTRAP STYLES-->
<link href="${url}/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${url}/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->
<link href="${url}/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="${url}/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</script>
</head>
<body>
	<div id="wrapper">

		<jsp:include page="/view/admin/view/nav-bar.jsp"></jsp:include>

		<!-- /. NAV TOP  -->
		<jsp:include page="/view/admin/view/slide-bar.jsp"></jsp:include>
                
              
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
                                      
					<div class="col-md-12">
                                            <h2>Top 5 best revenue</h2>
                                            <table border="1px">
                                                <thead>
                                                    <tr>
                                                        <td>Product name</td>
                                                        <td>Total (dollar) </td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${data}" var="bb"> 
                                                        <tr>
                                                            <td>${bb.name}</td>
                                                            <td>${bb.total}</td>  
                                                        </tr>
               
                                      </c:forEach>
                                                </tbody>
                                            </table>
						 
					</div>
                                        
                                    </br>
                                    <div class="col-md-12">
                                            <h2>Top 5 best Buyer</h2>
                                            <table border="1px">
                                                <thead>
                                                    <tr>
                                                        <td>Username</td>
                                                        <td>Total Item </td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${dataBuyer}" var="b"> 
                                                        <tr>
                                                            <td>${b.name}</td>
                                                            <td>${b.total}</td>  
                                                        </tr>
               
                                      </c:forEach>
                                                </tbody>
                                            </table>
						 
				    </div>
				</div>
                       </div> 
				<!-- /. ROW  -->
				<hr />
							<!-- /. ROW  -->
		        
			<!-- /. ROW  -->
		</div>
		<!-- /. PAGE INNER  -->
	</div>
        
                
	<script src="${url}/js/jquery-1.10.2.js"></script>
	<script src="${url}/js/bootstrap.min.js"></script>
	<script src="${url}/js/jquery.metisMenu.js"></script>
	<script src="${url}/js/morris/raphael-2.1.0.min.js"></script>
	<script src="${url}/js/morris/morris.js"></script>
	<script src="${url}/js/custom.js"></script>


</body>
	
</html>