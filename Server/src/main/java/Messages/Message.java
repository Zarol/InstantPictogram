package Messages;

import javax.json.JsonObject;

/**
 * Created by Saharath Kleips on 11/15/2015.
 */
public interface Message {
    JsonObject toJson();
    byte[] getMessageBytes();
    int getMessageLength();
}
