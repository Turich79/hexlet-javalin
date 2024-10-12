@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <title>Show user</title>
        <a href="${NamedRoutes.buildUserPath()}">New User</a>
        <a href="${NamedRoutes.usersPath()}">New User</a>
    `
)