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
    String name;
    String passportNumber;
    String birthday;
    List<ResponseTicketDTO> responseTicketDTO;
}