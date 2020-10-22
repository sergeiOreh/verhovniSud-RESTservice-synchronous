package by.compit.verhovni.sud.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс ApplicationInitializer является классом-инициализатором,
 * который вызывает класс конфигурации при запуске приложения.
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Происходит вызыв классов конфигурации при запуске приложения.
     */
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfig.class };
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}