CREATE TABLE IF NOT EXISTS `contains` (
    `SongID` int(11) NOT NULL,
    `PlaylistID` int(11) NOT NULL,
	PRIMARY KEY (SongID,PlaylistID)
) ENGINE=InnoDB;

INSERT INTO `contains` (`SongID`, `PlaylistID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 6),
(5, 5),
(6, 9),
(7, 4),
(8, 7),
(9, 8),
(10, 11),
(11, 10),
(12, 15),
(13, 13),
(14, 12),
(15, 14);