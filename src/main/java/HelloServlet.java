import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //resp.getWriter().println("Hej från /hello");

        //String name = req.getParameter("name");
        //resp.getWriter().println("Hej " + name);

        //String path = req.getPathInfo();
        //kolla om värdet finns och ta bort / från värdet
        //String name = (path != null && path.length() > 1) ? path.substring(1) : "världen";
        //skriv ut värdet
        //resp.getWriter().println("Hej " + name);

        String name = req.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "världen";
        }

        Context context = new Context();
        context.setVariable("name", name);

        resp.setContentType("text/html; charset=UTF-8");

        TemplateEngine engine = ThymeleafConfig.templateEngine();
        engine.process("hello", context, resp.getWriter());
    }
}
