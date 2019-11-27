CREATE TABLE IF NOT EXISTS `songs` (
    `id` int(11) NOT NULL,
    `title` varchar(250) NOT NULL,
    `artist` int(11) NOT NULL,
    `album` int(11) NOT NULL,
    `genre` int(11) NOT NULL,
    `duration` varchar(8) NOT NULL,
    `path` varchar(500) NOT NULL,
    `albumOrder` int(11) NOT NULL,
    `plays` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;



INSERT INTO `songs` (`id`, `title`, `artist`, `album`, `genre`, `duration`, `path`, `albumOrder`, `plays`) VALUES
(1, '2Face', 1, 1, 1, '4:46', 'resource/music/Friday Night Lights/2Face.mp3', 1, 0),
(2, 'Back To The Topic Freestyle', 1, 1, 1, '3:00', 'resource/music/Friday Night Lights/Back To The Topic Freestyle.mp3', 2, 0),
(3, 'Before Im Gone', 1, 1, 1, '4:24', 'resource/music/Friday Night Lights/Before Im Gone.mp3', 3, 0),
(4, 'Best Friend', 1, 1, 1, '3:25', 'resource/music/Friday Night Lights/Best Friend.mp3', 4, 0),

(5, 'Alien Girl', 2, 2, 1, '4:00', 'resource/music/Overly Dedicated/Alien Girl.mp3', 1, 0),
(6, 'Growing Apart', 2, 2, 1, '4:23', 'resource/music/Overly Dedicated/Growing Apart.mp3', 2, 0),
(7, 'Ignorance Is Bliss', 2, 2, 1, '3:31', 'resource/music/Overly Dedicated/Ignorance Is Bliss.mp3', 3, 0),
(8, 'PP 15', 2, 2, 1, '6:02', 'resource/music/Overly Dedicated/PP 15.mp3', 4, 0),
(9, 'The Heart Pt 2', 2, 2, 1, '4:54', 'resource/music/Overly Dedicated/The Heart Pt 2.mp3', 5, 0),

(10, 'Chase Tha Bag', 3, 3, 1, '3:33', 'resource/music/Feed Tha Streets/Chase Tha Bag.mp3', 1, 0),
(11, 'Fucc It Up', 3, 3, 1, '3:23', 'resource/music/Feed Tha Streets/Fucc It Up.mp3', 2, 0),
(12, 'Plottin', 3, 3, 1, '2:53', 'resource/music/Feed Tha Streets/Plottin.mp3', 3, 0),
(13, 'Position', 3, 3, 1, '3:19', 'resource/music/Feed Tha Streets/Position.mp3', 4, 0),
(14, 'Uber', 3, 3, 1, '2:51', 'resource/music/Feed Tha Streets/Uber.mp3', 5, 0),

(15, '5 Minutes of Funktown', 4, 4, 1, '5:01', 'resource/music/Drug Funnie/5 Minutes of Funktown.mp3', 1, 0),
(16, 'Come And Talk To Me', 4, 4, 1, '3:16', 'resource/music/Drug Funnie/Come And Talk To Me.mp3', 2, 0),
(17, 'Foreal Foreal', 4, 4, 1, '3:20', 'resource/music/Drug Funnie/Foreal Foreal.mp3', 3, 0),

(18, 'Billie Jean', 5, 5, 2, '6:23', 'resource/music/Number Ones/Billie Jean.mp3', 1, 0),
(19, 'Dont Stop Til You Get You Get Enough', 5, 5, 2, '3:58', 'resource/music/Number Ones/Dont Stop Til You Get Enough.mp3', 2, 0);

