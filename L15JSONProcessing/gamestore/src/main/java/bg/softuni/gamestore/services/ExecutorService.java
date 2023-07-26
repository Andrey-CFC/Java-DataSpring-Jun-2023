package bg.softuni.gamestore.services;

public interface ExecutorService {
    String REGISTER_USER_COMMAND = "RegisterUser";
    String LOGIN_USER_COMMAND = "LoginUser";
    String LOGOUT_USER_COMMAND = "Logout";
    String ADD_GAME_COMMAND = "AddGame";

    String execute(String command, String data);

    String REGISTER_USER_JSON = """
            {
            "email" : "andrey26@mail.com",
            "password" : "CH3LS3A",
            "confirmPassword" : "CH3LS3A",
            "fullName" : "Andrey Andreev"
            }
            """;
    String LOGIN_USER_JSON = """
            {
            "email" : "andrey26@mail.com",
            "password" : "CH3LS3A"
            }
            """;
}
//{ "email" : "andrey26@mail.com", "password" : "CH3LS3A", "confirmPassword" : "CH3LS3A"," fullName" : "Andrey Andreev"}
