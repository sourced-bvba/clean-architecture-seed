package be.sourcedbvba.seed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfiguration {
    @Bean
    public UserGateway userGateway() {
        return new UserGatewayImpl();
    }

    @Bean
    public GetUsers getUsers(UserGateway userGateway) {
        return new GetUsersImpl(userGateway);
    }
}
