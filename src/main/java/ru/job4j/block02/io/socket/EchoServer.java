package ru.job4j.block02.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final String EXIT = "Exit";
    private static final String HELLO = "Hello";
    private static boolean status = true;
    private static String msgServer = "";
    private static String msgServerExit = "";
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
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
        } catch (IOException e) {
            LOG.error("IOException in log", e);
        }
    }

    private static void checkStatus(String msg) {
        if (msg.contains("/?msg=" + EXIT)) {
            status = false;
        }
        msgServerExit = "HTTP/1.0 200 OK"
                    + System.lineSeparator()
                    + System.lineSeparator()
                    + "Server Exit"
                    + System.lineSeparator();
    }

    private static void outMsg(String msg) {
        if (msg.contains(HELLO)) {
            msgServer = "HTTP/1.0 200 OK"
                    + System.lineSeparator()
                    + System.lineSeparator()
                    + "Hello, dear friend."
                    + System.lineSeparator();
        } else {
            msgServer = "HTTP/1.0 200 OK"
                    + System.lineSeparator()
                    + System.lineSeparator()
                    + "What?"
                    + System.lineSeparator();
        }
    }
}