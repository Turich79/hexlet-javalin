@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<html>
    <head>
        <meta charset="utf-8" />
        <title>Хекслет</title>
    </head>
    <body>
        <h1>${page.getHeader()}</h1>
        <form action="/courses" method="get">
            <input type="search" name="term" value="${page.getTerm()}"/>
            <input type="search" name="description" value="${page.getDescription()}"/>
            <input type="submit" value="Search" />
        </form>
        <a href="${NamedRoutes.buildCoursePath()}">Добавить курс</a>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : page.getCourses())
               <div>
                   <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
    </body>
</html>