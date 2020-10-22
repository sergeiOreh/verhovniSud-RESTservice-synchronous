package by.compit.verhovni.sud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Класс ApplicationConfig является конфигурационным классом проекта.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "by.compit.verhovni.sud")
@PropertySource("classpath:settings.properties")
public class ApplicationConfig {

    /**
     * Путь к сгенерированным при компиляции проекта классам.
     */
    private static String CONTEXT_PATH = "supremeCourt.wsdl";

    /**
     * @return объект класса Jaxb2Marshaller, который формирует xml из java-файлов,
     * находящихся в определённой директории
     */
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(CONTEXT_PATH);
        return marshaller;
    }
}
