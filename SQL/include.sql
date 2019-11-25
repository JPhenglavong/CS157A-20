CREATE TABLE IF NOT EXISTS include (
    albumID int(11) NOT NULL,
     songID int(11) NOT NULL
) ENGINE=InnoDB;

select * from include;

insert into include(albumID,songID) 
values
(1, 3),
(1,2),
(10,4),
(11,5),
(12,1),
(8,6),
(8,7),
(9,8),
(14,9),
(14,11),
(14,12),
(13,10)
;