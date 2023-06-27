package bg.softuni.Accounts;

import bg.softuni.Accounts.models.User;
import bg.softuni.Accounts.services.AccountService;
import bg.softuni.Accounts.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AccountService accountService;

    private final UserService userService;

    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User randomUser = new User("Pesho",20);
        userService.register(randomUser);
    }
}
