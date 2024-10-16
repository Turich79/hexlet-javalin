package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.dto.MainPage2;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        less18();
//        less17();
//        less15();
//        less13();
//        less12();
//        less11();
//        less10();
//        myTest();
//        less8(); ////этот урок надо пересмотреть и доделать!!!
//        less7();
//        less6();
//        less5();
//        less4();
//        less3();
    }

    private static void less18() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            var page = new MainPage2(ctx.sessionAttribute("currentUser"));
            ctx.render("index3.jte", model("page", page));
        });

        // Отображение формы логина
        app.get("/sessions/build", SessionsController::build);
        // Процесс логина
        app.post("/sessions", SessionsController::create);
        // Процесс выхода из аккаунта
        app.delete("/sessions", SessionsController::destroy);

        app.start(7070);
    }

    public static void less17() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            var visited = Boolean.valueOf(ctx.cookie("visited"));
            var page = new MainPage(visited);
            ctx.render("index2.jte", model("page", page));
            ctx.cookie("visited", String.valueOf(true));
        });

        app.start(7070);
    }

    public static void less15() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));
        ////Users
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get("/users/{id}", UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get("/users/{id}/edit", UsersController::edit);
        app.patch("/users/{id}", UsersController::update);
        app.delete("/users/{id}", UsersController::destroy);
        ////Courses
        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get("/courses/{id}", CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get("/courses/{id}/edit", CoursesController::edit);
        app.patch("/courses/{id}", CoursesController::update);
        app.delete("/courses/{id}", CoursesController::destroy);

        app.start(7070);
    }

    public static void less13() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));

        app.get(NamedRoutes.usersPath(), ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("layout/users.jte", model("page", page));
        });

        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
            var name = ctx.formParam("name").trim();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            var email = ctx.formParam("email").trim().toLowerCase();

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                        .check(value -> value.length() > 6, "У пароля недостаточная длина")
                        .get();
                var user = new User(name, email, password);
                UserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
            }
        });

        app.get(NamedRoutes.coursesPath(), ctx -> {
            List<Course> courses = CourseRepository.getEntities();
            var page = new CoursesPage(courses, "", "", "");
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get(NamedRoutes.buildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/build.jte", model("page", page));
        });

        app.post(NamedRoutes.coursesPath(), ctx -> {
            String name = "";
            String description = "";
            try {
                name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "У имени недостаточная длина, должно быть не меньше 2")
                        .get();
                description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "У описания недостаточная длина, должно быть не меньше 10")
                        .get();
                var course = new Course(name, description);
                CourseRepository.save(course);
                ctx.redirect("/courses");
            } catch (ValidationException e) {
                var page = new BuildCoursePage(name, description, e.getErrors());
                ctx.render("courses/build.jte", model("page", page));
            }
        });

        app.start(7070);
    }

    public static void less12() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("layout/users.jte", model("page", page));
        });

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");

            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.start(7070);
    }

    public static void myTest() {
        var courses = new ArrayList<Course>();

        courses.add(new Course(1, "java", "course about java"));
        courses.add(new Course(2, "pyton", "course about pyton"));
        courses.add(new Course(3, "php", "course about php"));
        var term = "java";
        var findCourses = courses.stream().filter(c -> c.getName().contentEquals(term)).
                collect(Collectors.toUnmodifiableList());
        System.out.println(findCourses);
    }

    public static void less10() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));

        var courses = new ArrayList<Course>();

        courses.add(new Course(1, "java", "course about java"));
        courses.add(new Course(2, "pyton", "course about pyton"));
        courses.add(new Course(3, "php", "course about php"));

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            var description = ctx.queryParam("description");
            ArrayList<Course> findCourses = new ArrayList<>(courses);
            // Фильтруем, только если была отправлена форма
            if (term != null) {
                var findedCourses = courses.stream().filter(c -> c.getName().contentEquals(term)).
                        collect(Collectors.toUnmodifiableList());
                findCourses = new ArrayList<>(findedCourses);
            }
            if (description != null) {
                var findedCourses = courses.stream().filter(c -> c.getDescription().contains(description)).
                        collect(Collectors.toUnmodifiableList());
                findCourses = new ArrayList<>(findedCourses);
            }
            var page = new CoursesPage(findCourses, term, "courses", description);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            var course = courses.stream().filter(c -> c.getId().equals(id)).findFirst().get();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });
        app.start(7070);
    }

    public static void less8() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
//        app.get("/", ctx -> ctx.render("layout/page.jte"));

        var users = new ArrayList<User>();

        users.add(new User(1l, "Vasya", "a1@ma.ru", "1234"));
        users.add(new User(2l, "Lena", "a2@ma.ru", "2222"));
        users.add(new User(3l, "Sasha", "a3@aa.ru", "1111"));

        app.get("/", ctx -> {
//            var id = ctx.pathParamAsClass("id", Integer.class).get();
//            var usersString =users.stream().map(u->u.getName()).toList();
//            String[] usersString = {"Vasya", "Misha"};
            var page = new UsersPage(UserRepository.getEntities());
            ctx.render("layout/page.jte", model("page", page));
        });


        app.start(7070);
    }

    public static void less7() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));

        var courses = new ArrayList<Course>();

        courses.add(new Course(1, "progging", "course about progging"));
        courses.add(new Course(2, "progging2", "course about progging2"));
        courses.add(new Course(3, "progging3", "course about progging3"));

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).get();
            var course = courses.stream().filter(c -> c.getId().equals(id)).findFirst().get();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        app.get("/courses", ctx -> {

            /* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */

            var header = "progging courses";
            var page = new CoursesPage(courses, header, "course", "");
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
