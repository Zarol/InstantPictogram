import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Saharath Kleips on 11/10/2015.
 */
public class WorkerRunnable implements  Runnable {
    protected Socket clientSocket = null;
    protected String serverText = null;

    public WorkerRunnable( Socket clientSocket, String serverText )
    {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    public void run()
    {
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            output.write(("HTTP/1.1 200 OK\n\n").getBytes());
            output.write(( "\nRequest processed at: " + System.currentTimeMillis()).getBytes());
            output.close();
            input.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
}
