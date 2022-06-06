package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTicketDTO {
    private String place;
    private String placeFrom;
    private String placeTo;
    private String time;
}