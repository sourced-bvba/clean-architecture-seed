package be.sourcedbvba.seed;

import java.util.List;
import java.util.function.Consumer;

public interface GetUsers {
    void getUsers(Request request, Receiver receiver);

    class Request {

    }

    class Response {
        private List<UserResponse> users;

        public Response(List<UserResponse> users) {
            this.users = users;
        }

        public List<UserResponse> users() {
            return users;
        }
    }

    class UserResponse {
        private String name;

        public UserResponse(String name) {
            this.name = name;
        }

        public String name() {
            return name;
        }
    }

    interface Receiver extends Consumer<Response> {

    }
}
