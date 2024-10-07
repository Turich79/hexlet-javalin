package gg.jte.generated.ondemand.layout;
import org.example.hexlet.dto.UsersPage;
public final class JteusersGenerated {
	public static final String JTE_NAME = "layout/users.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,7,8,8,8,9,9,10,10,10,10,10,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <a href=\"/users/build\">New User</a>\r\n        ");
				for (var user : page.getUsers()) {
					jteOutput.writeContent("\r\n            <div>");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(user.getName());
					jteOutput.writeContent("</div>\r\n        ");
				}
				jteOutput.writeContent("\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
