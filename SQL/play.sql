CREATE TABLE IF NOT EXISTS play (
    userID int(11) NOT NULL,
     songID int(11) NOT NULL
) ENGINE=InnoDB;
  alter table play add foreign key (userID) references users(id);
  alter table play add foreign key (songID) references songs(id);

select * from play;

insert into play
values
(3,10),
(1,2),
(1,8),
(1,3),
(2,4),
(2,6),
(2,9),
(8,11),
(5,13),
(6,15)

;