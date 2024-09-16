import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var usernames = new String[]{
                "admin",
                "user1",
                "user2",
        };

        var passwords = new String[]{
                "password123",
                "letmein",
                "qwerty",
        };

        var maxTries = 3;
        var loggedIn = false;

        var scanner = new Scanner(System.in);

        var username = "";
        for (int i = 0; i < maxTries; i++) {
            System.out.print("Skriv dit brugernavn: ");
            username = scanner.nextLine();

            if (!Arrays.asList(usernames).contains(username)) {
                System.out.println("Brugernavn eksisterer ikke.");
                continue;
            }

            var usernameIndex = Arrays.asList(usernames).indexOf(username);

            System.out.print(STR."Skriv adgangskode til \{username}: ");
            var password = scanner.nextLine();

            if (!passwords[usernameIndex].equals(password)) {
                System.out.println(STR."Forkert kode. \{maxTries - i} forsøg tilbage");
                continue;
            }

            loggedIn = true;
            break;
        }

        if (loggedIn) {
            System.out.println(STR."Login er korrekt! Velkommen \{username}.");
            System.out.println(STR."\{new Date()}");
        } else {
            System.out.println("Login forsøgt for mange gang. Kontoen er låst.");
        }
    }
}