package kr.re.inspace;

public class UserService {

    public UserVO getUsersByID(String username) {
        return new UserVO(username, "password");
    }

}
