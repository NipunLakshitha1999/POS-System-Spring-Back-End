package lk.ijse.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class webAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{webRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{webAppConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};

    }
}
