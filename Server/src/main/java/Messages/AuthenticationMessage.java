package Messages;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Created by Admin on 11/12/2015.
 */
public class AuthenticationMessage {
    static String MESSAGE_TYPE = "Authentication";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    String username;
    String password;
    boolean authenticated;

    public AuthenticationMessage(String username, String password, boolean authenticated)
    {
        this.username = username;
        this.password = password;
        this.authenticated = authenticated;
    }

    public JsonObject toJson()
    {
        JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
        JsonObjectBuilder thisBuilder = Json.createObjectBuilder();
        thisBuilder.add( "Username", this.username)
                   .add( "Password", this.password )
                   .add( "Authenticated", this.authenticated );

        messageBuilder.add( this.MESSAGE_TYPE, thisBuilder );
        return messageBuilder.build();
    }
}
