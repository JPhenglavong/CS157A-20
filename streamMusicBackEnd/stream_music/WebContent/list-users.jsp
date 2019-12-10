<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/mainView.css">
	<title>Team20 BackEnd Users Tracker APP</title>
</head>
	
<body>
	<div id="background">
		
		<div id="mainComponent">
					<div id="topComponent">
						<div id="navBarComponent">
								<nav class="navBar">
											<a href="http://localhost:8080/stream_music/" class="logo">
												<img src="img/head.png">
											</a>
						
											<div class="group">
												<div class="navItem">
													<a href="http://localhost:8080/stream_music/" class="navItemLink">Stream Music
														<img src="img/music.png" class="icon" alt="Search">
													</a>
												</div>
											</div>
						
											<div class="group">
												<div class="navItem">
													<button class="navItemLinkBtn" id="browse" onclick="window.location.href = 'http://localhost:8080/stream_music/';">
														User Directory
													</button>
												</div>
												<div class="navItem">
													<button class="navItemLinkBtn" onclick="window.location.href = 'http://localhost:8080/stream_music/songControllerServlet';">
														Songs Directory
													</button>
												</div>
												<div class="navItem">
													<!-- <a href="http://localhost:8080" class="navItemLink">Team 20</a> -->
													<button class="navItemLinkBtn" onclick="window.location.href = 'https://novemberfall.github.io/musicChat/';">
														Chat To Team20
													</button>
												</div>
												<div class="navItem">
													<button class="navItemLinkBtn" onclick="window.location.href = 'http://localhost:8080/stream_music/';">
														User DataStructure
													</button>
												</div>
																
												<!-- Add hidden form field to handle update, Note: we must use value="ADD" -->
												<div class="navItem">
													<button class="navItemLinkBtn" name="command" value="LIST_HEAPSORT_SONG_HOMEPAGE"
													onclick="window.location.href = 'http://localhost:8080/stream_music/';">
														Song DataStructure
													</button>
												</div>
											</div>
								</nav>
						</div>
					</div>


					<div id="mainViewComponent">
						<div id="mainContent">
											
								
								<div id="container">
										<h2>Team20 Stream Music User Directory</h2>
								</div>
							
								<div id="container">
								
									<div id="content">
										<!-- put new button: Add Student -->
										<input type="button" value="Add User" 
										onclick="window.location.href='add-user-form.jsp'; return false;"
										class="btn btn-primary btn-sm mb-3"
								 		/>
											
										<table class="table table-bordered table-striped">
											<thead class="thead-transparent">
												<tr>
													<th>ID</th>
													<th>User Name</th>
													<th>First Name</th>
													<th>Last Name</th>
													<th>Email</th>
													<th>photo</th>
													<th>Action</th>
												</tr>
											</thead>
											
											<c:forEach var="tempUser" items="${USER_LIST}">

												<!-- set up a link for each customer -->
												<c:url var="tempLink" value="userControllerServlet">
													<c:param name="command" value="LOAD"/>
													<c:param name="userId" value="${tempUser.id}"/>
												 </c:url>
												 
												<!-- set up a link to delete a customer -->
												<c:url var="deleteLink" value="userControllerServlet">
													<c:param name="command" value="DELETE"/>
													<c:param name="userId" value="${tempUser.id}"/>
												</c:url>
												<!-- set up a link to lambda Sort a user -->
												<c:url var="LambdaSortUsernameLink" value="userControllerServlet">
													<c:param name="command" value="LAMBDA_EXPRESSION_SORT_USERNAME"/>
													<c:param name="userId" value="${tempUser.id}"/>
												</c:url>	
												<!-- set up a link to lambda Sort a user -->
												<c:url var="sqlQuerySortEmailLink" value="userControllerServlet">
													<c:param name="command" value="SQL_QUERY_SORT_EMAIL"/>
													<c:param name="userId" value="${tempUser.id}"/>
												</c:url>	

												<c:url var="HeapSortIDLink" value="userControllerServlet">
													<c:param name="command" value="HEAP_SORT_ID"/>
													<c:param name="userId" value="${tempUser.id}"/>
												</c:url>	
												<tr>
													<td> ${tempUser.id} </td>
													<td> ${tempUser.username} </td>
													<td> ${tempUser.firstName} </td>
													<td> ${tempUser.lastName} </td>
													<td> ${tempUser.email} </td>
													<td><img src="img/head.png" width=30></img></td>
													<td>
														<div class="row">
														
															<div class="col-small">
															<!-- Add "update" button/link -->
																				
																<button type="submit" class="btn btn-info btn-sm ml-3 mr-1" 
																onclick=" window.location.href = '${tempLink}'; ">Update
																</button>
			
															</div>

															<div class="col-small">
															<!-- Add "delete" button/link -->
																						
																<button type="submit" class="btn btn-danger btn-sm"
																onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;
																 window.location.href = '${deleteLink}'; ">Delete
																</button>
					
															</div>
															
															<div class="col-small">																	
																<button type="submit" class="btn btn-danger btn-sm"
																onclick=" window.location.href = '${LambdaSortUsernameLink}'; ">lambdaSort
																</button>
															</div>	
															
															<div class="col-small">																		
																<button type="submit" class="btn btn-danger btn-sm"
																onclick=" window.location.href = '${sqlQuerySortEmailLink}'; ">sqlSortMail
																</button>
															</div>	

															<div class="col-small">																		
																<button type="submit" class="btn btn-danger btn-sm"
																onclick=" window.location.href = '${HeapSortIDLink}'; ">heapSortID
																</button>
															</div>	
														</div>	
													</td>
												</tr>
											</c:forEach>
											
											
										</table>
									
									</div>
								
								</div>
								
							
						</div>
					</div>
					
					
					
		</div>

	
	

	</div>
	


</body>
</html>









		