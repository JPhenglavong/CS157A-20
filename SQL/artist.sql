-- Table structure for table artists

CREATE TABLE IF NOT EXISTS artists (
    id int(11) NOT NULL,
     name varchar(50) NOT NULL
) ENGINE=InnoDB;

-- Data for table artists

INSERT INTO artists (id, name) VALUES
(1, 'J. Cole'),
(2, 'Kendrick Lamar'),
(3, 'Roddy Ricch'),
(4, 'Ezale'),
(5, 'Michael Wu'),
(6, 'Bruce Springsteen'),
(7, 'Various Chinese Artists'),
(8, 'Usher'),
(9, 'Don Sonrabiab'),
(10, 'G-Worthy'),
(11, 'Modern Talking'),
(12, 'Loso'),
(13, 'Luther Vandross'),
(14, 'Midland'),
(15, 'Taeyang'),
(16, 'Various Vietnamese Artists'),
(17, 'The XX'),
(18, 'Yoon Jong Shin');
