package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        less6();
//        less5();
//        less4();
//        less3();
    }

    public static void less6() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // Название параметров мы выбрали произвольно
        app.get("/courses/{courseId}/lessons/{id}", ctx -> {
            var courseId = ctx.pathParam("courseId");
            var lessonId =  ctx.pathParam("id");
            ctx.result("Course ID: " + courseId + " Lesson ID: " + lessonId);
        });

        app.start(7070);
        //http://localhost:7070/courses/curs1/lessons/less1
    }

    public static void less5() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World!");
//            var name=ctx.queryParam("name");
            var congratulation = "Hello, " + name;
            ctx.result(congratulation);
        });
        app.start(7070);
    }

    public static void less4() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.start(7070);
    }

    public static void less3() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070);
    }
}
