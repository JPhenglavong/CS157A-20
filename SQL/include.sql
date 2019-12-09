CREATE TABLE IF NOT EXISTS include (
    albumID int(11) NOT NULL,
     songID int(11) NOT NULL
) ENGINE=InnoDB;

select * from include;

insert into include(albumID,songID) 
values
(1, 1),
(1,2),
(1,3),
(1,4),
(2,5),
(2,6),
(2,7),
(2,8),
(2,9),
(3,10),
(3,11),
(3,12),
(3,13),
(3,14),
(4,15),(4,16),(4,17),
(6,38),(6,39),(5,18),(5,19),
(7,20),(7,21),(8,22),(8,23),
(9,24),(9,25),(10,26),(10,27),
(11,28),(11,29),(12,30),(12,31),
(13,32),(13,33),(14,34),(14,35),
(15,36),(15,37),(16,40),(16,41),(17,42),(17,43),
(18,44),(18,45)
;

alter table include add foreign key (albumID) references albums(id);
alter table include add foreign key (songID) references songs(id);
