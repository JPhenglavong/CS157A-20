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
	<title>Team20 BackEnd Music Tracker APP</title>
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
													<a href="" class="navItemLink">Search
														<img src="img/search.png" class="icon" alt="Search">
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
													<button class="navItemLinkBtn" onclick="window.location.href = 'http://localhost:8080';">
														Team 20
													</button>
												</div>
												<div class="navItem">
													<!-- <a href="http://localhost:3000" class="navItemLink">User Defined</a> -->
													<button class="navItemLinkBtn" onclick="window.location.href = 'http://localhost:3000';">
                                                        Engineer Defined
													</button>
												</div>
											</div>
								</nav>
						</div>
					</div>


					<div id="mainViewComponent">
						<div id="mainContent">
											
								
								<div id="container">
										<h2>Team20 Stream Music Songs Directory</h2>
								</div>
							
								<div id="container">
								
									<div id="content">
										<!-- put new button: Add Student -->
										<input type="button" value="Add Song" 
										onclick="window.location.href='addSongForm.jsp'; return false;"
										class="btn btn-primary btn-sm mb-3"
								 		/>
											
										<table class="table table-bordered table-striped">
											<thead class="thead-transparent">
												<tr>
													<th>ID</th>
													<th>Title</th>
													<th>Artist</th>
													<th>album</th>
													<th>genre</th>
                                                    <th>duration</th>
                                                    <th>MP3 Files</th>
                                                    <th>abOrder</th>
													<th>Plays</th>
													<th>Action</th>
												</tr>
											</thead>
											
											<c:forEach var="tempSong" items="${SONG_LIST}">

												<!-- set up a link for each song -->
												<c:url var="tempLink" value="songControllerServlet">
													<c:param name="command" value="LOAD"/>
													<c:param name="songId" value="${tempSong.id}"/>
												 </c:url>
												 
												<!-- set up a link to delete a song -->
												<c:url var="deleteLink" value="songControllerServlet">
													<c:param name="command" value="DELETE"/>
													<c:param name="songId" value="${tempSong.id}"/>
												</c:url>

												<tr>
													<td> ${tempSong.id} </td>
													<td> ${tempSong.title} </td>
													<td> ${tempSong.artist} </td>
													<td> ${tempSong.album} </td>
													<td> ${tempSong.genre} </td>
                                                    <td> ${tempSong.duration} </td>
                                                    <td><img src="img/music.png" width=30></img></td>
													<td> ${tempSong.albumOrder} </td>
													<td> ${tempSong.plays} </td>
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
																onclick="if (!(confirm('Are you sure you want to delete this song?'))) return false;
																 window.location.href = '${deleteLink}'; ">Delete
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









		