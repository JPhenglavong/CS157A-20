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
(5, 'Michael Wu');
