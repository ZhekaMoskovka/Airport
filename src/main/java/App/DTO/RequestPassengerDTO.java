package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestPassengerDTO {
    private String name;
    private String passportNumber;
    private String birthday;
}