package be.sourcedbvba.seed;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserResource {

    private GetUsers getUsers;

    public UserResource(GetUsers getUsers) {
        this.getUsers = getUsers;
    }

    @GetMapping
    public List<UserViewModel> getUsers() {
        GetUsersViewModelReceiver receiver = new GetUsersViewModelReceiver();
        getUsers.getUsers(new GetUsers.Request(), receiver);
        return receiver.result();
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
    private class UserViewModel {
        private String name;

        UserViewModel(String name) {
            this.name = name;
        }

        public String name() {
            return name;
        }
    }

    public class GetUsersViewModelReceiver implements GetUsers.Receiver {
        private List<UserViewModel> result;

        @Override
        public void accept(GetUsers.Response response) {
            result = response.users().stream()
                    .map(new Function<GetUsers.UserResponse, UserViewModel>() {
                        @Override
                        public UserViewModel apply(GetUsers.UserResponse userResponse) {
                            return new UserViewModel(userResponse.name());
                        }
                    })
                    .collect(Collectors.toList());
        }

        List<UserViewModel> result() {
            return result;
        }
    }
}
