package gg.jte.generated.ondemand;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.MainPage2;
public final class Jteindex3Generated {
	public static final String JTE_NAME = "index3.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,14,14,14,14,14,14,14,14,14,14,15,15,16,16,16,18,18,21,21,21,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage2 page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n  <head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hello Hexlet!</title>\r\n  </head>\r\n  <body>\r\n    <main>\r\n      <h1>Привет, Хекслет!</h1>\r\n      <a");
		var __jte_html_attribute_0 = NamedRoutes.buildSessionPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Login</a>\r\n      ");
		if (page.getCurrentUser() != null) {
			jteOutput.writeContent("\r\n        Добро пожаловать, ");
			jteOutput.setContext("main", null);
			jteOutput.writeUserContent(page.getCurrentUser());
			jteOutput.writeContent(".\r\n        Чтобы разлогиниться, удалите куку JSESSIONID из браузера\r\n      ");
		}
		jteOutput.writeContent("\r\n    </main>\r\n  </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage2 page = (MainPage2)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
