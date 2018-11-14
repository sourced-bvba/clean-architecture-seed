package be.sourcedbvba.seed;

import java.util.Arrays;
import java.util.List;

public class UserGatewayImpl implements UserGateway {
    @Override
    public List<User> getUsers() {
        return Arrays.asList(
                new User("John Doe"),
                new User("Jane Doe")
        );
    }
}
