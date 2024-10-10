package gg.jte.generated.ondemand.courses;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,10,10,10,10,12,12,12,12,12,12,12,12,12,13,13,13,13,13,13,13,13,13,16,16,16,16,16,16,16,16,16,17,17,19,19,20,20,22,22,22,22,22,22,22,22,22,22,22,22,23,23,23,25,25,26,26,28,28,28,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n<html>\r\n    <head>\r\n        <meta charset=\"utf-8\" />\r\n        <title>Хекслет</title>\r\n    </head>\r\n    <body>\r\n        <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n        <form action=\"/courses\" method=\"get\">\r\n            <input type=\"search\" name=\"term\"");
		var __jte_html_attribute_0 = page.getTerm();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n            <input type=\"search\" name=\"description\"");
		var __jte_html_attribute_1 = page.getDescription();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("/>\r\n            <input type=\"submit\" value=\"Search\" />\r\n        </form>\r\n        <a");
		var __jte_html_attribute_2 = NamedRoutes.buildCoursePath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Добавить курс</a>\r\n        ");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\r\n            <p>Пока не добавлено ни одного курса</p>\r\n        ");
		} else {
			jteOutput.writeContent("\r\n            ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\r\n               <div>\r\n                   <h2><a");
				var __jte_html_attribute_3 = NamedRoutes.coursePath(course.getId());
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(course.getName());
				jteOutput.writeContent("</a></h2>\r\n                   <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("</p>\r\n               </div>\r\n            ");
			}
			jteOutput.writeContent("\r\n        ");
		}
		jteOutput.writeContent("\r\n    </body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
