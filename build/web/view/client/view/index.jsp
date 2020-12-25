<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/view/client/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop online</title>
<link rel='stylesheet' type='text/css'
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="${url}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${url}/css/shop.style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="${url}/css/headers/header-v5.css">
<link rel="stylesheet" href="${url}/css/footers/footer-v4.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="${url}/plugins/animate.css">
<link rel="stylesheet" href="${url}/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="${url}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${url}/plugins/scrollbar/css/jquery.mCustomScrollbar.css">
<link rel="stylesheet"
	href="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet"
	href="${url}/plugins/revolution-slider/rs-plugin/css/settings.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${url}/css/theme-colors/default.css"
	id="style_color">

<!-- CSS Customization -->
<link rel="stylesheet" href="${url}/css/custom.css">
</head>
<body>
	<!-- Subiz -->
	<script>
		(function(s, u, b, i, z) {
			u[i] = u[i] || function() {
				u[i].t = +new Date();
				(u[i].q = u[i].q || []).push(arguments);
			};
			z = s.createElement('script');
			var zz = s.getElementsByTagName('script')[0];
			z.async = 1;
			z.src = b;
			z.id = 'subiz-script';
			zz.parentNode.insertBefore(z, zz);
		})(document, window, 'https://widgetv4.subiz.com/static/js/app.js',
				'subiz');
		subiz('setAccount', 'acqetkhujxyunuatbxzw');
	</script>
	<!-- End Subiz -->
<body class="header-fixed">
	<div class="wrapper">
		<!--=== Header v5 ===-->
		<div class="header-v5 header-static">
			<!-- Topbar v3 -->
			<jsp:include page="/view/client/view/topbar.jsp"></jsp:include>
			<!-- End Topbar v3 -->

			<!-- Navbar -->
			<jsp:include page="/view/client/view/navbar.jsp"></jsp:include>
			<!-- End Navbar -->
		</div>
		<!--=== End Header v5 ===-->

		<!--=== Slider ===-->
		<div class="tp-banner-container">
			<div class="tp-banner">
				<ul>					<!-- SLIDE -->
					<li class="revolution-mch-1" data-transition="fade"
						data-slotamount="5" data-masterspeed="1000" data-title="Slide 5">
						<!-- MAIN IMAGE --> <img src="${url}/img/4.jpg" alt="darkblurbg"
						data-bgfit="cover" data-bgposition="right top"
						data-bgrepeat="no-repeat">
						<div class="tp-caption revolution-ch5 sft start" data-x="right"
							data-hoffset="5" data-y="130" data-speed="1500" data-start="500"
							data-easing="Back.easeInOut" data-endeasing="Power1.easeIn"
							data-endspeed="300">
							<strong>Jeans</strong> Collection
						</div> <!-- LAYER -->
						<div class="tp-caption revolution-ch4 sft" data-x="right"
							data-hoffset="-14" data-y="210" data-speed="1400"
							data-start="2000" data-easing="Power4.easeOut"
							data-endspeed="300" data-endeasing="Power1.easeIn"
							data-captionhidden="off" style="z-index: 6">
							Cras non dui et quam auctor pretium.<br> Aenean enim tortr,
							tempus et iteus m
						</div> <!-- LAYER -->
						<div class="tp-caption sft" data-x="right" data-hoffset="0"
							data-y="300" data-speed="1600" data-start="2800"
							data-easing="Power4.easeOut" data-endspeed="300"
							data-endeasing="Power1.easeIn" data-captionhidden="off"
							style="z-index: 6">
							<a href="#" class="btn-u btn-brd btn-brd-hover btn-u-light">Shop
								Now</a>
						</div>
					</li>
					<!-- END SLIDE -->
				</ul>
				<div class="tp-bannertimer tp-bottom"></div>
			</div>
		</div>
	

		

                                                </br></br>

		<div class="container">
			<!--=== Product Service ===-->
			<div class="row margin-bottom-60">
				<div class="col-md-4 product-service md-margin-bottom-30">
					<div class="product-service-heading">
						<i class="fa fa-truck"></i>
					</div>
					<div class="product-service-in">
						<h3>Free Delivery</h3>
						<p>We always bring customer the best quality of items with no fee for delivery</p>
						<a href="#">+Read More</a>
					</div>
				</div>
				<div class="col-md-4 product-service md-margin-bottom-30">
					<div class="product-service-heading">
						<i class="icon-earphones-alt"></i>
					</div>
					<div class="product-service-in">
						<h3>Customer Service</h3>
						<p>The Hotline 19006060 working 24/7. Customer can call at any time!</p>
						<a href="#">+Read More</a>
					</div>
				</div>
				<div class="col-md-4 product-service">
					<div class="product-service-heading">
						<i class="icon-refresh"></i>
					</div>
					<div class="product-service-in">
						<h3>Free Returns</h3>
						<p>If the prodcut is not suitable with you, you can bring it with bill to return it in 3 days</p>
						<a href="#">+Read More</a>
					</div>
				</div>
			</div>
			<!--/end row-->
			<!--=== End Product Service ===-->

			<!--=== Illustration v4 ===-->
			<div class="row illustration-v4 margin-bottom-40">
				<div class="col-md-4">
					<div class="heading heading-v1 margin-bottom-20">
						<h2>Top Rated</h2>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/08.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price line-through">$75.00</li>
							<li class="thumb-product-price">$65.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/09.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price">$75.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/03.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price">$75.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div class="heading heading-v1 margin-bottom-20">
						<h2>Best Sellers</h2>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/02.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price">$75.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/10.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price">$75.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/06.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price line-through">$75.00</li>
							<li class="thumb-product-price">$65.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 padding">
					<div class="heading heading-v1 margin-bottom-20">
						<h2>Sale Items</h2>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/07.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price line-through">$75.00</li>
							<li class="thumb-product-price">$65.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/04.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price">$75.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
					<div class="thumb-product">
						<img class="thumb-product-img" src="${url}/img/thumb/05.jpg"
							alt="">
						<div class="thumb-product-in">
							<h4>
								<a href="shop-ui-inner.html">Yuketen</a> – <a
									href="shop-ui-inner.html">Derby Shoe</a>
							</h4>
							<span class="thumb-product-type">Footwear - Oxfords</span>
						</div>
						<ul class="list-inline overflow-h">
							<li class="thumb-product-price">$75.00</li>
							<li class="thumb-product-purchase"><a href="#"><i
									class="fa fa-shopping-cart"></i></a> | <a href="#"><i
									class="fa fa-heart"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<!--/end row-->
			<!--=== End Illustration v4 ===-->
		</div>
		<!--/end cotnainer-->

		<!--=== Collection Banner ===-->
		<div class="collection-banner">
			<div class="container">
				<div class="col-md-7 md-margin-bottom-50">
					<h2>Makeup collection</h2>
					<p>
						Duis in posuere risus. Vivamus sed dignissim tellus. In vehicula
						justo tempor commodo. <br> Nunc lobortis dapibus neque quis
						lacinia
					</p>
					<br> <a href="#"
						class="btn-u btn-brd btn-brd-hover btn-u-light">Shop Now</a>
				</div>
				<div class="col-md-5">
					<div class="overflow-h">
						<span class="percent-numb">50</span>
						<div class="percent-off">
							<span class="discount-percent">%</span> <span
								class="discount-off">off</span>
						</div>
						<div class="new-offers shop-bg-green rounded-x">
							<p>new</p>
							<span>Products</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--=== End Collection Banner ===-->

		<!--=== Sponsors ===-->
		<div class="container content">
			<div class="heading heading-v1 margin-bottom-40">
				<h2>Sponsors</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
					odio elit, ultrices vel cursus sed, placerat ut leo. Phasellus in
					magna erat. Etiam gravida convallis augue non tincidunt. Nunc
					lobortis dapibus neque quis lacinia. Nam dapibus tellus sit amet
					odio venenatis</p>
			</div>

			<ul class="list-inline owl-slider-v2">
				<li class="item first-child"><img
					src="${url}/img/clients/07.png" alt=""></li>
				<li class="item"><img src="${url}/img/clients/08.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/10.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/11.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/09.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/12.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/07.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/08.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/09.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/10.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/11.png" alt="">
				</li>
				<li class="item"><img src="${url}/img/clients/12.png" alt="">
				</li>
			</ul>
			<!--/end owl-carousel-->
		</div>
		<!--=== End Sponsors ===-->

		<!--=== Shop Suvbscribe ===-->
		<div class="shop-subscribe">
			<div class="container">
				<div class="row">
					<div class="col-md-8 md-margin-bottom-20">
						<h2>
							subscribe to our weekly <strong>newsletter</strong>
						</h2>
					</div>
					<div class="col-md-4">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Email your email..."> <span
								class="input-group-btn">
								<button class="btn" type="button">
									<i class="fa fa-envelope-o"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Shop Suvbscribe ===-->

		<!--=== Footer v4 ===-->
		<jsp:include page="/view/client/view/footer.jsp"></jsp:include>
		<!--=== End Footer v4 ===-->
	</div>
	<!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script src="${url}/plugins/jquery/jquery.min.js"></script>
	<script src="${url}/plugins/jquery/jquery-migrate.min.js"></script>
	<script src="${url}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script src="${url}/plugins/back-to-top.js"></script>
	<script src="${url}/plugins/smoothScroll.js"></script>
	<script src="${url}/plugins/jquery.parallax.js"></script>
	<script src="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script
		src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script
		src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<!-- JS Customization -->
	<script src="${url}/js/custom.js"></script>
	<!-- JS Page Level -->
	<script src="${url}/js/shop.app.js"></script>
	<script src="${url}/js/plugins/owl-carousel.js"></script>
	<script src="${url}/js/plugins/revolution-slider.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			App.initScrollBar();
			App.initParallaxBg();
			OwlCarousel.initOwlCarousel();
			RevolutionSlider.initRSfullWidth();
		});
	</script>
	<!--[if lt IE 9]>
    <script src="${url}/plugins/respond.js"></script>
    <script src="${url}/plugins/html5shiv.js"></script>
    <script src="${url}/js/plugins/placeholder-IE-fixes.js"></script>
<![endif]-->

</body>
</body>
</html>