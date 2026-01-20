import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafConfig {

    public static TemplateEngine engine;

    public static TemplateEngine templateEngine() {
        if (engine == null) {

            ClassLoaderTemplateResolver resolver =
                    new ClassLoaderTemplateResolver();

            resolver.setPrefix("/templates/");
            resolver.setSuffix(".html");
            resolver.setTemplateMode("HTML");
            resolver.setCharacterEncoding("UTF-8");

            engine = new TemplateEngine();
            engine.setTemplateResolver(resolver);
        }
        return engine;
    }
}