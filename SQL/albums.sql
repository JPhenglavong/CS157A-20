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
(1, 'Macbook Pro', 2, 4, 'assets/images/artwork/mbp.png'),
(2, 'De Anza College', 5, 10, 'assets/images/artwork/react.png'),
(3, 'Tom Zheng', 3, 1, 'assets/images/artwork/alb.jpg'),
(4, 'IOS', 2, 9, 'assets/images/artwork/ios.png'),
(5, 'MySQL', 1, 3, 'assets/images/artwork/mysql.png'),
(6, 'JDBC', 3, 6, 'assets/images/artwork/java.png'),
(7, 'React.JS', 4, 7, 'assets/images/artwork/react.png'),
(8, 'Tesla', 5, 9, 'assets/images/artwork/tesla.png'),
(9, 'VUE.JS', 1, 8, 'assets/images/artwork/vuejs.png'),
(10, 'Angular.JS', 1, 3, 'assets/images/artwork/angular.png'),
(11, 'android', 4, 5, 'assets/images/artwork/android.png'),
(12, 'Tommorrow', 4, 3, 'assets/images/artwork/album.png'),
(13, 'VScode', 1, 9, 'assets/images/artwork/vs.png'),
(14, 'Swift', 2, 8, 'assets/images/artwork/swift.png'),
(15, 'Python', 3, 6, 'assets/images/artwork/python.png');