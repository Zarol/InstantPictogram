package Messages;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

/**
 * Created by Saharath Kleips on 11/15/2015.
 */
public class JsonHelper {
    public static JsonObject jsonFromString( String str )
    {
        JsonReader jsonReader = Json.createReader(new StringReader(str));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        return object;
    }
}
