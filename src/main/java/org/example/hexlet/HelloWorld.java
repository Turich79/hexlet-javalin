package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        //less 1
        app.get("/", ctx -> ctx.result("Hello World"));
        //less 2
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        //less 3
        app.get("/hello", ctx -> {
            ctx.result("Hello new World");
        });
        app.start(7070);
    }
}
