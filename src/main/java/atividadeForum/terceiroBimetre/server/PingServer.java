package atividadeForum.terceiroBimetre.server;

import java.net.ServerSocket;

public class PingServer {
    public static final int PORT = 8088;
    public static final String HOSTNAME = "localhost";

    public static void main(String[] args) {
        PingServer pingServer = new PingServer();
        pingServer.runServer();
    }

    private void runServer() {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            PingServerHandler pingServerHandler = new PingServerHandler(serverSocket.accept());
            System.out.println("request received.");
            pingServerHandler.run();
            System.out.println("request handled.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
