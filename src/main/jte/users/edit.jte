@import org.example.hexlet.NamedRoutes

@template.layout.page(
    content = @`
        <title>Edit user</title>
        <a href="${NamedRoutes.buildUserPath()}">New User</a>
        <a href="${NamedRoutes.usersPath()}">New User</a>
    `
)