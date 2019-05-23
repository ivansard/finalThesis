<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
	<head>
		<title>Free Snow Bootstrap Website Template | Checkout :: w3layouts</title>
		<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
		<meta
			name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1"
		/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link
			href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
			rel="stylesheet"
			type="text/css"
		/>
		<script type="application/x-javascript">
			addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
		</script>
		<script src="resources/js/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.dropdown img.flag').addClass('flagvisibility');

				$('.dropdown dt a').click(function() {
					$('.dropdown dd ul').toggle();
				});

				$('.dropdown dd ul li a').click(function() {
					var text = $(this).html();
					$('.dropdown dt a span').html(text);
					$('.dropdown dd ul').hide();
					$('#result').html('Selected value is: ' + getSelectedValue('sample'));
				});

				function getSelectedValue(id) {
					return $('#' + id)
						.find('dt a span.value')
						.html();
				}

				$(document).bind('click', function(e) {
					var $clicked = $(e.target);
					if (!$clicked.parents().hasClass('dropdown'))
						$('.dropdown dd ul').hide();
				});

				$('#flagSwitcher').click(function() {
					$('.dropdown img.flag').toggleClass('flagvisibility');
				});
			});
		</script>
	</head>
	<body>
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="header-left">
							<div class="logo">
                                <a href="/"><img src="/resources/images/logo.png" alt=""/></a>
							</div>
                            <div class="menu">
                                  <a class="toggleMenu" href="#"><img src="/resources/images/nav.png" alt="" /></a>
                                    <ul class="nav" id="nav">
                                        <li><a href="/shop">Shop</a></li>
                                        <li><a href="/">Company</a></li>

                                        <c:choose>
                                            <c:when test="${sessionScope.loggedUser == null}">
                                                <li><a href="/login">Login</a></li>
                                                <li><a href="/register">Register</a></li>
                                            </c:when>

                                            <c:otherwise>
                                                <li><a href="/profile">Profile</a></li>
                                                <li><a href="/users/logout">Log Out</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                        <div class="clear"></div>
                                    </ul>
                                    <script type="text/javascript" src="/resources/js/responsive-nav.js"></script>
                            </div>
							<div class="clear"></div>
						</div>
						<div class="header_right">
							<!-- start search-->
							<div class="search-box">
								<div id="sb-search" class="sb-search">
									<form>
										<input
											class="sb-search-input"
											placeholder="Enter your search term..."
											type="search"
											name="search"
											id="search"
										/>
										<input class="sb-search-submit" type="submit" value="" />
										<span class="sb-icon-search"> </span>
									</form>
								</div>
							</div>
							<!----search-scripts---->
							<script src="resources/js/classie.js"></script>
							<script src="resources/js/uisearch.js"></script>
							<script>
								new UISearch(document.getElementById('sb-search'));
							</script>
							<ul class="icon1 sub-icon1 profile_img">
								<li>
									<a class="active-icon c1" href="#"> </a>
									<ul class="sub-icon1 list">
										<div class="product_control_buttons">
											<a href="#"
												><img src="resources/images/edit.png" alt=""
											/></a>
											<a href="#"
												><img src="resources/images/close_edit.png" alt=""
											/></a>
										</div>
										<div class="clear"></div>
										<li class="list_img">
											<img src="resources/images/1.jpg" alt="" />
										</li>
										<li class="list_desc">
											<h4><a href="#">velit esse molestie</a></h4>
											<span class="actual">1 x $12.00</span>
										</li>
										<div class="login_buttons">
											<div class="check_button">
												<a href="checkout.html">Check out</a>
											</div>
											<div class="login_button">
												<a href="login.html">Login</a>
											</div>
											<div class="clear"></div>
										</div>
										<div class="clear"></div>
									</ul>
								</li>
							</ul>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main">
			<div class="shop_top">
				<div class="container">
					<h1 class="title">Your Profile Page</h1>
					<hr />
					<h3 class="title">Manage payment options</h3>
					<c:choose>
                        <c:when test="${sessionScope.account.paymentDetails == null}">
                            <a href="/paymentDetails" class="btn btn-dark">Add payment details</a>
                        </c:when>

                        <c:otherwise>
                             <a href="/paymentDetails" class="btn btn-dark">Update payment details</a>
                        </c:otherwise>
                    </c:choose>
					<h3 class="title">Manage your orders</h3>
                    <a href="/orders" class="btn btn-dark">View</a>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Products</h4>
							<li><a href="#">Mens</a></li>
							<li><a href="#">Womens</a></li>
							<li><a href="#">Youth</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>About</h4>
							<li><a href="#">Careers and internships</a></li>
							<li><a href="#">Sponserships</a></li>
							<li><a href="#">team</a></li>
							<li><a href="#">Catalog Request/Download</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Customer Support</h4>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Shipping and Order Tracking</a></li>
							<li><a href="#">Easy Returns</a></li>
							<li><a href="#">Warranty</a></li>
							<li><a href="#">Replacement Binding Parts</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<ul class="footer_box">
							<h4>Newsletter</h4>
							<div class="footer_search">
								<form>
									<input
										type="text"
										value="Enter your email"
										onfocus="this.value = '';"
										onblur="if (this.value == '') {this.value = 'Enter your email';}"
									/>
									<input type="submit" value="Go" />
								</form>
							</div>
							<ul class="social">
								<li class="facebook">
									<a href="#"><span> </span></a>
								</li>
								<li class="twitter">
									<a href="#"><span> </span></a>
								</li>
								<li class="instagram">
									<a href="#"><span> </span></a>
								</li>
								<li class="pinterest">
									<a href="#"><span> </span></a>
								</li>
								<li class="youtube">
									<a href="#"><span> </span></a>
								</li>
							</ul>
						</ul>
					</div>
				</div>
				<div class="row footer_bottom">
					<div class="copy">
					</div>
					<dl id="sample" class="dropdown">
						<dt>
							<a href="#"><span>Change Region</span></a>
						</dt>
						<dd>
							<ul>
								<li>
									<a href="#"
										>Australia<img
											class="flag"
											src="resources/images/as.png"
											alt=""
										/><span class="value">AS</span></a
									>
								</li>
								<li>
									<a href="#"
										>Sri Lanka<img
											class="flag"
											src="resources/images/srl.png"
											alt=""
										/><span class="value">SL</span></a
									>
								</li>
								<li>
									<a href="#"
										>Newziland<img
											class="flag"
											src="resources/images/nz.png"
											alt=""
										/><span class="value">NZ</span></a
									>
								</li>
								<li>
									<a href="#"
										>Pakistan<img
											class="flag"
											src="resources/images/pk.png"
											alt=""
										/><span class="value">Pk</span></a
									>
								</li>
								<li>
									<a href="#"
										>United Kingdom<img
											class="flag"
											src="resources/images/uk.png"
											alt=""
										/><span class="value">UK</span></a
									>
								</li>
								<li>
									<a href="#"
										>United States<img
											class="flag"
											src="resources/images/us.png"
											alt=""
										/><span class="value">US</span></a
									>
								</li>
							</ul>
						</dd>
					</dl>
				</div>
			</div>
		</div>
	</body>
</html>
