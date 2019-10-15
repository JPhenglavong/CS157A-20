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

Attributes: 
1.  User: Username, password, ID, Lastname, firstname, email, profilePic, signUpDate.
2.  Song: ID, Title and Duration, artist, album, genre, plays,path, albumOrder.
3.  Artist: Name, Country, and ID.
4.  Album: ID, Name and artist, artworkpath.
5.  Playlist: ID, and Name.

Relationships:
1.  Plays: The user with a user account can play music in the playlist
2.  Plays(between user and song): The users can listen to many songs
3.  Rating(between user and song): the users can leave the rating for many songs 
4.  Contains: The playlist will contain a number of songs, which can be none
5.  Include: Song is included in a specific album
6.  Create: An artist will create an album

Dependency:
1.  A user with an account can play one playlist at a time
2.  One Playlist can contain many songs and a song can be included in many playlists
3.  A song can only be in one album but an album can have many songs
4.  An album can only be created by one artist but an artist can create many albums

![cs157a_ERD (1)](https://user-images.githubusercontent.com/45501926/66868323-fa2aa900-ef51-11e9-8323-bf7a036aefe3.png)

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
songs(ID, Title and Duration, artist, album, genre, plays,path, albumOrder)
```
![Screenshot_333](https://user-images.githubusercontent.com/45501926/66871452-8b048300-ef58-11e9-8f6a-5701c21c11d3.png)


4.
```sql
album(ID, Name and artist, artworkpath)
```

![Screenshot_](https://user-images.githubusercontent.com/45501926/66872150-21857400-ef5a-11e9-820a-bf5a13f34d72.png)

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

11.
```sql
play(userID, songID)
```
![Screenshot_346](https://user-images.githubusercontent.com/45501926/66871684-05cd9e00-ef59-11e9-8d72-08e7bfdc2ab2.png)
---







