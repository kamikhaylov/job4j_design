package ru.job4j.block02.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final String EXIT = "Exit";
    private static final String HELLO = "Hello";
    private static final String WHAT = "WHAT";
    private static final String NOT_MESSAGE = "GET / HTTP/1.1";
    private static final String START_MESSAGE = "HTTP/1.0 200 OK"
                                                + System.lineSeparator()
                                                + System.lineSeparator();
    private static final String IN_MSG = "/?msg=";
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
                        if (str.contains(IN_MSG)) {
                            outMsg(str);
                        } else if (str.contains(NOT_MESSAGE)) {
                            notMsg(str);
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
        if (msg.contains(EXIT)) {
            status = false;
            msgServerExit = START_MESSAGE
                    + "Server Exit"
                    + System.lineSeparator();
        }
    }

    private static void outMsg(String msg) {
        if (msg.contains(HELLO)) {
            msgServer = START_MESSAGE
                    + "Hello, dear friend."
                    + System.lineSeparator();
        } else {
            msgServer = START_MESSAGE
                + "What?"
                + System.lineSeparator();
        }
    }

    private static void notMsg(String msg) {
        msgServer = START_MESSAGE;
    }
}