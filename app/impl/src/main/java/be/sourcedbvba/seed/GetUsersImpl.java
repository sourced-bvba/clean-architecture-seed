package be.sourcedbvba.seed;

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
                .map(u -> new GetUsers.UserResponse(u.name()))
                .collect(Collectors.toList()));
        receiver.accept(response);
    }
}
