# InstantPictogram
## Saharath Kleips
Originally programmed as a CPE 400 Computer Communication Networks final project. Turns out I misinterpreted "Social Network." It was supposed to be like... Social Networking (routing algorithm).

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
                {<br>
                "Authentication":{<br>
                "Username":"STRING",<br>
                "Password":"STRING",<br>
                "Authenticated":BOOLEAN<br>
                }<br>
                } 
            </td>
            <td> 
                {<br>
                "Authentication":{<br>
                "Username":"SaharathKleips",<br>
                "Password":"12345",<br>
                "Authenticated":true<br>
                }<br>
                } 
            </td>
            <td> Checks if the username and password combination is valid. "Authenticated" will be true if valid, false if otherwise. </td>
        </tr>
        <tr>
            <td> Create User </td>
            <td> 
                {<br>
                "CreateUser":{<br>
                "Username":"STRING",<br>
                "Password":"STRING",<br>
                "Created":BOOLEAN<br>
                }<br>
                } 
            </td>
            <td> 
                {<br>
                "CreateUser":{<br>
                "Username":"SaharathKleips",<br>
                "Password":"12345",<br>
                "Created":true<br>
                }<br>
                } 
            </td>
            <td> Attempts to create a user with the requested username / password. "Created" will be true if the user has been created, false otherwise.</td>
        </tr>
        <tr>
            <td> Get User's Pending Friends </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Get User's Friends </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Get User's Photos </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Add User's Pending Friend </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Remove User's Pending Friend </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Remove User's Friend </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Add User's Photo </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Establish Friendship </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
        <tr>
            <td> Query Usernames </td>
            <td> 
                
            </td>
            <td> 
                
            </td>
            <td></td>
        </tr>
    </tbody>
</table>

### Contact Information
**LinkedIn:** http://www.linkedin.com/in/SaharathKleips  
**Email:** SaharathKleips@nevada.unr.edu
