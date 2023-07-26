package bg.softuni.gamestore.entities.users;

import bg.softuni.gamestore.exceptions.ValidationException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @Email(message = "Incorrect email.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,}$",message = "Enter valid password. The password must be at least 6 symbols and must contain at least 1 uppercase, 1 lowercase letter and 1 digit.")
    private String password;

    private String confirmPassword;

    @Size(min = 3)
    private String fullName;

    public RegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    public RegisterDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

}
