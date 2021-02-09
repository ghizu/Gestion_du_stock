<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Produit Approvisionnement</title>

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
<script>
	$(document).ready(
			function() {
				$("#myInput").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#datatable tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});
</script>
<script>
	var thIndex = 0, curThIndex = null;

	$(function() {
		$('table thead tr th').click(
				function() {
					thIndex = $(this).index();
					if (thIndex != curThIndex) {
						curThIndex = thIndex;
						sorting = [];
						tbodyHtml = null;
						$('table tbody tr').each(
								function() {
									sorting.push($(this).children('td').eq(
											curThIndex).html()
											+ ', ' + $(this).index());
								});

						sorting = sorting.sort();
						sortIt();
					}
				});
	})


</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
	type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
</head>

<body class="animsition">
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg"  role="document">
			<s:form action="save_produitStock" styleClass="form-horizontal"
				theme="simple">

				<div class="modal-content">
					<div class="modal-header">
						<h6 class="title-3 m-b-20" id="exampleModalLabel">Ajouter un
							Produit dans Stock</h6>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<div class="card-body card-block">



							<div class="row form-group">
								<div class="col-sm-3">Date Produit Stock</div>
								<div class="col-sm-9">
									<%-- 						<sx:datetimepicker name="ProduitApprovisionnement.datePrevueLivraison" label="Date" --%>
									<%-- 							displayFormat="dd-MMM-yyyy" cssClass="form-control-label" /> --%>
									<input id="datepicker" name="current_produitStock_date"
										class="form-control-label" />

									<script>
										$('#datepicker').datepicker({
											uiLibrary : 'bootstrap4'
										});
									</script>
								</div>
							</div>

							<div class="row form-group ">
								<div class="table table-borderless table-data3">
									<table id="datatableG"
										class="table table-striped table-bordered ">
										<thead>
											<tr>
												<th>Code de Produit</th>
												<th>Nom Produit</th>
												<th>Quantité</th>
												<th>Description</th>
											</tr>
										</thead>
										<tbody id="datatable">
											<s:iterator value="produitStockGenerale" status="stat"
												var="produitStock">
												<tr style="display:none;">
													<td></td>
													<td></td>
													<td><s:textfield
															name="produitStockGenerale[%{#stat.count-1}].qtePdt" /></td>
													<td><s:textfield
															name="produitStockGenerale[%{#stat.count-1}].descPdt" /></td>
												</tr>
											</s:iterator>
											<s:iterator value="produitStock_shown" 
												var="produitStock">
												<tr>
													<td><s:property value="codePdt" /></td>
													<td><s:property value="nomPdt" /></td>
													
													<td><s:property value="qtePdt" /></td>
													<td><s:property value="descPdt" /></td>
												</tr>
											</s:iterator>
										</tbody>

									</table>
								</div>
							</div>


						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">fermer</button>
						<s:submit value="Ajouter" cssClass="btn btn-danger"
							theme="simple" />
					</div>
				</div>
			</s:form>
		</div>
	</div>
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
						<li ><a href="ProduitApprovisionnement"> <i
								class="fas fa-table"></i>Produits Approvisionnement
						</a></li>
						<li class="active"><a href="index"> <i class="far fa-check-square"></i>Produit Stock
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

			<!-- MAIN CONTENT-->
			<div class="main-content">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<!-- 							<a href="acceuil">Acceuil</a> <a href="produitStock_a_une_date">Stock
								a une date</a> <a href="ProduitApprovisionnement">Produit Approvisionnement</a> <a href="index">Produit Stock</a> -->
							<div class="col-sm-6">
								<h3 class="title-3 m-b-30">
									<i class="zmdi "></i>Produit Stock
								</h3>

							</div>


							<div class="col-sm-6">
								<div class="input-group mb-3 btn-group">
									<input id="myInput" type="text" class="form-control"
										placeholder="Recherche .." aria-label="Recherche"
										aria-describedby="basic-addon2">
									<div class="input-group-append">
										<button class="btn btn-danger" data-toggle="dropdown"
											type="button">+</button>
										<div class="dropdown-menu dropdown-menu-right">
											<button class="dropdown-item" type="button"
												data-toggle="modal" data-target="#exampleModal">Faire
												un Produit Stock</button>
										</div>

									</div>
								</div>
							</div>
							<div class="table table-borderless table-data3 ">
								<table id="datatableG"
									class="table table-striped table-bordered ">
									<thead>
										<tr>
											<th>Date Produit Stock</th>
											<th></th>
										</tr>
									</thead>
									<tbody id="datatable">
										<s:iterator value="dates_string_list" var="dateString">
											<tr>
												<td><s:property value="dateString" /></td>
												<td><a
													href="produitStock_information?current_produitStock_date_string=<s:property value="dateString" />"><button class="btnI danger"><p style="color:#FFFFFF">Information</p></button></a>
													<a
													href="delete_produitsStock?current_produitStock_date_string=<s:property value="dateString" />"><button class="btnD danger"><p style="color:#FFFFFF">Supprimer</p></button></a></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
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

</body>
</html>