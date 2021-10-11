<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="boutique.model.UserBean, boutique.model.EmployeeBean, boutique.dao.UserDAO, java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html> 
	<head>
		<meta charset="utf-8" />
		<title>Homepage</title>
		<meta name="keywords" content="HTML5,CSS3,Template" />
		<meta name="description" content="" />
		<meta name="Author" content="Dorin Grigoras [www.stepofweb.com]" />

		<!-- mobile settings -->
		<meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />

		<!-- WEB FONTS -->
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800" rel="stylesheet" type="text/css" />

		<!-- CORE CSS -->
		<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css" />
		<link href="assets/plugins/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css" />
		<link href="assets/plugins/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css" />
		<link href="assets/plugins/owl-carousel/owl.transitions.css" rel="stylesheet" type="text/css" />
		<link href="assets/plugins/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/animate.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/superslides.css" rel="stylesheet" type="text/css" />
		<!-- Morenizr -->
		<script type="text/javascript" src="assets/plugins/modernizr.min.js"></script>

		<!-- REVOLUTION SLIDER -->
		<link href="assets/plugins/revolution-slider/css/settings.css" rel="stylesheet" type="text/css" />

		<!-- THEME CSS -->
		<link href="assets/css/essentials.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout-responsive.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/color_scheme/pink.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
    <%  UserBean currentUser = (UserBean)session.getAttribute("currentSessionUser");%> 
		<!-- TOP NAV -->
		<header id="topNav">
			<div class="container">

				<!-- Mobile Menu Button -->
				<button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
					<i class="fa fa-bars"></i>
				</button>

				<!-- Logo text or image -->
				<a class="logo" href="index.html">
						<i class="fa fa-leaf"> Zarisa Boutique</i>
				</a>

				<!-- Top Nav -->
				<div class="navbar-collapse nav-main-collapse collapse pull-right">
					<nav class="nav-main mega-menu">
						<ul class="nav nav-pills nav-main scroll-menu" id="topMain">
							<li class="dropdown">
								<a class="dropdown-toggle" href="#product">
									Product <i class=""></i>
								</a>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle" href="#about">
									Locate Us <i class=""></i>
								</a>								
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle" href="#projectGroup">
									About Company <i class=""></i>
								</a>								
							</li>
							<li class="dropdown active">
								<a class="dropdown-toggle" href="#">
									Employee <i class="fa fa-angle-down"></i>
								</a>
								<ul class="dropdown-menu">
									<li><a href="addEmployee.jsp">Add</a></li>
									<li><a href="ListEmployee.jsp">View</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle" href="viewReport.jsp">
									View Report <i class=""></i>
								</a>								
							</li>
							<li><a href="index.html">Log Out</a></li>
						</ul>
					</nav>
				</div>
				<!-- /Top Nav -->

			</div>
		</header>

		<span id="header_shadow"></span>
		<!-- /TOP NAV -->

		<!-- WRAPPER -->
		<div id="wrapper">
			
			<header id="page-title" class="big parallax" data-stellar-background-ratio="0.2" style="background-image:url('assets/images/geo.jpg');">
				<span class="overlay"><!-- image overlay --></span>

				<div class="container">
					<h1 class="text-center"> <b>Zarisa Boutique</b></h1>
				</div>
			</header>

			<section class="container text-center" id="product">
				<h1 class="text-center">
					<strong>Welcome</strong> to Zarisa Boutique
					<span class="subtitle">PROVIDING HIGH-QUALITY PRODUCT</span>
				</h1>
				<p class="lead">We are here to provide 100% quality of hand made item for our customer. You've found us! If you are addicted to fashion, fun and looking fabulous, you are in the right place!</p>
			</section>


			<div class="container">
				<hr class="half-margins" /><!-- hr line -->
			</div>


			<!-- FEATURED BOXES 3 -->
			<section class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="featured-box nobg border-only">
							<div class="box-content">
								<i class="fa fa-gift"></i>
								<h4>Scarf</h4>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="featured-box nobg border-only left-separator">
							<i class="fa fa-leaf"></i>
							<h4>Blouse</h4>
						</div>
					</div>
					<div class="col-md-3">
						<div class="featured-box nobg border-only left-separator">
							<i class="fa fa-cloud"></i>
							<h4>Skirt</h4>
						</div>
					</div>
					<div class="col-md-3">
						<div class="featured-box nobg border-only left-separator">
							<i class="fa fa-gears"></i>
							<h4>Shirt</h4>
						</div>
					</div>
				</div>
			</section>
			<!-- /FEATURED BOXES 3 -->

			<div class="container" id="about">
				<hr class="no-lines" /><!-- hr line -->
			</div>

			<!-- CAROUSEL -->
			<section class="container" >
				<div class="row">

					<div class="col-md-6">
						<h2>Locate us</h2>
						<p class="text-justify">You've found us! If u are addicted to fashion,fun and looking fabulous,you are in the right place!
						Here at Curves,you'll find that this is the destination for all your fashion needs from pretty dresses and party frocks to sharp outer and hot jeans,not to mention fabulous shoes,bags and accessories.....
						Therefore,we invite you to comb through our product descriptions,flip through our collections,shop our vast assortments of stylish pieces,find some unique one of a kinds and get in touch with us if u have any inquiries or questions...
						Featuring individually picked,deliciously different fashion,we serves up the perfect mix of hottest designs ....
						Supplying you with the opportunities to have your voice heard is what keeps our company fresh,relevant and growing by leaps and bounds!!
						We want to be the fashion company you're friends with!!
						Happy shopping and welcome to our dreams :)</p>		
					</div>

					<div class="col-md-6">
							<div class="owl-carousel controlls-over" data-plugin-options='{"items": 1, "singleItem": true, "navigation": true, "pagination": false, "transitionStyle":"fadeUp"}'>
								<div>
								<img class="img-responsive" src="assets/images/b4.jpg" width="555" height="311" alt="">
							</div>
							<div>
								<img class="img-responsive" src="assets/images/b2.jpg" width="555" height="311" alt="">
							</div>
							<div>
								<img class="img-responsive" src="assets/images/b3.jpg" width="555" height="311" alt="">
							</div>
							<div>
								<img class="img-responsive" src="assets/images/b1.jpg" width="555" height="311" alt="">
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /CAROUSEL -->


			<!-- CALLOUT -->
			<div class="bs-callout margin-top text-center styleBackground noradius" >
				<h3>Join us as <b>STAFF</b> now!<strong> We are to help you!</strong>!
				<a href="LoginAdmin.html" class="btn btn-primary btn-lg">Log In</a></h3>
			</div>
			<!-- /CALLOUT -->

			<!-- PARALLAX -->
				<section class="parallax delayed margin-footer" data-stellar-background-ratio="0.7" style="background-image: url('assets/images/op.jpg');" id="projectGroup">
					<span class="overlay"></span>

					<div class="container" >

						<h2>About <b>Company</b></h2>
						<div class="row">
							<div class="col-md-2 col-md-offset-1"><!-- item 3 -->
								<div class="item-box">
									<figure>
										<img class="img-responsive"  src="assets/images/farhana.png" width="263" height="263" alt="">
									</figure>
										<div class="item-box-desc">
											<h4>FARHANA</h4>
											<small class="styleColor">CEO</small>
										</div>
								</div>
							</div>
							<div class="col-md-2"><!-- item 5 -->
								<div class="item-box">
									<figure>
										<img class="img-responsive" src="assets/images/syazana.png" width="263" height="263" alt="">
									</figure>
									<div class="item-box-desc">
										<h4>SYAZANA</h4>
										<small class="styleColor">PEOPLE MANAGER</small>
									</div>
								</div>
							</div>

							<div class="col-md-2"><!-- item 7 -->
								<div class="item-box">
									<figure>
										<img class="img-responsive"  src="assets/images/shaira.png" width="263" height="263" alt="">
									</figure>
									<div class="item-box-desc">
										<h4>SHAIRAH</h4>
										<small class="styleColor">AUDITOR</small>
									</div>
								</div>
							</div>

							<div class="col-md-2"><!-- item 8 -->
								<div class="item-box">
									<figure>
										<img class="img-responsive"  src="assets/images/amira.png" width="263" height="263" alt="">
									</figure>
									<div class="item-box-desc">
										<h4>AMIRAH</h4>
										<small class="styleColor">ADMINISTRATOR</small>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="item-box">
									
								</div>
							</div>
						</div>	
					</div>
			</section>
			<!-- PARALLAX -->

		</div>
		<!-- /WRAPPER -->



		<!-- FOOTER -->
		<footer>

			<!-- copyright , scrollTo Top -->
			<div class="footer-bar">
				<div class="container">
					<span class="copyright">Copyright &copy; Zarisa Boutique, LLC . All Rights Reserved.</span>
					<a class="toTop" href="#topNav">BACK TO TOP <i class="fa fa-arrow-circle-up"></i></a>
				</div>
			</div>
			<!-- copyright , scrollTo Top -->


			<!-- footer content -->
			<div class="footer-content">
				<div class="container">

					<div class="row">

						<!-- FOOTER CONTACT INFO -->
						<div class="column col-md-6">
							CONTACT <strong>US</strong><br><br>

							<address class="font-opesans">
								<ul>
									<li class="footer-sprite address">
										No.4-E-2, Jalan Elektron U16/3F,<br>
										Shah Alam 40160,<br>
										Selangor, Malaysia.<br>
									</li>
									<li class="footer-sprite phone">
										Tel	: 06-9681107<br>
										Fax : 06-8961107<br>
									</li>
									<li class="footer-sprite email">
										<a href="mailto:enquiry.formZB@gmail.com">enquiry.formZB@gmail.com</a>
									</li>
								</ul>
							</address>
						</div>
						<div class="column col-md-6">
								<ul>
									<p class="text-justify">DISCLAIMER  <strong><u>ZARISA BOUTIQUE</u></strong><br/><br/>
										 HERE WILL MAKE A REASONABLE EFFORT TO ENSURE THAT SHIPPING INFORMATION, PRODUCT PRICE(S), PRODUCT DESCRIPTION(S) AND OTHER INFORMATION IS CORRECT. HOWEVER, ZBCANNOT GUARANTEE THE ACCURACY OF THE INFORMATION AND MAKES NO WARRANTIES OR REPRESENTATIONS AS TO ITS ACCURACY. ZB WILL NOT BE LIABLE FOR ANY LOSS OR DAMAGE OF ANY KIND ARISING FROM THE USE, INCLUDING WITHOUT LIMITATION, DIRECT, INDIRECT, INCIDENTAL, PUNITIVE AND CONSEQUENTIAL LOSS OR DAMAGE.
									</p>
								</ul>
							</div>
						<!-- /FOOTER CONTACT INFO -->
					</div>
				</div>
			</div>
			<!-- footer content -->

		</footer>
		<!-- /FOOTER -->



		<!-- JAVASCRIPT FILES -->
		<script type="text/javascript" src="assets/plugins/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="assets/plugins/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="assets/plugins/jquery.cookie.js"></script>
		<script type="text/javascript" src="assets/plugins/jquery.appear.js"></script>
		<script type="text/javascript" src="assets/plugins/jquery.isotope.js"></script>
		<script type="text/javascript" src="assets/plugins/masonry.js"></script>

		<script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="assets/plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
		<script type="text/javascript" src="assets/plugins/owl-carousel/owl.carousel.min.js"></script>
		<script type="text/javascript" src="assets/plugins/stellar/jquery.stellar.min.js"></script>
		<script type="text/javascript" src="assets/plugins/knob/js/jquery.knob.js"></script>
		<script type="text/javascript" src="assets/plugins/jquery.backstretch.min.js"></script>
		<script type="text/javascript" src="assets/plugins/superslides/dist/jquery.superslides.min.js"></script>
		<script type="text/javascript" src="assets/plugins/styleswitcher/styleswitcher.js"></script><!-- STYLESWITCHER - REMOVE ON PRODUCTION/DEVELOPMENT -->
		<script type="text/javascript" src="assets/plugins/mediaelement/build/mediaelement-and-player.min.js"></script>

		<!-- REVOLUTION SLIDER -->
		<script type="text/javascript" src="assets/plugins/revolution-slider/js/jquery.themepunch.tools.min.js"></script>
		<script type="text/javascript" src="assets/plugins/revolution-slider/js/jquery.themepunch.revolution.min.js"></script>
		<script type="text/javascript" src="assets/js/slider_revolution.js"></script>


		<script type="text/javascript" src="assets/js/scripts.js"></script>

		<!-- ONEPAGE NAVIGATION -->
		<script type="text/javascript" src="assets/plugins/jquery.nav.min.js"></script>
		<script type="text/javascript">
			jQuery('#topMain').onePageNav({
				currentClass: 'active',
				changeHash: false,
				scrollSpeed: 750,
				scrollThreshold: 0.5,
				filter: ':not(.external)',
				easing: 'easeInOutExpo'
			});
		</script>
	</body>
</html>