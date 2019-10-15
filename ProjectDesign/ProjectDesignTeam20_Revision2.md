# Team number: 20
Member’s Names:\
Khoa Pham\
Johnny Phenglavong\
Yu Xiao(Tom) Zheng

# Project Design
## Explanation

Entities:
1.  User: holders that listen to music (everyone can have an account).
2.  Song: Media that users can listen to.
3.  Artist: Content creators for our music platform.
4.  Album: A collection of songs from artists.
5.  Playlist: User selected collection of music.
6.  Register: user will have to register for an account so that they can perform creating a playlist

Attributes: 
1.  User: Username, password, ID.
2.  Song: ID, Title and Duration.
3.  Artist: Name, Country, and ID.
4.  Album: ID, Name and Year.
5.  Playlist: ID, and Name.
6.  Register: ID, first name, password, email, Lastname, username

Relationships:
1.  Plays: The user with a user account can play music in the playlist
2.  Plays(between user and song): The users can listen to many songs
3.  Rating(between user and song): the users can leave the rating for many songs 
4.  Contains: The playlist will contain a number of songs, which can be none
5.  Include: Song is included in a specific album
6.  Create: An artist will create an album
7.  Will: a user will register for an account to get some advance ability like making a playlist

Dependency:
1.  A user with an account can play one playlist at a time
2.  One Playlist can contain many songs and a song can be included in many playlists
3.  A song can only be in one album but an album can have many songs
4.  An album can only be created by one artist but an artist can create many albums

![cs157a_ERD](https://user-images.githubusercontent.com/45501926/66868028-678a0a00-ef51-11e9-9332-fac3800c4b84.png)

Schemas: 

1.
```sql
User(ID, username, password)
```
   
![Screenshot_123](https://user-images.githubusercontent.com/45501926/66866404-10cf0100-ef4e-11e9-8e87-3305cf9d36e5.png)


2.
```sql
Playlist(ID, name)
``` 
![Screenshot_2](https://user-images.githubusercontent.com/45501926/66726240-034e3580-eded-11e9-9811-7b0b95db163a.png)

3.
```sql
song(ID, fileFormat, title)
```
![Screenshot_4](https://user-images.githubusercontent.com/45501926/66726253-152fd880-eded-11e9-8bda-32564091dac5.png)

4.
```sql
album(ID, year, name)
```

![Screenshot_5](https://user-images.githubusercontent.com/45501926/66726277-34c70100-eded-11e9-8aa6-2b589003b1bc.png)

5.
```sql
Artist (ID, name, country)
```
![Screenshot_1](https://user-images.githubusercontent.com/45501926/66726293-4dcfb200-eded-11e9-8b5b-3787783e292d.png)

6.
```sql
rating (UserID,SongID)
```
![Screenshot_32](https://user-images.githubusercontent.com/45501926/66867224-b2a31d80-ef4f-11e9-85da-306cd53d177f.png)

7.
```sql
Plays (userID, playlistID)
```
          
![Screenshot_3](https://user-images.githubusercontent.com/45501926/66726343-aa32d180-eded-11e9-9a20-f0858d3ccefe.png)

8.
```sql
contains(playlistID, songID)
```
![Screenshot_4](https://user-images.githubusercontent.com/45501926/66726344-ad2dc200-eded-11e9-8295-94f9ba6056e7.png)

9.
```sql
include(songID, albumID)
```
![Screenshot_5](https://user-images.githubusercontent.com/45501926/66726347-b028b280-eded-11e9-982c-4d1c83b2f8f2.png)

10.
```sql
create(artistID, albumID)
```
![Screenshot_6](https://user-images.githubusercontent.com/45501926/66726356-b4ed6680-eded-11e9-8172-8c373cb2f8e9.png)

---
### SQL codes
```sql
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(40) NOT NULL,
  `signUpDate` datetime NOT NULL,
  `profilePic` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE MyISAM;

--

CREATE TABLE `team20`.`Songs` ( 
    `id` INT NOT NULL AUTO_INCREMENT , 
    `title` VARCHAR(250) NOT NULL , 
    `artist` INT NOT NULL , 
    `album` INT NOT NULL , 
    `genre` INT NOT NULL , 
    `duration` VARCHAR(8) NOT NULL , 
    `path` VARCHAR(500) NOT NULL , 
    `albumOrder` INT NOT NULL , 
    `plays` INT NOT NULL , PRIMARY KEY (`id`)
) ENGINE = InnoDB;

--

CREATE TABLE `team20`.`genres` ( 
    `id` INT NOT NULL AUTO_INCREMENT , 
    `name` VARCHAR(50) NOT NULL , 
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;


--

CREATE TABLE `team20`.`artists` ( 
    `id` INT NOT NULL AUTO_INCREMENT , 
    `name` VARCHAR(50) NOT NULL , 
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;


--

CREATE TABLE `team20`.`albums` (
     `id` INT NOT NULL AUTO_INCREMENT , 
     `title` VARCHAR(250) NOT NULL , 
     `artist` INT NOT NULL , 
     `genre` INT NOT NULL , 
     `artworkPath` VARCHAR(500) NOT NULL , 
     PRIMARY KEY (`id`)
) ENGINE = InnoDB;



INSERT INTO `artists` (`id`, `name`) 
    VALUES (NULL, 'Tom Zheng'), 
    (NULL, 'Yuxiao Zheng')

INSERT INTO `artists` (`id`, `name`) 
    VALUES (NULL, 'Horseman'), 
    (NULL, 'Mike Wu');
--


INSERT INTO `genres` (`id`, `name`) 
    VALUES (NULL, 'Rock'), 
    (NULL, 'Pop'), 
    (NULL, 'Hip-hop'), 
    (NULL, 'Rap'), 
    (NULL, 'R & B'), 
    (NULL, 'Classical'), 
    (NULL, 'Techno'), 
    (NULL, 'Jazz'), 
    (NULL, 'Folk'), 
    (NULL, 'Country');


--

INSERT INTO `albums` (`id`, `title`, `artist`, `genre`, `artworkPath`) 
    VALUES (NULL, 'Macbook Pro 15', '2', '4', 'assets/images/artwork/album.png'), 
    (NULL, 'De Anza College', '5', '10', 'assets/images/artwork/react.png'),
    (NULL, 'Tom Zheng', '3', '1', 'assets/images/artwork/alb.png'),
    (NULL, 'C++', '2', '9', 'assets/images/artwork/react.png'),
    (NULL, 'MySQL', '1', '3', 'assets/images/artwork/alb.png'),
    (NULL, 'JDBC', '3', '6', 'assets/images/artwork/album.png'),
    (NULL, 'React.JS', '4', '7', 'assets/images/artwork/alb.png');


INSERT INTO `Songs` (`id`, `title`, `artist`, `album`, `genre`, `duration`, `path`, `albumOrder`, `plays`) VALUES
(1, 'Intro', 1, 5, 8, '2:37', 'assets/music/intro.mp3', 1, 0),
(2, 'Intro', 1, 5, 1, '2:35', 'assets/music/hello.mp3', 2, 0),
(3, 'C++', 1, 5, 2, '2:33', 'assets/music/intro.mp3', 3, 0),
(4, 'Java', 1, 5, 3, '2:02', 'assets/music/intro.mp3', 4, 0),
(5, 'De Anza', 1, 5, 4, '1:29', 'assets/music/intro.mp3', 5, 0),
(6, 'College', 2, 1, 1, '4:04', 'assets/music/intro.mp3', 1, 0),
(7, 'Javascript', 2, 4, 2, '3:07', 'assets/music/intro.mp3', 2, 0),
(8, 'python', 2, 1, 3, '3:08', 'assets/music/intro.mp3', 2, 0),
(9, 'Intro', 2, 1, 4, '8:03', 'assets/music/intro.mp3', 3, 0),
(10, 'Intro', 2, 4, 5, '2:58', 'assets/music/intro.mp3', 3, 0),
(11, 'Hello world', 2, 1, 6, '2:59', 'assets/music/intro.mp3', 4, 0),
(12, 'apple', 2, 1, 7, '2:03', 'assets/music/intro.mp3', 5, 0),
(13, 'mouse', 3, 6, 8, '4:21', 'assets/music/intro.mp3', 5, 0),
(14, 'shen jing bing', 3, 6, 9, '1:45', 'assets/music/intro.mp3', 4, 0),
(15, 'Tom', 3, 6, 10, '1:44', 'assets/music/intro.mp3', 3, 0),
--






```






