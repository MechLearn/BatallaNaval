package com.battlegames.batallanaval;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ClientePrueba {

    // Cambia "localhost" por la IP de un compañero (ej: 192.168.1.50)
    private static final String SERVER_URL = "http://localhost:8080/api/gamers";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("--- CLIENTE DE BATALLA NAVAL ---");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Entrar como Invitado");
        System.out.print("Elige una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        try {
            switch (opcion) {
                case 1 -> registrarse(scanner, client);
                case 2 -> login(scanner, client);
                case 3 -> invitado(client);
                default -> System.out.println("Opción no válida");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    private static void registrarse(Scanner scanner, HttpClient client) throws Exception {
        System.out.print("Ingresa tu Nickname: ");
        String nick = scanner.nextLine();
        System.out.print("Ingresa tu Password: ");
        String pass = scanner.nextLine();

        // se crea un JSON  (para no configurar librerías extra)
        String json = String.format("{\"nickname\":\"%s\", \"password\":\"%s\"}", nick, pass);

        enviarPeticion(client, SERVER_URL + "/register", json);
    }

    private static void login(Scanner scanner, HttpClient client) throws Exception {
        System.out.print("Nickname: ");
        String nick = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        String json = String.format("{\"nickname\":\"%s\", \"password\":\"%s\"}", nick, pass);

        enviarPeticion(client, SERVER_URL + "/login", json);
    }

    private static void invitado(HttpClient client) throws Exception {
        // Invitado manda un JSON vacío o null, el endpoint no pide body pero POST requiere algo
        enviarPeticion(client, SERVER_URL + "/login-guest", "{}");
    }

    private static void enviarPeticion(HttpClient client, String url, String json) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        System.out.println("Enviando datos al servidor...");

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("--------------------------------");
        System.out.println("RESPUESTA DEL SERVIDOR (CÓDIGO " + response.statusCode() + "):");
        System.out.println(response.body());
        System.out.println("--------------------------------");
    }
}