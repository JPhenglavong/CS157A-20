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

![cs157a_ERD (1)](https://user-images.githubusercontent.com/45501926/66726122-5f648a00-edec-11e9-8826-fd5b99387c4d.png)

Schemas: 

       1. register(ID, firstname, last name, email, password)
![Screenshot_3](https://user-images.githubusercontent.com/45501926/66726205-c2eeb780-edec-11e9-8aa1-342420201e92.png)

        2. User(ID, username, password)\
![Screenshot_1](https://user-images.githubusercontent.com/45501926/66726227-eca7de80-edec-11e9-81fe-c59a7bf25f93.png)

         3. Playlist(ID, name)\
![Screenshot_2](https://user-images.githubusercontent.com/45501926/66726240-034e3580-eded-11e9-9811-7b0b95db163a.png)

         4. song(ID, fileFormat, title)\
![Screenshot_4](https://user-images.githubusercontent.com/45501926/66726253-152fd880-eded-11e9-8bda-32564091dac5.png)

         5. album(ID, year, name)
![Screenshot_5](https://user-images.githubusercontent.com/45501926/66726277-34c70100-eded-11e9-8aa6-2b589003b1bc.png)

         6. Artist (ID, name, country)
![Screenshot_1](https://user-images.githubusercontent.com/45501926/66726293-4dcfb200-eded-11e9-8b5b-3787783e292d.png)

          7.will(regiterID, UserID)
![Screenshot_2](https://user-images.githubusercontent.com/45501926/66726340-a4d58700-eded-11e9-99c9-e1216dfefd83.png)

          8.Plays (userID, playlistID)
![Screenshot_3](https://user-images.githubusercontent.com/45501926/66726343-aa32d180-eded-11e9-9a20-f0858d3ccefe.png)

          9.contains(playlistID, songID)
![Screenshot_4](https://user-images.githubusercontent.com/45501926/66726344-ad2dc200-eded-11e9-8295-94f9ba6056e7.png)

          10.include(songID, albumID)
![Screenshot_5](https://user-images.githubusercontent.com/45501926/66726347-b028b280-eded-11e9-982c-4d1c83b2f8f2.png)

          11.create(artistID, albumID)
![Screenshot_6](https://user-images.githubusercontent.com/45501926/66726356-b4ed6680-eded-11e9-8172-8c373cb2f8e9.png)







