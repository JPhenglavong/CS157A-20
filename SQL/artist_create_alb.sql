create table if not exists artist_create_alb
(
artistID int(11) NOT NULL,
albumID int(11) NOT NULL
) 
engine= innoDB;

SELECT * FROM team20.artist_create_alb;

insert into artist_create_alb (artistID,albumID) 
values
(15,2),
(2,9),
(4,7),
(2,8),
(4,3),
(1,1),
(1,4),
(6,5),
(8,10),
(9,6),
(10,11),
(11,12),
(13,14),
(14,13),
(10,15)
;
