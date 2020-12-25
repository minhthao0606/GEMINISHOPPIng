<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <c:url value="/view/client/static" var="url"></c:url>
      
 <div class="navbar navbar-default mega-menu" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://localhost:8080/GEMINISHOPPING/faces/view/client/view/index.jsp">
                        <img id="logo-header" src="${url}/img/logo.jpg" alt="Logo">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <!-- Shopping Cart -->
                   <jsp:include page="/view/client/view/cart.jsp"></jsp:include>
                    <!-- End Shopping Cart -->

                    <!-- Nav Menu -->
                    <ul class="nav navbar-nav">
                        <!-- Pages -->
                        <li class="dropdown active">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                                Pages
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath }/product/list">Product Page</a></li>
                                <li><a href="${pageContext.request.contextPath }/product/list">Filter Grid Page</a></li>
                                <li><a href="${pageContext.request.contextPath }/member/cart">Cart</a></li>
                                <li><a href="${pageContext.request.contextPath }/member/order">Checkout</a></li>
                                <li><a href="${pageContext.request.contextPath }/login">Login</a></li>
                                <li class="active"><a href="${pageContext.request.contextPath }/register">Register</a></li>
                            </ul>
                        </li>
                        <!-- End Pages -->

                        <!-- TOP -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                                TOP
                            </a>
                            <ul class="dropdown-menu">

                                        <li><a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=1">T-Shirt</a></li>
                                        <li><a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=7">Tank Top</a></li>
                                        <li><a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=7">Jacket</a></li>
                                        <li><a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=8">Sweater</a></li>
                            </ul>
                        </li>
                        <!-- TOP-->

                        <!-- Bottom -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                                BOTTOM
                            </a>
                            <ul class="dropdown-menu">

                                        <li><a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=2">Short</a></li>
                                        <li><a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=5">Pant</a></li>
                            </ul>
                        </li>
                        <!-- End Bottom -->

                        <!-- HAT -->
                         <li class="dropdown">
                            <a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=3">HAT</a>  
                           
                        </li>
                        <!-- End HAT -->

                        <!-- BAG -->
                        <li class="dropdown">
                            <a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=4">BAG</a>  
                        </li>
                        <!-- End BAG-->

                        <!-- SHOES -->
                        <li class="dropdown">
                            <a href="http://localhost:8080/GEMINISHOPPING/product/category?cate_id=6">SHOES</a>  
                        </li>
                        <!--END SHOES-->
                    </ul>
                    <!-- End Nav Menu -->                    
                </div>
            </div>    
        </div>            