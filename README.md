This is a real-time, bidirectional Chat Application developed in Java. It simulates a messenger system where a Server and a Client can exchange messages instantly.

Unlike simple console programs, this project implements Multithreading to handle sending and receiving messages simultaneously, ensuring that the user does not have to wait for a reply before sending another message. It utilizes Java Socket Programming for networking.

🚀 Features

Full-Duplex Communication: Users can send and receive messages at the same time.

Socket Networking: Establishes a TCP connection between Client and Server.

Multithreading: Uses background threads to listen for incoming messages without freezing the main application.

Console Interface: Lightweight and fast command-line interface.

Graceful Exit: Type exit to close the connection safely.

🛠️ Technical Concepts Used

This project demonstrates mastery of the following Core Java concepts:

Networking (java.net): ServerSocket and Socket classes.

Multithreading (java.lang.Thread): Handling asynchronous tasks (Listening vs. Speaking).

I/O Streams (java.io): BufferedReader and PrintWriter for data transmission.

Exception Handling: Robust error management for connection failures.

📂 Project Structure

/JavaChatApp
│
├── ChatServer.java    # The Server-side code (Starts first)
├── ChatClient.java    # The Client-side code (Connects to Server)
└── README.md          # Documentation


💻 How to Run

To see the chat in action, you must simulate two different machines by opening two separate terminal windows.

Step 1: Compile the Code

Open your terminal in the project folder and run:

javac ChatServer.java ChatClient.java


Step 2: Start the Server

Open Terminal A and run:

java ChatServer


You will see: Server started. Waiting for client...

Step 3: Start the Client

Open Terminal B and run:

java ChatClient


You will see: Connected to Server!

Step 4: Chat!

Type a message in Terminal A and press Enter. It will appear in Terminal B.

Type a message in Terminal B and press Enter. It will appear in Terminal A.

📸 Usage Example

Server Window:

Server started. Waiting for client...
Client connected!
Client: Hello Server!
Hi Client, how are you?  <-- (Typed by User)


Client Window:

Connected to Server!
Hello Server!            <-- (Typed by User)
Server: Hi Client, how are you?



