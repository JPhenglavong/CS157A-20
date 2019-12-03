CREATE TABLE IF NOT EXISTS `plays` (
    `UserID` int(11) NOT NULL,
    `PlaylistID` int(11) NOT NULL,
	PRIMARY KEY (UserID,PlaylistID)
) ENGINE=InnoDB;

INSERT INTO `plays` (`UserID`, `PlaylistID`) VALUES
(1, 3),
(2, 2),
(3, 1),
(4, 6),
(5, 7),
(6, 9),
(7, 4),
(8, 5),
(9, 8),
(10, 11),
(11, 10),
(12, 15),
(13, 13),
(14, 12),
(15, 14);