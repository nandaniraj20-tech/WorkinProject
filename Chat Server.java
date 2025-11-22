import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try {
            // 1. Start the Server on Port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            // 2. Wait for a client to connect (Blocks until connection made)
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // 3. Setup Input and Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // 4. Create a separate Thread to receive messages
            // We need a thread so we can Receive and Send at the same time!
            Thread receiveThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = input.readLine()) != null) {
                        System.out.println("Client: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });
            receiveThread.start();

            // 5. Main thread handles Sending messages
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String sendMsg = scanner.nextLine();
                output.println(sendMsg);
                if (sendMsg.equalsIgnoreCase("exit")) break;
            }

            // Cleanup
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
