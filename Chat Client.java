import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // 1. Connect to the Server (localhost means this computer)
            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Connected to Server!");

            // 2. Setup Input and Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // 3. Create a separate Thread to receive messages
            Thread receiveThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = input.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });
            receiveThread.start();

            // 4. Main thread handles Sending messages
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String sendMsg = scanner.nextLine();
                output.println(sendMsg);
                if (sendMsg.equalsIgnoreCase("exit")) break;
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("Server not found. Make sure Server is running first!");
        }
    }
}
