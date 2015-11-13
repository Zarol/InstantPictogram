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
        System.out.println( "Client connected: " + clientSocket.getInetAddress() );
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            byte[] messageByte = new byte[1024];
            int bytesRead = input.read( messageByte );
            System.out.println( "Message Recieved: " + new String(messageByte,0,bytesRead) );

            output.close();
            input.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
        System.out.println( "Client disconnected: " + clientSocket.getInetAddress() );
    }
}
