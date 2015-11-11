/**
 * Created by Saharath Kleips on 11/11/2015.
 */
public class Database {
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
    }
}
