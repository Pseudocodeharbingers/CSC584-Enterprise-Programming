<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="boutique.model.ProductBean,boutique.model.EmployeeBean, boutique.dao.ProductDAO, java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Add Employee</title>
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

		<!-- REVOLUTION SLIDER -->
		<link href="assets/plugins/revolution-slider/css/settings.css" rel="stylesheet" type="text/css" />

		<!-- THEME CSS -->
		<link href="assets/css/essentials.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/layout-responsive.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/color_scheme/orange.css" rel="stylesheet" type="text/css" />

		<!-- Morenizr -->
		<script type="text/javascript" src="assets/plugins/modernizr.min.js"></script>
	</head>
	<body background="assets/images/coverpage4.jpg">
	<% EmployeeBean currentUser = (EmployeeBean) session.getAttribute("currentSessionUser");%>
	
		<!-- TOP NAV -->
		<header id="topNav">
			<div class="container">

				<!-- Mobile Menu Button -->
				<button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
					<i class="fa fa-bars"></i>
				</button>

				<!-- Logo text or image -->
				<a class="logo" href="indexEmployee.jsp">
						<i class="fa fa-leaf"> Zarisa Boutique</i>
				</a>

					<!-- Top Nav -->
				<div class="navbar-collapse nav-main-collapse collapse pull-right">
					<nav class="nav-main mega-menu">
						<ul class="nav nav-pills nav-main scroll-menu" id="topMain">
						<li class="dropdown">
						<a class="dropdown-toggle" href="#">
									Product <i class="fa fa-angle-down"></i>
						</a>
								<ul class="dropdown-menu">
								    <li><a href="addProduct.jsp">Add Product</a></li>
									<li><a href="ListProduct.jsp">List Product</a></li>
									<li><a href="ListProduct.jsp">Update Product</a></li>
									<li><a href="ListProduct.jsp">Delete Product</a></li>
								</ul>
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

			<div class="padding60">

				<!-- PAGE TITLE -->

				<section class="container">

					<div class="row">
		<!-- LOGIN -->
						<div class="col-md-4"></div>
						<div class="col-md-4">

							<h2 align="center"><b>Add Product</b></h2>

							<form class="white-row" method="post" action="ProductController">
								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Product Name</label>
											<input type="text" name="prodName" class="form-control" required="required">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Product Description</label>
											<input type="text"name="prodDesc" class="form-control" required="required">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Product price</label>
											<input type="text" name="prodPrice" class="form-control" required="required">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Product Quantity</label>
											<input type="number" name="prodQty" class="form-control" required="required">
										</div>
									</div>
								</div>
								<div class="row">
									<div align="center">
										<input type="submit" name="submit" value="Submit" class="btn btn-primary">
									
										<input type="reset" name="reset" value="Reset" class="btn btn-primary">
									</div>
								</div>
								<div class="col-md-4"></div>
							</form>
						</div>
						<!-- /LOGIN -->
					</div>
					<!-- /PASSWORD -->

					</div>

				</section>
				 <b><pre>                                                                                                                                                                               Hello session <%= currentUser.getEmpEmail() %></pre></b>                        
			</div>
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