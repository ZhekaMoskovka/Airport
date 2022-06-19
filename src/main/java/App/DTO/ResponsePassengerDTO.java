package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePassengerDTO {
    private String name;
    private String passportNumber;
    private LocalDate birthday;
    private List<ResponseTicketDTO> responseTicketDTO;
}