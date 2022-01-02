package ru.job4j.block04.ocp;

public class Developer {
    private static class JavaDev {
        public String write() {
            return "Java code";
        }
    }

    private static class PhpDev extends JavaDev {
        @Override
        public String write() {
            return "PHP code";
        }
    }
}
