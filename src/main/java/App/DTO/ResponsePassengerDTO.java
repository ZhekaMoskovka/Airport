package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePassengerDTO {
    private String name;
    private String passportNumber;
    private String birthday;
    private List<ResponseTicketDTO> responseTicketDTO;
}