package ru.job4j.block02.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String EXIT = "Exit";
    private static final String HELLO = "Hello";
    private static boolean status = true;
    private static String msgServer = "";
    private static String msgServerExit = "";

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("/?msg=")) {
                            outMsg(str);
                        }
                        checkStatus(str);
                        str = in.readLine();
                    }
                    if (!status) {
                        out.write(msgServerExit.getBytes());
                        in.close();
                        out.close();
                        socket.close();
                        server.close();
                    } else {
                        out.write(msgServer.getBytes());
                    }
                }
            }
        }
    }

    private static void checkStatus(String msg) {
        if (msg.contains("/?msg=" + EXIT)) {
            status = false;
        }
        msgServerExit = "HTTP/1.0 200 OK\r\n"
                    + "Content-type text/html\r\n"
                    + "\r\n"
                    + "Server Exit\r\n";
    }

    private static void outMsg(String msg) {
        if (msg.contains(HELLO)) {
            msgServer = "HTTP/1.0 200 OK\r\n"
                    + "Content-type text/html\r\n"
                    + "\r\n"
                    + "Hello, dear friend.\r\n";
        } else {
            msgServer = "HTTP/1.0 200 OK\r\n"
                    + "Content-type text/html\r\n"
                    + "\r\n"
                    + "What?\r\n";
        }
    }
}