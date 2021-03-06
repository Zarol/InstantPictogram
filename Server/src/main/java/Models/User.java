package Models;

import java.util.ArrayList;

/**
 * Created by Saharath Kleips on 11/11/2015.
 */
public class User {
    private String username;
    private String password;
    private ArrayList<String> friends;
    private ArrayList<byte[]> photos;
    private ArrayList<String> friendRequests;

    public User( String username )
    {
        this.username = username;
        this.password = "";
    }

    public User( String username, String password )
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public ArrayList<byte[]> getPhotos() {
        return photos;
    }

    public ArrayList<String> getFriendRequests() {
        return friendRequests;
    }

    public boolean addFriend( String username )
    {
        if( !friends.contains( username ) )
        {
            friends.add( username );
            return true;
        }
        else
            return false;
    }

    public boolean removeFriend( String username )
    {
        if( friends.contains( username ) )
        {
            friends.remove(username);
            return true;
        }
        else
            return false;
    }

    public boolean addPhoto( byte[] photo )
    {
        photos.add( 0, photo );
        return true;
    }

    public boolean addFriendRequest( String username )
    {
        if( !friendRequests.contains( username ))
        {
            friendRequests.add( username );
            return true;
        }
        else
            return false;
    }

    public boolean removeFriendRequest( String username )
    {
        if( friendRequests.contains( username ) )
        {
            friendRequests.remove(username);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean equals(Object object)
    {
        if( object == null || object.getClass() != getClass() ) {
           return false;
        } else {
            User user = (User) object;
            if( this.username.equals( user.getUsername()) )
                return true;
            else
                return false;
        }
    }

    @Override
    public int hashCode()
    {
        return this.username.hashCode();
    }
}
