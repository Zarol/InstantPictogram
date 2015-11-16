package Messages;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Created by Saharath Kleips on 11/12/2015.
 */
public class AuthenticationMessage implements Message{
    static final String MESSAGE_TYPE = "Authentication";
    static final String USERNAME_KEY = "Username";
    static final String PASSWORD_KEY = "Password";
    static final String AUTHENTICATED_KEY = "Authenticated";

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

    public AuthenticationMessage(String username, String password, boolean authenticated) {
        this.username = username;
        this.password = password;
        this.authenticated = authenticated;
    }

    public AuthenticationMessage( JsonObject object )
    {
        JsonObject contents = JsonHelper.jsonFromString( object.get(MESSAGE_TYPE).toString() );
        this.username = contents.getString(USERNAME_KEY);
        this.password = contents.getString(PASSWORD_KEY);
        this.authenticated = Boolean.parseBoolean(contents.get(AUTHENTICATED_KEY).toString());
    }

    public JsonObject toJson() {
        JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
        JsonObjectBuilder thisBuilder = Json.createObjectBuilder();
        thisBuilder.add(USERNAME_KEY, this.username)
                .add(PASSWORD_KEY, this.password)
                .add(AUTHENTICATED_KEY, this.authenticated);

        messageBuilder.add(this.MESSAGE_TYPE, thisBuilder);
        return messageBuilder.build();
    }

    public byte[] getMessageBytes() {
        return toJson().toString().getBytes();
    }

    public int getMessageLength() {
        return getMessageBytes().length;
    }
}
