
<!-- this navBarComponent is the interface in index.php -->
<div id="navBarComponent">
		<nav class="navBar">
					<a href="index.php" class="logo">
						<img src="assets/images/icons/logo.png">
					</a>

					<div class="group">
						<div class="navItem">
							<a href="search.php" class="navItemLink">Search
								<img src="assets/images/icons/search.png" class="icon" alt="Search">
							</a>
						</div>
					</div>

					<div class="group">
						<div class="navItem">
							<!-- <a href="browse.php" class="navItemLink">Browse</a> -->
							<button class="navItemLinkBtn" id="browse" onclick="window.location.href = 'browse.php';">
								Browse
							</button>
						</div>
						<div class="navItem">
							<button class="navItemLinkBtn" onclick="window.location.href = 'yourMusic.php';">
								Your Music
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
									User Defined
							</button>
						</div>
					</div>

		</nav>
</div>