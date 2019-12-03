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

--Separated artists by spaces just to avoid confusinon

-- INSERT INTO `songs` (`id`, `title`, `artist`, `album`, `genre`, `duration`, `path`, `albumOrder`, `plays`) VALUES
-- (1, '2Face', 1, 1, 1, '4:46', 'resource/music/Friday Night Lights/2Face.mp3', 1, 0),
-- (2, 'Back To The Topic Freestyle', 1, 1, 1, '3:00', 'resource/music/Friday Night Lights/Back To The Topic Freestyle.mp3', 2, 0),
-- (3, 'Before Im Gone', 1, 1, 1, '4:24', 'resource/music/Friday Night Lights/Before Im Gone.mp3', 3, 0),
-- (4, 'Best Friend', 1, 1, 1, '3:25', 'resource/music/Friday Night Lights/Best Friend.mp3', 4, 0),

-- (5, 'Alien Girl', 2, 2, 1, '4:00', 'resource/music/Overly Dedicated/Alien Girl.mp3', 1, 0),
-- (6, 'Growing Apart', 2, 2, 1, '4:23', 'resource/music/Overly Dedicated/Growing Apart.mp3', 2, 0),
-- (7, 'Ignorance Is Bliss', 2, 2, 1, '3:31', 'resource/music/Overly Dedicated/Ignorance Is Bliss.mp3', 3, 0),
-- (8, 'PP 15', 2, 2, 1, '6:02', 'resource/music/Overly Dedicated/PP 15.mp3', 4, 0),
-- (9, 'The Heart Pt 2', 2, 2, 1, '4:54', 'resource/music/Overly Dedicated/The Heart Pt 2.mp3', 5, 0),

-- (10, 'Chase Tha Bag', 3, 3, 1, '3:33', 'resource/music/Feed Tha Streets/Chase Tha Bag.mp3', 1, 0),
-- (11, 'Fucc It Up', 3, 3, 1, '3:23', 'resource/music/Feed Tha Streets/Fucc It Up.mp3', 2, 0),
-- (12, 'Plottin', 3, 3, 1, '2:53', 'resource/music/Feed Tha Streets/Plottin.mp3', 3, 0),
-- (13, 'Position', 3, 3, 1, '3:19', 'resource/music/Feed Tha Streets/Position.mp3', 4, 0),
-- (14, 'Uber', 3, 3, 1, '2:51', 'resource/music/Feed Tha Streets/Uber.mp3', 5, 0),

-- (15, '5 Minutes of Funktown', 4, 4, 1, '5:01', 'resource/music/Drug Funnie/5 Minutes of Funktown.mp3', 1, 0),
-- (16, 'Come And Talk To Me', 4, 4, 1, '3:16', 'resource/music/Drug Funnie/Come And Talk To Me.mp3', 2, 0),
-- (17, 'Foreal Foreal', 4, 4, 1, '3:20', 'resource/music/Drug Funnie/Foreal Foreal.mp3', 3, 0),

-- (18, 'Billie Jean', 5, 5, 2, '6:23', 'resource/music/Number Ones/Billie Jean.mp3', 1, 0),
-- (19, 'Dont Stop Til You Get You Get Enough', 5, 5, 2, '3:58', 'resource/music/Number Ones/Dont Stop Til You Get Enough.mp3', 2, 0);

INSERT INTO `Songs` (`id`, `title`, `artist`, `album`, `genre`, `duration`, `path`, `albumOrder`, `plays`) VALUES
(1, 'Intro', 1, 5, 8, '2:08', 'resource/music/Intro.mp3', 1, 0),
(2, 'Dream of A Day', 1, 5, 1, '3:00', 'resource/music/Dream_of_A_Day.mp3', 2, 0),
(3, 'Tom LongLive Viva La Vida', 1, 5, 2, '1:34', 'resource/music/Tom.mp3', 3, 0),
(4, 'Bye Bye Bye', 1, 5, 3, '3:20', 'resource/music/ByeByeBye.mp3', 4, 0),
(5, 'Strength_Of_A_Thousand_Men', 1, 5, 4, '4:20', 'resource/music/Strength_Of_A_Thousand_Men.mp3', 5, 0),
(6, 'Seventy-Seven', 2, 1, 1, '3:06', 'resource/music/Seventy-Seven.mp3', 1, 0),
(7, 'In Need', 2, 4, 2, '3:40', 'resource/music/In_Need.mp3', 2, 0),
(8, 'Tomorrow', 2, 1, 3, '3:20', 'resource/music/Tomorrow.mp3', 2, 0),
(9, 'Extreme Action', 2, 1, 4, '4:20', 'resource/music/Strength_Of_A_Thousand_Men.mp3', 3, 0),
(10, 'Viva La Vida', 2, 4, 5, '2:08', 'resource/music/Intro.mp3', 3, 0),
(11, 'Energy', 2, 12, 6, '2:08', 'resource/music/Intro.mp3', 4, 0),
(12, 'Dubstep', 2, 1, 7, '2:08', 'resource/music/Intro.mp3', 5, 0),
(13, 'Happiness', 3, 6, 8, '2:08', 'resource/music/Intro.mp3', 5, 0),
(14, 'Happy Rock', 3, 6, 9, '2:08', 'resource/music/Intro.mp3', 4, 0),
(15, 'Jazzy Frenchy', 3, 6, 10, '2:08', 'resource/music/Intro.mp3', 3, 0),
(16, 'Little Idea', 3, 6, 1, '2:08', 'resource/music/Intro.mp3', 2, 0),
(17, 'Memories', 3, 6, 2, '2:08', 'resource/music/Intro.mp3', 1, 0),
(18, 'Moose', 4, 7, 1, '2:08', 'resource/music/Intro.mp3', 5, 0),
(19, 'November', 4, 7, 2, '2:08', 'resource/music/Intro.mp3', 4, 0),
(20, 'Of Elias Dream', 4, 7, 3, '2:08', 'resource/music/Intro.mp3', 3, 0),
(21, 'Pop Dance', 4, 12, 2, '2:08', 'resource/music/Intro.mp3', 2, 0),
(22, 'Retro Soul', 4, 12, 5, '2:08', 'resource/music/Intro.mp3', 1, 0),
(23, 'Sad Day', 5, 2, 1, '2:08', 'resource/music/Intro.mp3', 1, 0),
(24, 'Sci-fi', 5, 2, 2, '2:08', 'resource/music/Intro.mp3', 2, 0),
(25, 'Slow Motion', 5, 2, 3, '2:08', 'resource/music/Intro.mp3', 3, 0),
(26, 'Sunny', 5, 2, 4, '3:00', 'resource/music/Dream_of_A_Day.mp3', 4, 0),
(27, 'Sweet', 5, 2, 5, '3:00', 'resource/music/Dream_of_A_Day.mp3', 5, 0),
(28, 'Tenderness ', 3, 3, 7, '3:00', 'resource/music/Dream_of_A_Day.mp3', 4, 0),
(29, 'The Lounge', 3, 3, 8, '3:00', 'resource/music/Dream_of_A_Day.mp3 ', 3, 0),
(30, 'Ukulele', 3, 3, 9, '3:00', 'resource/music/Dream_of_A_Day.mp3 ', 2, 0),
(31, 'Tomorrow', 3, 3, 1, '3:00', 'resource/music/Dream_of_A_Day.mp3 ', 1, 0),
(32, 'Tom Long Live Viva La Vida', 6, 8, 11, '3:00', 'resource/music/Dream_of_A_Day.mp3', 1, 0),
(33, 'Long Live Viva La Vida', 7, 8, 12, '3:00', 'resource/music/Dream_of_A_Day.mp3', 2, 0),
(34, 'Long Tom Live Viva La Vida', 8, 8, 13, '3:00', 'resource/music/Dream_of_A_Day.mp3', 3, 0),
(35, 'Tom Long Tom Live Viva La Vida', 9, 9, 14, '3:00', 'resource/music/Dream_of_A_Day.mp3', 4, 0),
(36, 'Tom Long Live Viva Tom La Vida', 10, 9, 15, '3:00', 'resource/music/Dream_of_A_Day.mp3', 5, 0),
(37, 'Tom Long Live Viva La Vida Tom', 11, 9, 1, '3:00', 'resource/music/Dream_of_A_Day.mp3', 6, 0);
