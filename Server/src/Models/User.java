package Models;

import java.util.List;

/**
 * Created by Saharath Kleips on 11/11/2015.
 */
public class User {
    private String username;
    private String password;
    private List<String> friends;
    private List<byte[]> photos;
    private List<String> friendRequests;

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

    public List<String> getFriends() {
        return friends;
    }

    public List<byte[]> getPhotos() {
        return photos;
    }

    public List<String> getFriendRequests() {
        return friendRequests;
    }

    boolean addFriend( String username )
    {
        if( !friends.contains( username ) )
        {
            friends.add( username );
            return true;
        }
        else
            return false;
    }

    boolean removeFriend( String username )
    {
        if( friends.contains( username ) )
        {
            friends.remove(username);
            return true;
        }
        else
            return false;
    }

    boolean addPhoto( byte[] photo )
    {
        photos.add( 0, photo );
        return true;
    }

    boolean addFriendRequest( String username )
    {
        if( !friendRequests.contains( username ))
        {
            friendRequests.add( username );
            return true;
        }
        else
            return false;
    }

    boolean removeFriendRequest( String username )
    {
        if( friendRequests.contains( username ) )
        {
            friendRequests.remove( username );
            return true;
        }
        else
            return false;
    }
}