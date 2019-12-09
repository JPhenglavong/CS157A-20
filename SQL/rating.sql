create table if not exists rating(
	userID int(11) NOT NULL,
    songID int(11) NOT NULL
)ENGINE=InnoDB;

SELECT * FROM team20.rating;

insert into rating(userID, songID) values
(1,4), 
(1,7),
(4,6),
(3,9),
(2,1),
(2,7),
(2,6),
(4,3),
(1,10),(1,13),(1,12),(2,14),(3,15),(4,16),(5,17);
