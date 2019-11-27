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
(5, 'Michael Wu Number Ones', 5, 2, 'resource/images/artwork/MichaelWuNumberOnesFront.jpg');
