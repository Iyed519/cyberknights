package tn.coconsultbackend.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info  = @Info(
                contact = @Contact(
                        name = "Iyed",
                        email = "omri.iyed@esprit.tn",
                        url = "https://www.facebook.com/profile.php?id=61566192271940"
                ),
                description = "OpenAPI documentation",
                title = "OpenApi documentation - IyedOmri",
                version = "1.0",
                license = @License(
                        name = "test name",
                        url = "http://testurl.com"
                ),
                termsOfService = "Term of service"
        ),
        servers = {
                @Server(
                        description = "Local Env",
                        url = "http:=//localhost:8088/api/v1"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description =  "this is a JWT  authentification description ",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

}
