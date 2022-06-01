package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestTicketDTO {
    String name;
    String passportNumber;
    String place;
    String placeFrom;
    String placeTo;
    String time;
}