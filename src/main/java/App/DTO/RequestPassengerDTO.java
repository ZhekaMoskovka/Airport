package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPassengerDTO {
    @NotNull(message = "You must enter your name")
    private String name;
    @NotNull(message = "You must enter your passport number")
    private String passportNumber;
    @NotNull(message = "You must enter your password")
    private String password;
    @NotNull(message = "You must enter your birthday")
    private LocalDate birthday;
}