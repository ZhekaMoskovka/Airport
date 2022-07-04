package App.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseFlightDTO {
    private String time;
    private String status;
    private String placeFrom;
    private String placeTo;
    private String gate;
    private String name;
}