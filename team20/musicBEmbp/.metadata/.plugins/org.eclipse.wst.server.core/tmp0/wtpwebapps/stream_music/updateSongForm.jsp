<!DOCTYPE html>
<html>

<head>
	<title>Update Song</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/mainView.css">
    <link type="text/css" rel="stylesheet" href="css/addUser.css">
</head>

<body>
    <div id="background">
            <div id="wrapper">
                <div id="header">
                    <h2>Team20 Stream Music Song Directory</h2>
                </div>
            </div>
            
            <div id="container">
                <h3>Update Song</h3>
                
                <form action="songControllerServlet" method="GET">
                
                    <input type="hidden" name="command" value="UPDATE" />

                    <input type="hidden" name="songId" value="${THE_SONG.id}" />
                    
                    <table>
                        <tbody>
                            <tr>
                                <td><label>Title:</label></td>
                                <td><input type="text" name="title" 
                                        value="${THE_SONG.title}" /></td>
                            </tr>
                            <tr>
                                <td><label>Artist:</label></td>
                                <td><input type="text" name="artist" 
                                        value="${THE_SONG.artist}" /></td>
                            </tr>

                            <tr>
                                <td><label>album:</label></td>
                                <td><input type="text" name="album" 
                                        value="${THE_SONG.album}" /></td>
                            </tr>

                            <tr>
                                <td><label>genre:</label></td>
                                <td><input type="text" name="genre" 
                                        value="${THE_SONG.genre}" /></td>
                            </tr>

                            <tr>
                                <td><label>albumOrder:</label></td>
                                <td><input type="text" name="albumOrder" 
                                        value="${THE_SONG.albumOrder}" /></td>
                            </tr>
                            
                            <tr>
                                <td><label></label></td>
                                <td><input type="submit" value="Save" class="save" /></td>
                            </tr>
                            
                        </tbody>
                    </table>
                </form>
                
                <div style="clear: both;"></div>
                
                <p>
                    <a href="songControllerServlet">Back to Song List</a>
                </p>
            </div>
    </div>
</body>

</html>