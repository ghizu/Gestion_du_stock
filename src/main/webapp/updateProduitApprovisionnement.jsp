<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Update Produit Approvisionnement</title>
<sx:head />
<!-- Fontfaces CSS-->
<link href="css/font-face.css" rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">


<!-- Main CSS-->
<link href="css/theme.css" rel="stylesheet" media="all">
<link href="css/themes.css" rel="stylesheet" media="all">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>






<body>


	<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="#"> <img src="resources/img/logo.png" alt="Cool Admin" />
				</a>
			</div>
			<div class="myDiv">
			<div class="menu-sidebar__content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar__list">
						<li class="active"><a class="js-arrow" href="acceuil"> <i
								class="fas fa-tachometer-alt"></i>Acceuil
						</a></li>
						<li><a href="produitStock_a_une_date"> <i
								class="fas fa-chart-bar"></i>Stock à une date
						</a></li>
						<li ><a href="ProduitApprovisionnement"> <i
								class="fas fa-table"></i>Produits Approvisionnement
						</a></li>
						<li ><a href="index"> <i class="far fa-check-square"></i>Produit Stock
						</a></li>


					</ul>
				</nav>
			</div>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->
		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section_content section_content--p30">
					<div class="container-fluid">
						<div class="header-wrap">
							<form class="form-header" action="" method="POST">
								<input class="au-input au-input--xl" type="text" name="search"
									placeholder="Recherche..." />
								<button class="au-btn--submit" type="submit">
									<i class="zmdi zmdi-search"></i>
								</button>
							</form>
							<div class="header-button">
                                
								<a href="logout"><img src="https://img.icons8.com/color/48/000000/shutdown--v1.png"/></a>
							</div>
						</div>
					</div>
				</div>
			</header>
			<!-- HEADER DESKTOP-->
</div>

							<!-- Modifier Produit Approvisionnement-->
	
	
	<div class="page-wrapper">
		<!-- HEADER MOBILE-->
		<header class="header-mobile d-block d-lg-none">
			<div class="header-mobile__bar">
				<div class="container-fluid">
					<div class="header-mobile-inner">
						<a class="logo" href="index.html"> <img
							src="images/icon/test1.png" alt="CoolAdmin" />
						</a>
						<button class="hamburger hamburger--slider" type="button">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>
			<nav class="navbar-mobile">
				<div class="container-fluid">
					<ul class="navbar-mobile__list list-unstyled">
						<li class="has-sub"><a class="js-arrow" href="index.html">
								<i class="fas fa-tachometer-alt"></i>Acceuil
						</a></li>
						<li><a href="chart.html"> <i class="fas fa-chart-bar"></i>Stock
								à une date
						</a></li>
						<li><a href="table.html"> <i class="fas fa-table"></i>Produits Approvisionnement
						</a></li>
						<li><a href="form.html"> <i class="far fa-check-square"></i>Produit Stock
						</a></li>


					</ul>
				</div>
			</nav>
		</header>
		<!-- END HEADER MOBILE-->

		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="#"> <img src="resources/img/logo.png" alt="Cool Admin" />
				</a>
			</div>
			
			<div class="myDiv">
				<div class="menu-sidebar__content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar__list">
						<li class="has-sub"><a class="js-arrow" href="acceuil"> <i
								class="fas fa-tachometer-alt"></i>Acceuil
						</a></li>
						<li><a href="produitStock_a_une_date"> <i
								class="fas fa-chart-bar"></i>Stock à une date
						</a></li>
						<li class="active"><a href="ProduitApprovisionnement"> <i
								class="fas fa-table"></i>Produits Approvisionnement
						</a></li>
						<li><a href="index"> <i class="far fa-check-square"></i>Produit Stock
						</a></li>


					</ul>
				</nav>
			</div>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->
		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap">
							<form class="form-header" action="" method="POST">
								<input class="au-input au-input--xl" type="text" name="search"
									placeholder="Recherche..." />
								<button class="au-btn--submit" type="submit">
									<i class="zmdi zmdi-search"></i>
								</button>
							</form>
							<div class="header-button">

								<a href="logout"><img src="https://img.icons8.com/color/48/000000/shutdown--v1.png"/></a>
							</div>
						</div>
					</div>
				</div>
			</header>
			<!-- HEADER DESKTOP-->
	
				<div class="main-content" >
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						
							<div class="col-sm-6">
								<h3 class="title-3 m-b-30">
									<i class="zmdi "></i>modifier Produit Approvisionnement
								</h3>

							</div>

							<div class="card-body card-block">

								<s:form action="editProduitApprovisionnement">

									<div class="row form-group">
										<div class="col-12 col-md-9">
	
											<s:textfield name="ProduitApprovisionnement.codeProduitAppr" label="Code Produit Approvisionnement	"
											 readonly="true"  cssClass="form-control mb-4"/>

										</div>
										<div class="col-12 col-md-9">
										
												<p>Nom Produit :</p>											
												<s:select label="Nom Produit	" list="Produit_List" listKey="codePdt"
												listValue="nomPdt" name="ProduitApprovisionnement.codePdt"
												cssClass="dropdown-header" theme="simple" />
												
										</div>

										<div class="col-12 col-md-9">
											<s:textfield type="number" name="ProduitApprovisionnement.qteCommande"
												label="Quantité Produit Approvisionnement	" cssClass="form-control mb-4" />
												

										</div>
										<div class="col-12 col-md-9">
											
												<sx:datetimepicker type="date" name="ProduitApprovisionnement.datePrevueLivraison" label="Date     	"
												displayFormat="dd-MMM-yyyy"  />
												
												
										</div>
										
										<div class="col-12 col-md-9">
											<s:hidden name="ProduitStock.dateProduitStock" cssClass="hidden" />

										</div>
										
										<div class="col-12 col-md-9">
										<br/>
											<s:submit value="Modifier" cssClass="btn btn-danger"
												 />
												 
										</div>
									</div>
								</s:form>
							</div>
						</div>
						
					</div>
					</div>
					</div>
					</div>
					
					
								<!--END Modifier Produit Approvisionnement-->
	
	
	
	<!-- Jquery JS-->
	<script src="vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="vendor/slick/slick.min.js">
		
	</script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="vendor/animsition/animsition.min.js"></script>
	<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="vendor/circle-progress/circle-progress.min.js"></script>
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="vendor/select2/select2.min.js">
		
	</script>

	<!-- Main JS-->
	<script src="js/main.js"></script>
	
	<!-- Jquery JS-->
	<script src="vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="vendor/slick/slick.min.js">
		
	</script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="vendor/animsition/animsition.min.js"></script>
	<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="vendor/circle-progress/circle-progress.min.js"></script>
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="vendor/select2/select2.min.js">
		
	</script>

	<!-- Main JS-->
	<script src="js/main.js"></script>


  
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>
</html>