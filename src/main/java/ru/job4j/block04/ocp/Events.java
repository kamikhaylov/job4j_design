package ru.job4j.block04.ocp;

public class Events {
    private String event;

    public Events(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public String action(String event) {
        if (event.equals("Семинар")) {
            return "Подготовить презентацию";
        } else if (event.equals("Обед")) {
            return "Забронировать стол";
        } else if (event.equals("Встреча с клиентом")) {
            return "Изучить аналитику";
        }
        return "Ожидание событий";
    }
}
