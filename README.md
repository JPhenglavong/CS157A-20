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
---


### `first we implement a streaming music project `
- some icon color:
`#07D159`
---

### `Login UI`
![](img/2019-09-15-13-03-22.png)
---

### `Register UI`
![](img/2019-09-15-15-06-22.png)
---
![](img/2019-09-15-14-15-42.png)
---


### after login,
![](img/2019-10-15-10-47-36.png)
---

### updating the newest functioning...
![](img/2019-10-15-11-43-46.png)
---

### Try to update songs
![](img/2019-11-05-13-12-59.png)
---

### Modify PHP to upload more than 2MB as default of PHP
Finding the PHP.ini (configurations setting type)/
then change the upload_max_filesize to >10M for normal music /
post_max_size also need to be changed to your designed MB
![Screenshot_2](https://user-images.githubusercontent.com/45501926/68353253-dc1e1780-00bd-11ea-91da-7ec38a83abb3.png)

---


