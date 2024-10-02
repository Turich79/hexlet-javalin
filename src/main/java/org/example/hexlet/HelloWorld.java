package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        less7();
//        less6();
//        less5();
//        less4();
//        less3();
    }

    public static void less7() {
//        var app = Javalin.create(config -> {
//            config.bundledPlugins.enableDevLogging();
//        });
        // Название параметров мы выбрали произвольно
//        app.get("/courses/{id}", ctx -> {
//            var id = ctx.pathParam("id");
//            var course = /* Курс извлекается из базы данных */
//                    // Предполагаем, что у курса есть метод getName()
////                    ctx.result("<h1>" + course.getName() + "</h1>");
//                    ctx.result("<h1>Course</h1>");
//        });

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));

        var courses = new ArrayList<Course>();

        courses.add(new Course(1,"progging", "course about progging"));
        courses.add(new Course(2,"progging2", "course about progging2"));
        courses.add(new Course(3,"progging3", "course about progging3"));

        app.get("/courses/{id}", ctx -> {
//            var id = ctx.pathParam("id");
            var id = ctx.pathParamAsClass("id", Integer.class).get();
//            var course = courses.get(id);//new Course("progging","course about progging");
            var course = courses.stream().filter(c->c.getId()==id).findFirst().get();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get("/courses", ctx -> {

            /* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */

            var header = "progging courses";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.start(7070);
    }

    public static void less6() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // Название параметров мы выбрали произвольно
        app.get("/courses/{courseId}/lessons/{id}", ctx -> {
            var courseId = ctx.pathParam("courseId");
            var lessonId = ctx.pathParam("id");
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
