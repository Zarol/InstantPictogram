package Messages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Created by Saharath Kleips on 11/12/2015.
 */
public class CreateUserMessage {
    static final String MESSAGE_TYPE = "CreateUser";

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

    public JsonObject toJson()
    {
        JsonObjectBuilder messageBuilder = Json.createObjectBuilder();
        JsonObjectBuilder thisBuilder = Json.createObjectBuilder();
        thisBuilder.add( "Username", this.username)
                   .add("Password", this.password)
                   .add("Created", this.created);

        messageBuilder.add( this.MESSAGE_TYPE, thisBuilder );
        return messageBuilder.build();
    }
}
