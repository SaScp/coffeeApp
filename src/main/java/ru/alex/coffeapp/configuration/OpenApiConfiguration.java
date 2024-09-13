package ru.alex.coffeapp.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Coffee API",
                description = "Кофемашина", version = "1.0.0",
                contact = @Contact(
                        name = "Alex",
                        email = "vorobievalexander10@gmail.com",
                        url = "https://github.com/SaScp"
                )
        )
)
public class OpenApiConfiguration {
}
