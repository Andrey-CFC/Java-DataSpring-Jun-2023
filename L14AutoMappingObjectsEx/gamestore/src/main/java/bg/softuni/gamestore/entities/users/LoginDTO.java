package bg.softuni.gamestore.entities.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class LoginDTO {

    @Email(message = "Incorrect email.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,}$",message = "Enter valid password. The password must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit.")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
