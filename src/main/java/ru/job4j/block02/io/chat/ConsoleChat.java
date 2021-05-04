package ru.job4j.block02.io.chat;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private final List<String> messagesBot;
    private List<String> messagesAll;
    private boolean enableBot;
    private final Charset charset;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.messagesBot = new ArrayList<>();
        this.messagesAll = new ArrayList<>();
        this.enableBot = true;
        this.charset = StandardCharsets.UTF_8;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter out = new BufferedWriter(
                    new FileWriter(path, charset, true))) {
                getMessagesListBot();
                String messageUser = in.readLine();
                messagesAll.add(messageUser + System.lineSeparator());
                while (checkOut(messageUser)) {
                    checkEnableBot(messageUser);
                    if (enableBot) {
                        String messageBot = getRandomMessageBot();
                        System.out.println(messageBot);
                        messagesAll.add(messageBot + System.lineSeparator());
                    }
                    messageUser = in.readLine();
                    messagesAll.add(messageUser + System.lineSeparator());
                }
                for (String msg : messagesAll) {
                    out.write(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkOut(String message) {
        return !message.equals(OUT);
    }

    private void checkEnableBot(String message) {
        if (message.equals(STOP)) {
            enableBot = false;
        } else if (message.equals(CONTINUE)) {
            enableBot = true;
        }
    }

    private void getMessagesListBot() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            for (String line = in.readLine();  line != null; line = in.readLine()) {
                messagesBot.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getRandomMessageBot() {
        return messagesBot.get((int) (Math.random() * (messagesBot.size() - 1)));
    }

    public static void main(String[] args) {
        String path = "./data/chat/log.txt";
        String botAnswers = "./data/chat/answers.txt";
        ConsoleChat cc = new ConsoleChat(path, botAnswers);
        cc.run();
    }
}