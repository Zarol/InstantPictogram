# InstantPictogram
## Saharath Kleips
Originally programmed as a CPE 400 Computer Communication Networks final project (November 23rd, 2015).

Currently the server is able to accept messages to create a user, and authenticate users. The client simply sends an authentication request on load.

This project is designed to display client-server interactions, APIs, and restricted access to data. The project uses Java as its server and currently uses C#.NET with WPF forms as its Window's client UI. The goal is to develop an API so client applications may be ported to Linux, OSX, iOS, Android, and Web.

The project itself mirrors [Instagram](https://instagram.com/) in the sense that users upload images and add friends. Only friends are allowed to see what a user has uploaded. Users may also remove friends in order to revoke access to images.

Currently the project stores the database of usernames, passwords, friends, pending friend requests, and images into RAM. However, this will be changed to a real database in a future iteration.

## JSON API
<table>
    <tbody>
        <tr>
            <th> Name </th>
            <th> Request / Response </th>
            <th> Example </th>
            <th> Description </th>
        </tr>
        <tr>
            <td> Authentication </td>
            <td> 
                {  
                "Authentication":{  
                "Username":"STRING",  
                "Password":"STRING",  
                "Authenticated":BOOLEAN  
                }  
                } 
            </td>
            <td> 
                {  
                "Authentication":{  
                "Username":"SaharathKleips",  
                "Password":"12345",  
                "Authenticated":true  
                }  
                } 
            </td>
            <td> Checks if the username and password combination is valid. "Authenticated" will be true if valid, false if otherwise. </td>
        </tr>
        <tr>
            <td> Create User </td>
            <td> 
                {\n
                "CreateUser":{  
                "Username":"STRING",  
                "Password":"STRING",  
                "Created":BOOLEAN  
                }  
                } 
            </td>
            <td> 
                {  
                "CreateUser":{  
                "Username":"SaharathKleips",  
                "Password":"12345",  
                "Created":true  
                }  
                } 
            </td>
            <td> Attempts to create a user with the requested username / password. "Created" will be true if the user has been created, false otherwise.</td>
        </tr>
    </tbody>
</table>

### Contact Information
**LinkedIn:** http://www.linkedin.com/in/SaharathKleips  
**Email:** SaharathKleips@nevada.unr.edu