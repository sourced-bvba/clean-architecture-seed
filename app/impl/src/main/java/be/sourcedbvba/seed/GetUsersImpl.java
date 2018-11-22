package be.sourcedbvba.seed;

import java.util.function.Function;
import java.util.stream.Collectors;

public class GetUsersImpl implements GetUsers {
    private UserGateway userGateway;

    public GetUsersImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void getUsers(Request request, Receiver receiver) {
        GetUsers.Response response = new GetUsers.Response(userGateway.getUsers()
                .stream()
                .map(user -> new UserResponse(user.name()))
                .collect(Collectors.toList()));
        receiver.accept(response);
    }
}
