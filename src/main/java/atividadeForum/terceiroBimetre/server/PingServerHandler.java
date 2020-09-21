package atividadeForum.terceiroBimetre.server;

import java.io.*;
import java.net.Socket;

public class PingServerHandler {
    private final Socket socket;

    public PingServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            Writer out = new PrintWriter(this.socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            String message = in.readLine();
            if (message.contains("final")) {
                out.write("closing connection. \n");
                out.flush();
                this.socket.close();
            }
            if (message.contains("ping")) {
                out.write("ping \n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

