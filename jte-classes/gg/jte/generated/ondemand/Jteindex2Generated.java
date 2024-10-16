package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class Jteindex2Generated {
	public static final String JTE_NAME = "index2.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,13,13,13,15,15,16,16,18,18,21,21,21,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"ru\">\r\n  <head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hello Hexlet!</title>\r\n  </head>\r\n  <body>\r\n    <main>\r\n      <h1>Привет, Хекслет! пишем куки</h1>\r\n      ");
		if (!page.isVisited()) {
			jteOutput.writeContent("\r\n        Это сообщение показывается только один раз. Если вы хотите увидеть его снова, сотрите куки\r\n      ");
		}
		jteOutput.writeContent("\r\n      ");
		if (page.isVisited()) {
			jteOutput.writeContent("\r\n         А это сообщение показывает, что куки записаны\r\n      ");
		}
		jteOutput.writeContent("\r\n    </main>\r\n  </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
