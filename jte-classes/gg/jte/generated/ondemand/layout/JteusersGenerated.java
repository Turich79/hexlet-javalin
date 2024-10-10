package gg.jte.generated.ondemand.layout;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteusersGenerated {
	public static final String JTE_NAME = "layout/users.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,6,6,7,7,7,7,7,7,7,7,7,8,8,9,9,9,10,10,11,11,11,11,11,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <a");
				var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">New User</a>\r\n        ");
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
