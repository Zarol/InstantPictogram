# InstantPictogram
## Saharath Kleips
Originally programmed as a CPE 400 Computer Communication Networks final project (November 23rd, 2015).

Currently the server simply accepts messages and outputs them to the console. The client sends a JSON "Authentication Message" on load.

This project is designed to display client-server interactions, APIs, and restricted access to data. The project uses Java as its server and currently uses C#.NET with WPF forms as its Window's client UI. The goal is to develop an API so client applications may be ported to Linux, OSX, iOS, Android, and Web.

The project itself mirrors [Instagram](https://instagram.com/) in the sense that users upload images and add friends. Only friends are allowed to see what a user has uploaded. Users may also remove friends in order to revoke access to images.

Currently the project stores the database of usernames, passwords, friends, pending friend requests, and images into RAM. However, this will be changed to a real database in a future iteration.

### Contact Information
**LinkedIn:** http://www.linkedin.com/in/SaharathKleips  
**Email:** SaharathKleips@nevada.unr.edu