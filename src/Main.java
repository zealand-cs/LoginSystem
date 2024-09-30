import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Liste af brugernavne og en anden list af passwords. Index 0 i usernames er korreleret med
        // index 0 i passwords. Et dictionary ville også være en god mulighed lige for dette program.
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

        // Simpel konfiguration af hvor mange forsøg man har til at logge ind.
        var maxTries = 3;
        var loggedIn = false;

        var scanner = new Scanner(System.in);

        // Loop det antal gange som maxtries beskriver.
        var username = "";
        for (int i = 0; i < maxTries; i++) {
            System.out.print("Skriv dit brugernavn: ");
            username = scanner.nextLine();

            // Hvis brugernavet ikke findes i usernames-arrayet, fortætter vi loopet
            // og bruger derved et forsøg.
            if (!Arrays.asList(usernames).contains(username)) {
                System.out.println("Brugernavn eksisterer ikke.");
                continue;
            }

            // Få indexet af brugernavnet, for at finde det tilsvarende password
            var usernameIndex = Arrays.asList(usernames).indexOf(username);

            System.out.print(STR."Skriv adgangskode til \{username}: ");
            var password = scanner.nextLine();

            // Tjek om det tilsvarende password er korrekt, ellers brug endnu et forsøg.
            // Nu får du også mulighed for at skrive brugernavnet igen.
            if (!passwords[usernameIndex].equals(password)) {
                System.out.println(STR."Forkert kode. \{maxTries - i} forsøg tilbage");
                continue;
            }

            loggedIn = true;
            break;
        }

        // Hvis du er logget ind, får du at vide hvad klokken er. Ellers får du en fejlbesked.
        if (loggedIn) {
            System.out.println(STR."Login er korrekt! Velkommen \{username}.");
            System.out.println(STR."Klokken er \{new Date()}");
        } else {
            System.out.println("Login forsøgt for mange gang. Kontoen er låst.");
        }
    }
}