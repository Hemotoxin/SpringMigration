package me.personal.SpringMigration.config.swagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        var openApi = new OpenAPI()
                .info(
                        new Info()
                                .title("This will be the Api documentation")
                                .description("Documentation is an essential part of building REST APIs. ")
                                .version("1.0.0")
                                .termsOfService("http://terms-of-services.url"));

        return openApi;
    }
}