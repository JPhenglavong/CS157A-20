# CS157A Team-20

Team Members:
Johnny Phenglavong,
Khoa Pham
& Yu Xiao Zheng

---

### `Create a database for our team20`
- create team-20 table
`CREATE DATABASE IF NOT EXISTS team20;`
---
![](img/2019-09-25-19-53-53.png)
---
- create a table
![](img/2019-09-25-19-54-54.png)
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
```


### `first we implement a streaming music project `
- some icon color:
`#07D159`
---

![](img/2019-09-15-14-15-42.png)
---


### after login,
![](img/2019-10-15-10-47-36.png)
---

### updating the newest functioning...
![](img/2019-10-15-11-43-46.png)
---

### updating UI with Login Register
![](img/2019-11-12-10-52-32.png)
---
### `Register UI`
![](img/2019-11-12-10-52-48.png)
---
![](img/2019-11-21-11-05-22.png)
---
![](img/2019-11-21-11-17-49.png)
---


- now can play a song under the background [Still Testing...]
- 
![](img/2019-11-24-21-03-34.png)
- can output the album pic and song's title, artist
- but still a little mistake
