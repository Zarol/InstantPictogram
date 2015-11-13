package Models;

import java.util.List;

/**
 * Created by Saharath Kleips on 11/11/2015.
 */
public class Database {
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private List<Models.User> users;

    private Database() {

    }

    public boolean containsUser( String username )
    {
        User user = new User( username );
        return users.contains( user );
    }

    public boolean addUser( String username, String password )
    {
        User user = new User(username, password);
        if (!users.contains(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public String getUserPassword( String username )
    {
        User user = getUser( username );
        if( user != null )
        {
            return user.getPassword();
        }
        else
            return null;
    }

    public List<String> getUserFriends( String username )
    {
        User user = getUser( username );
        if( user != null )
            return user.getFriends();
        else
            return null;
    }

    public List<byte[]> getUserPhotos( String username )
    {
        User user = getUser( username );
        if( user != null )
            return user.getPhotos();
        else
            return null;
    }

    public List<String> getUserFriendRequests( String username )
    {
        User user = getUser( username );
        if( user != null )
            return user.getFriendRequests();
        else
            return null;
    }

    public boolean addUserFriend( String username, String friendUsername )
    {
        User user = getUser( username );
        User userFriend = getUser( friendUsername );
        if( user != null && userFriend != null )
            return user.removeFriendRequest( friendUsername ) && user.addFriend( friendUsername )
                    && userFriend.addFriend( username );
        else
            return false;
    }

    public boolean removeUserFriend( String username, String friendUsername )
    {
        User user = getUser( username );
        User userFriend = getUser( friendUsername );
        if( user != null && userFriend != null )
            return user.removeFriend( friendUsername ) && userFriend.removeFriend( username );
        else
            return false;
    }


    public boolean addUserPhoto( String username, byte[] photo )
    {
        User user = getUser( username );
        if( user != null )
            return user.addPhoto( photo );
        else
            return false;
    }

    public boolean addUserFriendRequest( String username, String requestedUsername )
    {
        User user = getUser( username );
        if( user != null )
            return user.addFriendRequest( requestedUsername );
        else
            return false;
    }

    private User getUser( String username )
    {
        if( containsUser( username ) )
        {
            User user = new User( username );
            user = users.get( users.indexOf( user ) );
            return user;
        }
        else
            return null;
    }
}
