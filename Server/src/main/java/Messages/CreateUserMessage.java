package Messages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Created by Saharath Kleips on 11/12/2015.
 */
public class CreateUserMessage implements Message{
    static final String MESSAGE_TYPE = "CreateUser";
    static final String USERNAME_KEY = "Username";
    static final String PASSWORD_KEY = "Password";
    static final String CREATED_KEY = "Created";

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCreated() { return created; }

    public void setCreated(boolean created) {
        this.created = created;
    }

    String username;
    String password;
    boolean created;

    public CreateUserMessage(String username, String password, boolean created)
    {
        this.username = username;
        this.password = password;
        this.created = created;
    }

    public CreateUserMessage(JsonObject object)
    {
        JsonObject contents = JsonHelper.jsonFromString( object.get(MESSAGE_TYPE).toString() );
        this.username = contents.getString(USERNAME_KEY);
        this.password = contents.getString(PASSWORD_KEY);
        this.created = Boolean.parseBoolean( contents.get(CREATED_KEY).toString() );
    }

    public JsonObject toJson()
    {
        JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
        JsonObjectBuilder thisBuilder = Json.createObjectBuilder();
        thisBuilder.add(USERNAME_KEY, this.username)
                   .add(PASSWORD_KEY, this.password)
                   .add(CREATED_KEY, this.created);

        messageBuilder.add(this.MESSAGE_TYPE, thisBuilder );
        return messageBuilder.build();
    }

    public byte[] getMessageBytes() { return toJson().toString().getBytes(); }

    public int getMessageLength() { return getMessageBytes().length; }
}
