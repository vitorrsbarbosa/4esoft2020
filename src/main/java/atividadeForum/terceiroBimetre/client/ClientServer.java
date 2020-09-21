package atividadeForum.terceiroBimetre.client;

import atividadeForum.terceiroBimetre.server.PingServer;

import java.io.*;
import java.net.Socket;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ClientServer {
    public static void main(String[] args) {
        ClientServer clientServer = new ClientServer();
        clientServer.run();
    }

    private void run() {
        try (Socket connection = new Socket(PingServer.HOSTNAME, PingServer.PORT)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            PrintWriter out = new PrintWriter(connection.getOutputStream());

            List<Long> timeRequestsAmount = new ArrayList<>();
            long timeBeforeAllRequests = System.nanoTime();
            for (int count = 0; count < 100; count++) {
               out.write("ping \n");
               out.flush();

               long timeBeforeRequest = System.nanoTime();
               long timeAfterRequest = System.nanoTime();
               String message = in.readLine();
               System.out.println(message);

               long requestDuration = timeAfterRequest - timeBeforeRequest;
               timeRequestsAmount.add(requestDuration);
            }
            out.write("final \n");
            out.flush();

            System.out.println(in.readLine());

            long timeAfterAllRequests = System.nanoTime();
            System.out.print(
                    "Amount of time: " + (Duration.of(timeAfterAllRequests - timeBeforeAllRequests, ChronoUnit.NANOS)).toMillis() + "ms \n"

                    + "Average request duration: " + timeRequestsAmount.stream().mapToLong(value -> value).average().getAsDouble() + "ns \n"

                    + "Fastest request: " + timeRequestsAmount.stream().min(Comparator.comparing(Function.identity())).get() + "ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
