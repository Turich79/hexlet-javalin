@import org.example.hexlet.dto.courses.BuildCoursePage
  @param BuildCoursePage page

  @if(page.getErrors() != null)
      <ul>
          @for(var validator : page.getErrors().values())
              @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
          @endfor
      </ul>
  @endif
  <meta charset="utf-8" />
<form action="/courses" method="post">
  <div>
    <label>
      Название курса
      <input type="text" name="name" value="${page.getName()}" />
    </label>
  </div>
  <div>
    <label>
      Описание курса
      <input type="textarea" required name="description" value="${page.getDescription()}" />
    </label>
  </div>
  <input type="submit" value="Добавить курс" />
</form>