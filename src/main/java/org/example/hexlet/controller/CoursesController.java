package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void index(Context ctx) {
        List<Course> courses = CourseRepository.getEntities();
        var page = new CoursesPage(courses, "", "", "");
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
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
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }


    public static void update(Context ctx) {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//
//        var name = ctx.formParam("name");
//        var email = ctx.formParam("email");
//        var password = ctx.formParam("password");
//
//        var user = UserRepository.find(id)
//                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//        UserRepository.save(user);
        ctx.redirect(NamedRoutes.coursesPath());
    }

    public static void destroy(Context ctx) {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}