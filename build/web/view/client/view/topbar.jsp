<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/view/client/static" var="url"></c:url>
<div class="topbar-v3">
	<div class="search-open">
		<div class="container">
			<input type="text" class="form-control" placeholder="Search">
			<div class="search-close">
				<i class="icon-close"></i>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<!-- Topbar Navigation -->
				<ul class="left-topbar">
					<li><a>Currency (USD)</a>
						<ul class="currency">
							<li class="active"><a href="#">USD <i
									class="fa fa-check"></i></a></li>
							<li><a href="#">EURO</a></li>
							<li><a href="#">VND</a></li>

						</ul></li>
					<li><a>Language (EN)</a>
						<ul class="language">
							<li class="active"><a href="#">English (EN)<i
									class="fa fa-check"></i></a></li>
							<li><a href="#">VietNamese (VN)</a></li>
							<li><a href="#">Chinese (CN)</a></li>
						</ul></li>
				</ul>
				<!--/end left-topbar-->
			</div>
			<c:choose>
				<c:when test="${sessionScope.account == null}">
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
							<li><a href="${pageContext.request.contextPath }/login">Login</a>
								| <a href="${pageContext.request.contextPath }/register">Register</a></li>
							
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
							<li><a href="${pageContext.request.contextPath }/member/myaccount">My Account</a> | <a
								href="${pageContext.request.contextPath }/logout">Logout</a></li>
							
						</ul>
					</div>
				</c:otherwise>
			</c:choose>



		</div>
	</div>
	<!--/container-->
</div>
