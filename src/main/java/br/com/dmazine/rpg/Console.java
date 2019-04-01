package br.com.dmazine.rpg;

public class Console {

    public enum Color {

        RESET("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void write(String text) {
        print(text);
    }

    public static void writeln() {
        println();
    }

    public static void writeln(String text) {
        println(text);
    }

    public static void write(String text, Color color) {
        print(buildColoredText(text, color));
    }

    public static void writeln(String text, Color color) {
        println(buildColoredText(text, color));
    }

    private static String buildColoredText(String text, Color color) {
        if (text == null) {
            return null;
        }

        return String.format("%s%s%s", color.getValue(), text, Color.RESET.getValue());
    }

    private static void print(String text) {
        if (text == null) {
            return;
        }

        System.out.print(text);
    }

    private static void println() {
        System.out.println();
    }

    private static void println(String text) {
        if (text == null) {
            return;
        }

        System.out.println(text);
    }

}
