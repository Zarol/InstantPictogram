import Messages.AuthenticationMessage;
import Messages.CreateUserMessage;
import Models.Database;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Saharath Kleips on 11/10/2015.
 */
public class MultiThreadedServer implements Runnable{
    protected InetAddress serverAddress;
    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;

    MultiThreadedServer( int port, InetAddress address )
    {
        this.serverAddress = address;
        this.serverPort = port;
    }

    public static void main( String args[] )
        throws Exception
    {
        // ADDING TEMPORARY USERS
        Database.getInstance().addUser( "Zarol", "12345" );
        // ADDING TEMPORARY USERS

        System.out.println( "Server running on: " + InetAddress.getLocalHost() + ":1337" );
        MultiThreadedServer server = new MultiThreadedServer( 1337, InetAddress.getLocalHost() );
        new Thread( server ).start();
    }

    public void run() {
        synchronized( this ){
            this.runningThread = Thread.currentThread();
        }

        openServerSocket();

        while( !isStopped() )
        {
            Socket clientSocket = null;

            try{
                clientSocket = this.serverSocket.accept();
            } catch ( IOException e ) {
                if (isStopped()) {
                    System.out.println( "Server stopped." );
                    return;
                }
                throw new RuntimeException( "Error accepting client connection.", e);
            }
            new Thread( new WorkerRunnable( clientSocket, "Multithreaded Server" ) ).start();
        }
        System.out.println( "Server stopped." );
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;

        try {
            this.serverSocket.close();
        } catch ( IOException e ) {
            throw new RuntimeException( "Error closing server.", e );
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket( this.serverPort, 1337, serverAddress );
        } catch ( IOException e ) {
            throw new RuntimeException( "Cannot open port: " + this.serverPort, e );
        }
    }
}
