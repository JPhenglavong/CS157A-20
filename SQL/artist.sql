-- Create albums table
CREATE TABLE IF NOT EXISTS `albums` (
`id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `artist` int(11) NOT NULL,
  `genre` int(11) NOT NULL,
  `artworkPath` varchar(500) NOT NULL
) ENGINE=InnoDB;
-- Insert data into albums
INSERT INTO `albums` (`id`, `title`, `artist`, `genre`, `artworkPath`) VALUES
(1, 'Overly Dedicated', 5, 4, 'resource/images/artwork/OverlyDedicatedFront.jpg'),
(2, 'Friday Night Lights', 4, 10, 'resource/images/artwork/FridayNightLightsFront.jpg'),
(3, 'Tom Zheng', 3, 1, 'resource/images/artwork/alb.png'),
(4, 'IOS', 2, 9, 'resource/images/artwork/ios.png'),
(5, 'MySQL', 1, 3, 'resource/images/artwork/mysql.png'),
(6, 'JDBC', 6, 6, 'resource/images/artwork/java.png'),
(7, 'Michael Wu Number Ones', 7, 7, 'resource/images/artwork/MichaelWuNumberOnesFront.jpg'),
(8, 'Tesla', 8, 11, 'resource/images/artwork/tesla.png'),
(9, 'VUE.JS', 9, 8, 'resource/images/artwork/vuejs.png'),
(10, 'Feed Tha Streets', 10, 12, 'resource/images/artwork/FeedThaStreetsFront.jpg'),
(11, 'android', 11, 13, 'resource/images/artwork/android.png'),
(12, 'Tommorrow', 12, 14, 'resource/images/artwork/album.png'),
(13, 'Drug Funnie', 13, 15, 'resource/images/artwork/DrugFunnieFront.jpg'),
(14, 'Swift', 14, 2, 'resource/images/artwork/swift.png'),
(15, 'Python', 15, 5, 'resource/images/artwork/python.png');
