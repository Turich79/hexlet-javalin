package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {27,27,27,27,27,27,27,27,27,27,27};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<meta charset=\"utf-8\" />\r\n<form action=\"/users\" method=\"post\">\r\n  <div>\r\n    <label>\r\n      Имя\r\n      <input type=\"text\" name=\"name\" />\r\n    </label>\r\n  </div>\r\n  <div>\r\n    <label>\r\n      Email\r\n      <input type=\"email\" required name=\"email\" />\r\n    </label>\r\n  </div>\r\n  <div>\r\n    <label>\r\n      Пароль\r\n      <input type=\"password\" required name=\"password\" />\r\n    </label>\r\n  </div>\r\n  <div>\r\n    <label>\r\n      Подтверждение пароля\r\n      <input type=\"password\" required name=\"passwordConfirmation\" />\r\n    </label>\r\n  </div>\r\n  <input type=\"submit\" value=\"Зарегистрировать\" />\r\n</form>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
