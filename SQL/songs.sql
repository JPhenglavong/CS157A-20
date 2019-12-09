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
(19, 'Dont Stop Til You Get Enough', 5, 5, 2, '3:58', 'resource/music/Number Ones/Dont Stop Til You Get Enough.mp3', 2, 0),

(20, 'My Love', 7, 7, 7, '4:34', 'resource/music/Chinese Melodies/My Love.mp3', 1, 0),
(21, 'Theres Only You In My Heart', 7, 7, 7, '5:00', 'resource/music/Chinese Melodies/Theres Only You In My Heart.mp3', 2, 0),

(22, 'Confessions Pt 2', 8, 8, 15, '4:34', 'resource/music/Confessions/Confessions pt2.mp3', 1, 0),
(23, 'Let It Burn', 8, 8, 15, '5:00', 'resource/music/Confessions/Let It Burn.mp3', 2, 0),

(24, 'Savan Pid', 9, 9, 12, '3:42', 'resource/music/Don Sonrabiab Classics/Savan Pid.mp3', 1, 0),
(25, 'Tang Ruk See Dum', 9, 9, 12, '4:29', 'resource/music/Don Sonrabiab Classics/Tang Ruk See Dum.mp3', 2, 0),

(26, 'Foolish', 10, 10, 14, '3:17', 'resource/music/G-Worthy/Foolish.mp3', 1, 0),
(27, 'Never Miss', 10, 10, 14, '3:44', 'resource/music/G-Worthy/Never Miss.mp3', 2, 0),

(28, 'Cheri Cheri Lady', 11, 11, 5, '3:17', 'resource/music/Lets Talk About Love/Cheri Cheri Lady.mp3', 1, 0),
(29, 'Youre My Heart Youre My Soul', 11, 11, 5, '3:15', 'resource/music/Lets Talk About Love/Youre My Heart Youre My Soul.mp3', 2, 0),

(30, 'Jai Sung Mai', 12, 12, 13, '3:30', 'resource/music/Loso Greatest Hits/Jai Sung Mah.mp3', 1, 0),
(31, 'Som Sarn', 12, 12, 13, '5:14', 'resource/music/Loso Greatest Hits/Som Sarn.mp3', 2, 0),

(32, 'Dont You Know That', 13, 13, 10, '4:05', 'resource/music/Never Too Much/Dont You Know That.mp3', 1, 0),
(33, 'Never Too Much', 13, 13, 10, '4:41', 'resource/music/Never Too Much/Never Too Much.mp3', 2, 0),

(34, 'Burn Out', 14, 14, 3, '3:07', 'resource/music/On The Rocks/Burn Out.mp3', 1, 0),
(35, 'Drinkin Problem', 14, 14, 3, '3:48', 'resource/music/On The Rocks/Drinkin Problem.mp3', 2, 0),

(36, 'I Need A Girl', 15, 15, 8, '3:37', 'resource/music/Solar/I Need A Girl.mp3', 1, 0),
(37, 'Wedding Dress', 15, 15, 8, '4:00', 'resource/music/Solar/Wedding Dress.mp3', 2, 0),

(38, 'Sad Eyes', 6, 6, 9, '3:51', 'resource/music/The River/Sad Eyes.mp3', 1, 0),
(39, 'Take Em As They Come', 6, 6, 9, '4:36', 'resource/music/The River/Take Em As They Come.mp3', 2, 0),

(40, 'That Tinh', 16, 16, 11, '6:34', 'resource/music/Vietnamese Karaoke Classics/That Tinh.mp3', 1, 0),
(41, 'Vang Trang Khoc', 16, 16, 11, '5:10', 'resource/music/Vietnamese Karaoke Classics/Vang Trang Khoc.mp3', 2, 0),

(42, 'Intro', 17, 17, 14, '2:08', 'resource/music/XX/Intro.mp3', 1, 0),
(43, 'Islands', 17, 17, 14, '2:42', 'resource/music/XX/Islands.mp3', 2, 0),

(44, 'From January To June', 18, 18, 16, '4:15', 'resource/music/Yoon Jong Shin Ballad/From January To June.mp3', 1, 0),
(45, 'I Like', 18, 18, 16, '5:28', 'resource/music/Yoon Jong Shin Ballad/I Like.mp3', 2, 0);











