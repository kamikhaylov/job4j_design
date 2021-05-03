package ru.job4j.block02.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String BYE = "Bye ";
    private static boolean status = true;

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
                        checkStatus(str);
                        str = in.readLine();
                    }
                    if (status) {
                        out.write("HTTP/1.1 200 OK\r\n\"".getBytes());
                    } else {
                        out.write("HTTP/1.1 200 Сервер закрыт\r\n\"".getBytes());
                        server.close();
                    }
                }
            }
        }
    }

    private static void checkStatus(String msg) {
        if (msg.contains("/?msg=" + BYE)) {
            status = false;
        }
    }
}