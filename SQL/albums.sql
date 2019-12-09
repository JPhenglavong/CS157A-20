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
(1, 'Friday Night Lights', 1, 1, 'resource/images/artwork/FridayNightLightsFront.jpg'),
(2, 'Overly Dedicated', 2, 1, 'resource/images/artwork/OverlyDedicatedFront.jpg'),
(3, 'Feed Tha Streets', 3, 1, 'resource/images/artwork/FeedThaStreetsFront.jpg'),
(4, 'Drug Funnie', 4, 1, 'resource/images/artwork/DrugFunnieFront.jpg'),
(5, 'Michael Wu Number Ones', 5, 2, 'resource/images/artwork/MichaelWuNumberOnesFront.jpg'),
(6, 'The River', 6, 9, 'resource/images/artwork/The River.jpeg'),
(7, 'Chinese Melodies', 7, 7, 'resource/images/artwork/Chinese Melodies.jpeg'),
(8, 'Confessions', 8, 15, 'resource/images/artwork/Confessions.jpeg'),
(9, 'Don Sonrabiab Classics', 9, 12, 'resource/images/artwork/Don Sonrabiab Classics.jpeg'),
(10, 'G-Worthy', 10, 14, 'resource/images/artwork/G-Worthy.jpeg'),
(11, 'Lets Talk About Love', 11, 5, 'resource/images/artwork/Lets Talk About Love.jpeg'),
(12, 'Loso Greatest Hits', 12, 13, 'resource/images/artwork/Loso Greatest Hits.jpeg'),
(13, 'Never Too Much', 13, 10, 'resource/images/artwork/Never Too Much.jpeg'),
(14, 'On The Rocks', 14, 3, 'resource/images/artwork/On The Rocks.jpeg'),
(15, 'Solar', 15, 8, 'resource/images/artwork/Solar.jpeg'),
(16, 'Vietnamese Karaoke Classics', 16, 11, 'resource/images/artwork/Vietnamese Karaoke Classics.jpeg'),
(17, 'XX', 17, 4, 'resource/images/artwork/XX.jpeg'),
(18, 'Yoon Jong Shin Ballad', 18, 6, 'resource/images/artwork/Yoon Jong Shin Ballad.jpeg');
